import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Schema {
	HashMap<String, String> refMap = new HashMap<String, String>();
	private HashMap<String, String> primMap = new HashMap<String, String>();
	private String schemaName;
	private ArrayList<Relation> relation;

	public Schema(String schemaName, Collection<Relation> relation) {
		this.schemaName = schemaName;
		this.relation = new ArrayList<Relation>(relation);
	}

	public Relation getRelation(String refRelationName) {
		Relation refRelation = null;
		for (Relation rel : this.relation) {
			if (rel.getRelationName().equals(refRelationName)) {
				refRelation = rel;
			}
		}
		return refRelation;
	}

	public void setReferentialIntegrityConstraint(String referencedRelation, String referencingRelation,
			String foreignKey) {
		String referencingPart = "";
		String referencedPart = "";
		for (Relation rel : this.relation) {
			if (rel.getRelationName().equals(referencingRelation)) {
				referencingPart += rel.getRelationName() + ".";
				for (Attribute attr : rel.getAttributes()) {
					if (attr.getName().equals(foreignKey)) {
						referencingPart += attr.getName();
					}
				}
			}
		}
		for (Relation rel : this.relation) {
			if (rel.getRelationName().equals(referencedRelation)) {
				referencedPart += rel.getRelationName();
			}
		}
		refMap.put(referencingPart, referencedPart);
	}

	public void setPrimaryKeyConstraint(String rel, String attr) {
		for (Relation r : this.relation) {
			if (r.getRelationName().equals(rel)) {
				for (Attribute a : r.getAttributes()) {
					if (a.getName().equals(attr)) {
						primMap.put(rel, attr);
					}
				}
			}
		}
	}

	public ArrayList<String> getReferencedRelation(String referencingRelation) {
		ArrayList<String> refRelationName = new ArrayList<String>();
		for (Relation rel : this.relation) {
			if (rel.getRelationName().equals(referencingRelation)) {
				for (Attribute attr : rel.getAttributes()) {
					if (refMap.containsKey(rel.getRelationName() + "." + attr.getName())) {
						refRelationName
								.add(attr.getName() + "." + refMap.get(rel.getRelationName() + "." + attr.getName()));
					}
				}
			}
		}
		return refRelationName;
	}

	public ArrayList<String> getReferencingRelation(String referencedRelation) {
		ArrayList<String> referencingRelations = new ArrayList<String>();
		for (Map.Entry<String, String> entry : refMap.entrySet()) {
			if (entry.getValue().equals(referencedRelation)) {
				referencingRelations.add(entry.getKey());
			}
		}
		return referencingRelations;
	}

	public String getPrimaryKey(String rel) {
		return primMap.get(rel);
	}

	public void printPrimaryKeyMap() {
		System.out.println(primMap);
	}

	public void printReferentialIntegrityMap() {
		System.out.println(refMap);
	}
}
