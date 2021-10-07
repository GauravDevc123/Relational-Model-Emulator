# Relational-Algebra-and-Model
An approach to implement a relational model emulator and algebra in Java programming language. An important assumption of the emulator implementation is that all the data is in-memory. The emulator contains implementation of the Schema, Relation, Attribute, Tuple class and a driver class.  

## Description:
The project shows the working of data definition, data manipulation and querying and a demo case that shows the working of each of the data definition, manipulation and querying capabilities.

### Data Definition
The emulator consists of a _Schema_ class that refers to a collection of the relation in a mini-world and the relationships between them. The primary key and referential integrity constraint of all the relations is captured by the _Schema_ class. 
The emulator also contains _Relation_ class that refers to a collection of attributes and tuples. The domain constraint, duplicate records and any other implicit contraints of a relational model are captured using the _Relation_ class.

### Data Manipulation
The emulator consists of the three basic data manipulation constructs i.e Insert, Update and Delete. All the necessary domain violation, duplicate tuples, primary key violation and referential integrity violation are checked before performing the data manipulation operations. The necessary triggered(cascade) action for INSERT, UPDATE and DELETE are also implemented by the emulator.

#Data Querying
All the basic querying methods which are based on relational algebra are implemented by the emulator. The basic querying methods are as follows:
- Unary operations: { Projection, Selection }
- Set Binary operations: { Union, Intersection, Set-difference }
- Join Binary operations: { Cross product, Equi Join, Natural Join }
- Aggregrate operations: { Min, Max, Average, Sum, Count }
- Grouping with aggregration. 

The querying involves a two step approach:
- Step 1: Create a relational algebra expression
- Step 2: Writing the necessary code by following appropriate order based on the ordering process: FROM(Relation Name) - JOIN(Joined Relation) - WHERE(Selection) - GROUP BY(Grouping) - HAVING(Condition on grouped values) - SELECT(Projection)- ORDER BY(Sort)

For refering the java implementation. Switch to the master branch and open the package folder. 
Inside the package folder you will find the appropriate java class files for the Schema, Relation, Attribute, Tuple. 
