import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Relation {

	private String name;
	private ArrayList<Tuple> tuples;
	public ArrayList<Attribute> attributes;
	private Schema s;

	public Relation(String name, Collection<Attribute> attrs) {

		this.name = name;
		this.attributes = new ArrayList<Attribute>(attrs);
		this.tuples = new ArrayList<Tuple>();
	}

	public Relation(String name, Collection<Attribute> attrs, Collection<Tuple> tuples) {

		this.name = name;
		this.attributes = new ArrayList<Attribute>(attrs);
		this.tuples = new ArrayList<>(tuples);

	}

	public void setSchema(Schema s) {
		this.s = s;
	}

	public String getRelationName() {
		return name;
	}

	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}

	public ArrayList<Tuple> select(String ConditionAttribute, String operator, Object literal) {
		ArrayList<Tuple> filteredTuples = new ArrayList<Tuple>();
		switch (operator) {
		case "=": {
			for (Tuple t : this.tuples) {
				if (t.getAttribute(ConditionAttribute).equals(literal)) {
					filteredTuples.add(t);
				}
			}
			break;
		}
		case ">": {
			String classType = null;
			for (Attribute a : this.getAttributes()) {
				if (a.getName().equals(ConditionAttribute)) {
					if (a.getType().equals(Integer.class)) {
						classType = "Integer";
					} else {
						classType = "String";
					}
				} else {
					continue;
				}
				if (classType.equals("String")) {
					for (Tuple t : this.tuples) {
						if (t.getAttribute(ConditionAttribute).toString().compareTo(literal.toString()) > 0) {
							filteredTuples.add(t);
						}
					}
				} else {
					for (Tuple t : this.tuples) {
						if ((Integer) t.getAttribute(ConditionAttribute) > (Integer) literal) {
							filteredTuples.add(t);
						}
					}
				}
			}
			break;
		}

		case "<": {
			String classType = null;
			for (Attribute a : this.attributes) {
				if (a.getName().equals(ConditionAttribute)) {
					if (a.getType().equals(Integer.class)) {
						classType = "Integer";
					} else {
						classType = "String";
					}
				} else {
					continue;
				}
				if (classType.equals("String")) {
					for (Tuple t : this.tuples) {
						if (t.getAttribute(ConditionAttribute).toString().compareTo(literal.toString()) < 0) {
							filteredTuples.add(t);
						}
					}
				} else {
					for (Tuple t : this.tuples) {
						if ((Integer) t.getAttribute(ConditionAttribute) < (Integer) literal) {
							filteredTuples.add(t);
						}
					}
				}
			}
			break;
		}
		default:

		}
		return filteredTuples;
	}

	public Relation projection(ArrayList<String> list) {
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		ArrayList<Attribute> newAttributes = new ArrayList<Attribute>();
		ArrayList<Tuple> newTuples = new ArrayList<Tuple>();
		attributes = this.getAttributes();
		for (String s : list) {
			for (Attribute atr : attributes) {
				if (atr.getName().equals(s)) {
					newAttributes.add(atr);
					break;
				}
			}
		}
		for (Tuple t : tuples) {
			HashMap<String, Object> projectedTuple = new HashMap<String, Object>();
			for (Attribute attr : newAttributes) {
				projectedTuple.put(attr.getName(), t.getAttribute(attr.getName()));
			}
			Tuple newTup = new Tuple(projectedTuple);
			newTuples.add(newTup);
		}
		Relation r = new Relation("Result_Set", newAttributes, newTuples);
		return r;
	}

	public Relation selection(String ConditionAttribute, String operator, Object literal) {
		ArrayList<Tuple> t = new ArrayList<Tuple>();
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		attributes = this.getAttributes();
		t = select(ConditionAttribute, operator, literal);
		Relation r = new Relation("Selection_Result", attributes, t);
		return r;
	}

	public void Union(Relation r2) {
		ArrayList<Attribute> firstRelationAttributes = this.getAttributes();
		ArrayList<Attribute> secondRelationAttributes = r2.getAttributes();
		int n1 = firstRelationAttributes.size();
		int n2 = secondRelationAttributes.size();
		HashSet<String> UnionSet = new HashSet<String>();
		if (n1 != n2) {
			System.out.println("Mismatch! Attributes cardinality.");
			return;
		}
		for (int i = 0; i < firstRelationAttributes.size(); i++) {
			if (!firstRelationAttributes.get(i).getType().equals(secondRelationAttributes.get(i).getType())) {
				System.out.println("Mismatch! Type Compatibility");
				return;
			}
		}
		for (Tuple t : this.tuples) {
			UnionSet.add(t.toString());
		}
		for (Tuple t : r2.tuples) {
			UnionSet.add(t.toString());
		}
		System.out.println("UNION_RESULT");
		Iterator<String> i = UnionSet.iterator();
		while (i.hasNext()) {
			String[] splitResult = i.next().split(" : ");
			System.out.println(splitResult[1]);
		}
	}

	public void Intersection(Relation r2) {
		ArrayList<Attribute> firstRelationAttributes = this.getAttributes();
		ArrayList<Attribute> secondRelationAttributes = r2.getAttributes();
		int n1 = firstRelationAttributes.size();
		int n2 = secondRelationAttributes.size();
		HashSet<String> IntersectionSet = new HashSet<String>();
		if (n1 != n2) {
			System.out.println("Mismatch! Attributes cardinality.");
			return;
		}
		for (int i = 0; i < firstRelationAttributes.size(); i++) {
			if (!firstRelationAttributes.get(i).getType().equals(secondRelationAttributes.get(i).getType())) {
				System.out.println("Mismatch! Type Compatibility");
				return;
			}
		}
		String[] splitResult1;
		String[] splitResult2;
		String first;
		String second;
		for (Tuple t : this.tuples) {
			splitResult1 = t.toString().split(" : ");
			first = splitResult1[1];
			for (Tuple t1 : r2.tuples) {
				splitResult2 = t1.toString().split(" : ");
				second = splitResult2[1];
				if (second.equals(first)) {
					IntersectionSet.add(second);
				}
			}
		}
		Iterator<String> i = IntersectionSet.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

	public void setDifference(Relation r2) {
		ArrayList<Attribute> firstRelationAttributes = this.getAttributes();
		ArrayList<Attribute> secondRelationAttributes = r2.getAttributes();
		int n1 = firstRelationAttributes.size();
		int n2 = secondRelationAttributes.size();
		HashSet<String> DifferenceSet = new HashSet<String>();
		if (n1 != n2) {
			System.out.println("Mismatch! Attributes cardinality.");
			return;
		}
		for (int i = 0; i < firstRelationAttributes.size(); i++) {
			if (!firstRelationAttributes.get(i).getType().equals(secondRelationAttributes.get(i).getType())) {
				System.out.println("Mismatch! Type Compatibility");
				return;
			}
		}
		String[] splitResult1;
		String[] splitResult2;
		String first;
		String second;
		for (Tuple t : this.tuples) {
			splitResult1 = t.toString().split(" : ");
			first = splitResult1[1];
			boolean difference = true;
			for (Tuple t1 : r2.tuples) {
				splitResult2 = t1.toString().split(" : ");
				second = splitResult2[1];
				if (second.equals(first)) {
					difference = false;
					break;
				}
			}
			if (difference) {
				DifferenceSet.add(first);
			}
		}
		Iterator<String> i = DifferenceSet.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

	public Relation cartesianProduct(Relation r2) {
		ArrayList<Attribute> newAttributes = new ArrayList<Attribute>();
		ArrayList<Attribute> firstAttributes = this.getAttributes();
		ArrayList<Attribute> secondAttributes = r2.getAttributes();
		ArrayList<Tuple> tuple = new ArrayList<Tuple>();
		for (int i = 0; i < firstAttributes.size(); i++) {
			newAttributes.add(new Attribute(this.name + "." + firstAttributes.get(i).getName(),
					firstAttributes.get(i).getType()));
		}
		for (int i = 0; i < secondAttributes.size(); i++) {
			newAttributes.add(new Attribute(r2.name + "." + secondAttributes.get(i).getName(),
					secondAttributes.get(i).getType()));
		}
		for (Tuple t : this.tuples) {
			Tuple newTup = null;
			HashMap<String, Object> map = new HashMap<String, Object>();
			for (Attribute att : this.getAttributes()) {
				map.put(this.name + "." + att.getName(), t.getAttribute(att.getName()));
			}
			for (Tuple t1 : r2.tuples) {
				for (Attribute att1 : r2.getAttributes()) {
					map.put(r2.name + "." + att1.getName(), t1.getAttribute(att1.getName()));
				}
				newTup = new Tuple(map);
				tuple.add(newTup);
			}

		}
		Relation r = new Relation("CARTESIAN_RESULT", newAttributes, tuple);
		return r;
	}

	public Relation equijoin(ArrayList<String> attribute1, Relation r2, ArrayList<String> attribute2) {
		ArrayList<Attribute> newAttributes = new ArrayList<Attribute>();
		ArrayList<Attribute> firstAttributes = this.getAttributes();
		ArrayList<Attribute> secondAttributes = r2.getAttributes();
		ArrayList<Tuple> tuple = new ArrayList<Tuple>();
		for (int i = 0; i < firstAttributes.size(); i++) {
			newAttributes.add(new Attribute(this.name + "." + firstAttributes.get(i).getName(),
					firstAttributes.get(i).getType()));
		}
		for (int i = 0; i < secondAttributes.size(); i++) {
			newAttributes.add(new Attribute(r2.name + "." + secondAttributes.get(i).getName(),
					secondAttributes.get(i).getType()));
		}

		for (Tuple t : this.tuples) {
			Tuple newTup = null;
			HashMap<String, Object> map = new HashMap<String, Object>();

			String tup1 = "";
			for (String s1 : attribute1) {
				tup1 += t.getAttribute(s1).toString();
			}
			for (Tuple t1 : r2.tuples) {
				String tup2 = "";
				for (String s1 : attribute2) {
					tup2 += t1.getAttribute(s1).toString();
				}
				if (tup1.equals(tup2)) {
					for (Attribute att : this.getAttributes()) {
						map.put(this.name + "." + att.getName(), t.getAttribute(att.getName()));
					}
					for (Attribute att1 : r2.getAttributes()) {
						map.put(r2.name + "." + att1.getName(), t1.getAttribute(att1.getName()));
					}
					newTup = new Tuple(map);
					tuple.add(newTup);
				}
			}
		}
		Relation r = new Relation("EQUIJOIN RESULT", newAttributes, tuple);
		return r;
	}

	public Relation naturalJoin(Relation r2) {
		ArrayList<Attribute> newAttributes = new ArrayList<Attribute>();
		ArrayList<Attribute> firstAttributes = this.getAttributes();
		ArrayList<Attribute> secondAttributes = r2.getAttributes();
		ArrayList<String> first = new ArrayList<String>();
		ArrayList<String> second = new ArrayList<String>();
		ArrayList<Tuple> tuple = new ArrayList<Tuple>();
		Relation r = new Relation("NATURAL_JOIN", firstAttributes);
		for (int i = 0; i < firstAttributes.size(); i++) {
			for (int j = 0; j < secondAttributes.size(); j++) {
				if (firstAttributes.get(i).getName().equals(secondAttributes.get(j).getName())) {
					if (!firstAttributes.get(i).getType().equals(secondAttributes.get(j).getType())) {
						System.out.println("Illegal! Natural Join Domain mismatch");
					} else {
						first.add(firstAttributes.get(i).getName());
						second.add(secondAttributes.get(j).getName());
					}
				}
			}
		}
		if (!first.isEmpty() && !second.isEmpty()) {
			for (int i = 0; i < firstAttributes.size(); i++) {
				newAttributes.add(new Attribute(firstAttributes.get(i).getName(), firstAttributes.get(i).getType()));
			}
			for (int i = 0; i < secondAttributes.size(); i++) {
				newAttributes.add(new Attribute(secondAttributes.get(i).getName(), secondAttributes.get(i).getType()));
			}

			for (Tuple t : this.tuples) {
				Tuple newTup = null;
				HashMap<String, Object> map = new HashMap<String, Object>();

				String tup1 = "";
				for (String s1 : first) {
					tup1 += t.getAttribute(s1).toString();
				}
				for (Tuple t1 : r2.tuples) {
					String tup2 = "";
					for (String s1 : second) {
						tup2 += t1.getAttribute(s1).toString();
					}
					if (tup1.equals(tup2)) {
						for (Attribute att : this.getAttributes()) {
							map.put(att.getName(), t.getAttribute(att.getName()));
						}
						for (Attribute att1 : r2.getAttributes()) {
							map.put(att1.getName(), t1.getAttribute(att1.getName()));
						}
						newTup = new Tuple(map);
						tuple.add(newTup);
					}
				}
			}
			r = new Relation("NATURAL_JOIN", newAttributes, tuple);
		}
		return r;
	}

	public Relation min(String attribute) {
		ArrayList<Attribute> attr = new ArrayList<Attribute>();
		ArrayList<Tuple> tupl = new ArrayList<Tuple>();
		Tuple resultTuple;
		Attribute atr = new Attribute("min_" + attribute, Integer.class);
		attr.add(atr);
		Relation r = new Relation("MIN_RESULT", attr);
		try {
			for (Attribute a : this.getAttributes()) {
				if (a.getName().equals(attribute)) {
					if (!a.getType().equals(Integer.class)) {
						System.out.println("Illegal! Attribute is not Numeric");
					}
					break;
				}
			}
			int min = (Integer) this.tuples.get(0).getAttribute(attribute);
			HashMap<String, Object> t1 = new HashMap<String, Object>();
			for (Tuple t : this.tuples) {
				if ((Integer) t.getAttribute(attribute) < min) {
					min = (Integer) t.getAttribute(attribute);
				}
			}
			t1.put("min_" + attribute, min);
			resultTuple = new Tuple(t1);
			tupl.add(resultTuple);
			r = new Relation("MIN_RESULT", attr, tupl);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return r;
	}

	public Relation max(String attribute) {
		ArrayList<Attribute> attr = new ArrayList<Attribute>();
		ArrayList<Tuple> tupl = new ArrayList<Tuple>();
		Tuple resultTuple;
		Attribute atr = new Attribute("max_" + attribute, Integer.class);
		attr.add(atr);
		Relation r = new Relation("MAX_RESULT", attr);
		try {
			for (Attribute a : this.getAttributes()) {
				if (a.getName().equals(attribute)) {
					if (!a.getType().equals(Integer.class)) {
						System.out.println("Illegal! Attribute is not Numeric");
					}
					break;
				}
			}
			int max = (Integer) this.tuples.get(0).getAttribute(attribute);
			HashMap<String, Object> t1 = new HashMap<String, Object>();
			for (Tuple t : this.tuples) {
				if ((Integer) t.getAttribute(attribute) > max) {
					max = (Integer) t.getAttribute(attribute);
				}
			}
			t1.put("max_" + attribute, max);
			resultTuple = new Tuple(t1);
			tupl.add(resultTuple);
			r = new Relation("MAX_RESULT", attr, tupl);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return r;
	}

	public Relation average(String attribute) {
		ArrayList<Attribute> attr = new ArrayList<Attribute>();
		ArrayList<Tuple> tupl = new ArrayList<Tuple>();
		Tuple resultTuple;
		Attribute atr = new Attribute("avg_" + attribute, Integer.class);
		attr.add(atr);
		Relation r = new Relation("AVG_RESULT", attr);
		try {
			for (Attribute a : this.getAttributes()) {
				if (a.getName().equals(attribute)) {
					if (!a.getType().equals(Integer.class)) {
						System.out.println("Illegal! Attribute is not Numeric");
					}
					break;
				}
			}
			HashMap<String, Object> t1 = new HashMap<String, Object>();
			int sum = 0;
			int avg;
			for (Tuple t : this.tuples) {
				sum += (Integer) t.getAttribute(attribute);
			}
			avg = Math.floorDiv(sum, tuples.size());
			t1.put("avg_" + attribute, avg);
			resultTuple = new Tuple(t1);
			tupl.add(resultTuple);
			r = new Relation("AVG_RESULT", attr, tupl);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return r;
	}

	public Relation sum(String attribute) {
		ArrayList<Attribute> attr = new ArrayList<Attribute>();
		ArrayList<Tuple> tupl = new ArrayList<Tuple>();
		Tuple resultTuple;
		Attribute atr = new Attribute("sum_" + attribute, Integer.class);
		attr.add(atr);
		Relation r = new Relation("SUM_RESULT", attr);
		try {
			for (Attribute a : this.getAttributes()) {
				if (a.getName().equals(attribute)) {
					if (!a.getType().equals(Integer.class)) {
						System.out.println("Illegal! Attribute is not Numeric");
					}
					break;
				}
			}
			HashMap<String, Object> t1 = new HashMap<String, Object>();
			int sum = 0;
			for (Tuple t : this.tuples) {
				sum += (Integer) t.getAttribute(attribute);
			}
			t1.put("sum_" + attribute, sum);
			resultTuple = new Tuple(t1);
			tupl.add(resultTuple);
			r = new Relation("SUM_RESULT", attr, tupl);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return r;
	}

	public Relation count(String attribute) {
		ArrayList<Attribute> attr = new ArrayList<Attribute>();
		ArrayList<Tuple> tupl = new ArrayList<Tuple>();
		Tuple resultTuple;
		Attribute atr = new Attribute("count_" + attribute, Integer.class);
		attr.add(atr);
		Relation r = new Relation("COUNT_RESULT", attr);
		try {
			HashMap<String, Object> t1 = new HashMap<String, Object>();
			int count = this.tuples.size();
			t1.put("count_" + attribute, count);
			resultTuple = new Tuple(t1);
			tupl.add(resultTuple);
			r = new Relation("COUNT_RESULT", attr, tupl);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return r;
	}

	public Relation group_aggregate(String group, String function, String aggregate) {
		Set<Object> groupValues = new HashSet<Object>();
		for (Tuple t : this.tuples) {
			groupValues.add(t.getAttribute(group));
		}
		Class attributeType = null;
		for (Attribute a : this.getAttributes()) {
			if (a.getName().equals(group)) {
				attributeType = a.getType();
			}
		}
		ArrayList<Attribute> newAttributes = new ArrayList<Attribute>();
		Attribute atr = new Attribute(group, attributeType);
		Attribute atr1 = new Attribute(function + "_" + aggregate, Integer.class);
		newAttributes.add(atr);
		newAttributes.add(atr1);
		Relation finalResult = new Relation("GROUP_RESULT", newAttributes);
		ArrayList<Tuple> newTuples = new ArrayList<Tuple>();
		try {
			Iterator<Object> i = groupValues.iterator();
			while (i.hasNext()) {
				Object lit = i.next();
				Relation current = selection(group, "=", lit);
				Relation currentAggregateResult;
				HashMap<String, Object> m = new HashMap<String, Object>();
				switch (function) {
				case "min": {
					currentAggregateResult = current.min(aggregate);
					String name = currentAggregateResult.getAttributes().get(0).getName();
					Object value = currentAggregateResult.tuples.get(0).getAttribute(name);
					m.put(group, lit);
					m.put(name, value);
					Tuple tup = new Tuple(m);
					newTuples.add(tup);
					break;
				}
				case "max": {
					currentAggregateResult = current.max(aggregate);
					String name = currentAggregateResult.getAttributes().get(0).getName();
					Object value = currentAggregateResult.tuples.get(0).getAttribute(name);
					m.put(group, lit);
					m.put(name, value);
					Tuple tup = new Tuple(m);
					newTuples.add(tup);
					break;
				}
				case "avg": {
					currentAggregateResult = current.average(aggregate);
					String name = currentAggregateResult.getAttributes().get(0).getName();
					Object value = currentAggregateResult.tuples.get(0).getAttribute(name);
					m.put(group, lit);
					m.put(name, value);
					Tuple tup = new Tuple(m);
					newTuples.add(tup);
					break;
				}
				case "sum": {
					currentAggregateResult = current.sum(aggregate);
					String name = currentAggregateResult.getAttributes().get(0).getName();
					Object value = currentAggregateResult.tuples.get(0).getAttribute(name);
					m.put(group, lit);
					m.put(name, value);
					Tuple tup = new Tuple(m);
					newTuples.add(tup);
					break;
				}
				case "count": {
					currentAggregateResult = current.count(aggregate);
					String name = currentAggregateResult.getAttributes().get(0).getName();
					Object value = currentAggregateResult.tuples.get(0).getAttribute(name);
					m.put(group, lit);
					m.put(name, value);
					Tuple tup = new Tuple(m);
					newTuples.add(tup);
					break;
				}
				default:
					break;
				}
			}
			finalResult = new Relation("GROUP_RESULT", newAttributes, newTuples);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return finalResult;
	}

	public void insertTuple(String schemaName, Tuple newInsert) {
		if (checkDuplicatesInsert(newInsert)) {
			System.out.println("Illegal! Duplicate values are not allowed in relational model");
		} else if (!checkDomainconstraintInsert(newInsert)) {
			System.out.println("Illegal! Domain Constraint Violated");
		} else if (!checkPrimaryKeyViolationInsert(newInsert)) {
			System.out.println("Illegal! Key Constraint Violated");
		} else if (!checkForeignKeyViolationInsert(this.name, newInsert)) {
			System.out.println("Illegal! Referential Constraint Violated");
		} else {
			tuples.add(newInsert);
		}
	}

	public void deleteTuple(String schemaName, String ConditionAttribute, String operand, Object literal) {
		ArrayList<Tuple> filteredTuples = new ArrayList<Tuple>();
		filteredTuples = select(ConditionAttribute, operand, literal);
		for (Tuple tup : filteredTuples) {
			if (!checkReferentialIntegrityDelete(tup)) {
				System.out.println("Referential Integrity Violated");
			} else {
				this.tuples.remove(tup);
			}
		}

	}

	public void updateTuple(String schemaName, String Attribute, Object value, String ConditionAttribute,
			String operand, Object literal) {
		ArrayList<Tuple> filteredTuples = new ArrayList<Tuple>();
		filteredTuples = select(ConditionAttribute, operand, literal);
		if (!checkDomainConstraintUpdate(Attribute, value)) {
			System.out.println("Illegal! Domain Constraint Violated");
		} else if (!checkPrimaryKeyConstraintUpdate(Attribute, value)) {
			System.out.println("Illegal! Key Constraint Violated");
		} else if (!checkReferentialIntegrityUpdate(Attribute, value)) {
			System.out.println("Illegal! Referential Integrity violated");
		} else {
			String currRelation = this.name;
			String primaryKey = s.getPrimaryKey(currRelation);
			if (Attribute.equals(primaryKey)) {
				for (Tuple tup : filteredTuples) {
					Object oldValue = tup.getAttribute(primaryKey);
					cascadeUpdate(Attribute, oldValue, value);
					tup.setTupleValues(Attribute, value);
				}
			} else {
				for (Tuple tup : filteredTuples) {
					tup.setTupleValues(Attribute, value);
				}
			}
		}
	}

	public boolean checkDuplicatesInsert(Tuple newInsert) {
		boolean isDuplicate = false;
		for (Tuple tup : this.tuples) {
			if (tup.toString().equals(newInsert.toString())) {
				isDuplicate = true;
			}
		}
		return isDuplicate;
	}

	public boolean checkDomainconstraintInsert(Tuple newInsert) {
		boolean domainConstraintSatisfied = true;
		try {
			for (Attribute at : attributes) {
				if (!newInsert.getAttribute(at.getName()).getClass().equals(at.getType())) {
					domainConstraintSatisfied = false;
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return domainConstraintSatisfied;
	}

	public boolean checkPrimaryKeyViolationInsert(Tuple newInsert) {
		boolean keyConstraint = true;
		try {
			String key = s.getPrimaryKey(this.name);
			Object keyAttribute = newInsert.getAttribute(key);
			if (keyAttribute == null) {
				keyConstraint = false;
			}
			if (!tuples.isEmpty()) {
				for (Tuple t : tuples) {
					if (t.getAttribute(key).equals(keyAttribute)) {
						keyConstraint = false;
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return keyConstraint;
	}

	public boolean checkForeignKeyViolationInsert(String referencingRelation, Tuple tup) {
		ArrayList<String> referencedRelation = new ArrayList<String>();
		boolean foreignKeyConstraintSatisfied = true;
		try {
			referencedRelation = s.getReferencedRelation(referencingRelation);
			for (String s1 : referencedRelation) {
				boolean isMember = false;
				String primaryKeyTuple;
				String foreignKeyTuple;
				String[] splitResult = s1.split("\\.");
				String primaryKey = s.getPrimaryKey(splitResult[1]);
				String foreignKey = splitResult[0];
				foreignKeyTuple = tup.getAttribute(foreignKey).toString();
				for (Tuple t : s.getRelation(splitResult[1]).tuples) {
					primaryKeyTuple = t.getAttribute(primaryKey).toString();
					if (primaryKeyTuple.equals(foreignKeyTuple)) {
						isMember = true;
					}
				}
				if (!isMember) {
					foreignKeyConstraintSatisfied = false;

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return foreignKeyConstraintSatisfied;
	}

	public boolean checkDomainConstraintUpdate(String attribute, Object value) {
		boolean domainConstraintSatisfied = false;
		for (Attribute a : this.getAttributes()) {
			if (a.getName().equals(attribute)) {
				if (a.getType().equals(value.getClass())) {
					domainConstraintSatisfied = true;
				}
			}
		}
		return domainConstraintSatisfied;
	}

	public boolean checkPrimaryKeyConstraintUpdate(String attribute, Object value) {
		boolean primaryKeyConstraintSatisfied = true;
		try {
			String prim = s.getPrimaryKey(this.name);
			if (attribute.equals(prim)) {
				if (value.equals(null)) {
					primaryKeyConstraintSatisfied = false;
				} else {
					for (Tuple t : this.tuples) {
						if (t.getAttribute(prim).equals(value)) {
							primaryKeyConstraintSatisfied = false;
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return primaryKeyConstraintSatisfied;
	}

	public void cascadeUpdate(String attribute, Object oldValue, Object newValue) {
		ArrayList<String> referencingRelations = new ArrayList<String>();
		referencingRelations = s.getReferencingRelation(this.name);
		try {
			for (String s1 : referencingRelations) {
				String Relation;
				String foreignKey;
				String[] splitResult = s1.split("\\.");
				Relation = splitResult[0];
				foreignKey = splitResult[1];
				for (Tuple t : s.getRelation(Relation).tuples) {
					Object val = t.getAttribute(foreignKey);
					if (val.equals(oldValue)) {
						t.setTupleValues(attribute, newValue);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean checkReferentialIntegrityUpdate(String attribute, Object value) {
		ArrayList<String> referencedRelation = new ArrayList<String>();
		referencedRelation = s.getReferencedRelation(this.name);
		boolean foreignKeyConstraintSatisfied = true;
		try {
			for (String s1 : referencedRelation) {
				boolean isMember = false;
				String[] splitResult = s1.split("\\.");
				String primRelation = splitResult[1];
				String primaryKey = s.getPrimaryKey(primRelation);
				String foreignKey = splitResult[0];
				Relation currRelation = s.getRelation(primRelation);
				if (foreignKey.equals(attribute)) {
					for (Tuple t : currRelation.tuples) {
						if (value.equals(t.getAttribute(primaryKey))) {
							isMember = true;
						}
						if (!isMember) {
							foreignKeyConstraintSatisfied = false;
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return foreignKeyConstraintSatisfied;
	}

	public boolean checkReferentialIntegrityDelete(Tuple tup) {
		boolean referentialIntegritySatisfied = true;
		ArrayList<String> referencingRelations = new ArrayList<String>();
		referencingRelations = s.getReferencingRelation(this.name);
		String primaryKey = s.getPrimaryKey(this.name);
		for (String s1 : referencingRelations) {
			String currRelation;
			String foreignKey;
			String[] stringSplit = s1.split("\\.");
			currRelation = stringSplit[0];
			foreignKey = stringSplit[1];
			for (Tuple t : s.getRelation(currRelation).tuples) {
				if (tup.getAttribute(primaryKey).equals(t.getAttribute(foreignKey))) {
					referentialIntegritySatisfied = false;
					t.setTupleValues(foreignKey, null);
				}
				this.tuples.remove(tup);
			}
		}
		return referentialIntegritySatisfied;
	}

	public void printRelation() {
//		System.out.println(Arrays.toString(attributes.toArray()));
		String str = "RELATION: " + this.name + "\n";
		for (Attribute attr : attributes) {
			str += attr.getName() + "\t";
		}
		str += "\n";
		for (Tuple tuple : this.tuples) {
			for (Attribute attr : attributes) {
				Object val = tuple.getAttribute(attr.getName());
				str += val + "\t";
			}
			str += "\n";
		}
		System.out.println(str);
	}

}
