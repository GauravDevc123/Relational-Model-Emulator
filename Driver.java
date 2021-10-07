import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.HashMap;

public class Driver {

	public static void main(String[] args) {
		ArrayList<Attribute> attrs1 = new ArrayList<Attribute>();
		attrs1.add(new Attribute("AGENT_CODE", String.class));
		attrs1.add(new Attribute("AGENT_NAME", String.class));
		attrs1.add(new Attribute("WORKING_AREA", String.class));
		attrs1.add(new Attribute("COMMISION_PER", Integer.class));
		attrs1.add(new Attribute("PHONE_NO", Integer.class));

		ArrayList<Attribute> attrs2 = new ArrayList<Attribute>();
		attrs2.add(new Attribute("CUST_CODE", String.class));
		attrs2.add(new Attribute("CUST_NAME", String.class));
		attrs2.add(new Attribute("CUST_CITY", String.class));
		attrs2.add(new Attribute("CUST_COUNTRY", String.class));
		attrs2.add(new Attribute("GRADE", Integer.class));
		attrs2.add(new Attribute("BALANCE", Integer.class));

		ArrayList<Attribute> attrs3 = new ArrayList<Attribute>();
		attrs3.add(new Attribute("ORD_NUM", Integer.class));
		attrs3.add(new Attribute("ORD_AMOUNT", Integer.class));
		attrs3.add(new Attribute("ADVANCE_AMOUNT", Integer.class));
		attrs3.add(new Attribute("ORD_DATE", String.class));
		attrs3.add(new Attribute("CUST_CODE", String.class));
		attrs3.add(new Attribute("AGENT_CODE", String.class));

		ArrayList<Relation> relations = new ArrayList<Relation>();
		Relation r1 = new Relation("AGENTS", attrs1);
		Relation r2 = new Relation("CUSTOMERS", attrs2);
		Relation r3 = new Relation("ORDERS", attrs3);
		relations.add(r1);
		relations.add(r2);
		relations.add(r3);
		Schema s = new Schema("SALES", relations);

		s.setPrimaryKeyConstraint("AGENTS", "AGENT_CODE");
		s.setPrimaryKeyConstraint("CUSTOMERS", "CUST_CODE");
		s.setPrimaryKeyConstraint("ORDERS", "ORD_NUM");
		s.printPrimaryKeyMap();

		s.setReferentialIntegrityConstraint("AGENTS", "ORDERS", "AGENT_CODE");
		s.setReferentialIntegrityConstraint("CUSTOMERS", "ORDERS", "CUST_CODE");
		s.printReferentialIntegrityMap();

		r1.setSchema(s);
		r2.setSchema(s);
		r3.setSchema(s);

		HashMap<String, Object> ta1 = new HashMap<String, Object>();
		ta1.put("AGENT_CODE", "A001");
		ta1.put("AGENT_NAME", "Hugo");
		ta1.put("WORKING_AREA", "Paris");
		ta1.put("COMMISION_PER", 14);
		ta1.put("PHONE_NO", 12346674);
		Tuple tupa1 = new Tuple(ta1);

		HashMap<String, Object> ta2 = new HashMap<String, Object>();
		ta2.put("AGENT_CODE", "A002");
		ta2.put("AGENT_NAME", "Mukesh");
		ta2.put("WORKING_AREA", "Mumbai");
		ta2.put("COMMISION_PER", 11);
		ta2.put("PHONE_NO", 123458969);
		Tuple tupa2 = new Tuple(ta2);

		HashMap<String, Object> ta3 = new HashMap<String, Object>();
		ta3.put("AGENT_CODE", "A003");
		ta3.put("AGENT_NAME", "Alex");
		ta3.put("WORKING_AREA", "London");
		ta3.put("COMMISION_PER", 15);
		ta3.put("PHONE_NO", 22544166);
		Tuple tupa3 = new Tuple(ta3);

		HashMap<String, Object> ta4 = new HashMap<String, Object>();
		ta4.put("AGENT_CODE", "A004");
		ta4.put("AGENT_NAME", "Ivan");
		ta4.put("WORKING_AREA", "Toronto");
		ta4.put("COMMISION_PER", 15);
		ta4.put("PHONE_NO", 22544166);
		Tuple tupa4 = new Tuple(ta4);

		HashMap<String, Object> ta5 = new HashMap<String, Object>();
		ta5.put("AGENT_CODE", "A005");
		ta5.put("AGENT_NAME", "Anderson");
		ta5.put("WORKING_AREA", "Brisbane");
		ta5.put("COMMISION_PER", 13);
		ta5.put("PHONE_NO", 21447739);
		Tuple tupa5 = new Tuple(ta5);

		HashMap<String, Object> ta6 = new HashMap<String, Object>();
		ta6.put("AGENT_CODE", "A006");
		ta6.put("AGENT_NAME", "McDenny");
		ta6.put("WORKING_AREA", "London");
		ta6.put("COMMISION_PER", 15);
		ta6.put("PHONE_NO", 22255588);
		Tuple tupa6 = new Tuple(ta6);

		HashMap<String, Object> ta7 = new HashMap<String, Object>();
		ta7.put("AGENT_CODE", "A007");
		ta7.put("AGENT_NAME", "Ramasundar");
		ta7.put("WORKING_AREA", "Bangalore");
		ta7.put("COMMISION_PER", 15);
		ta7.put("PHONE_NO", 25814763);
		Tuple tupa7 = new Tuple(ta7);

		HashMap<String, Object> ta8 = new HashMap<String, Object>();
		ta8.put("AGENT_CODE", "A008");
		ta8.put("AGENT_NAME", "Alfred");
		ta8.put("WORKING_AREA", "New York");
		ta8.put("COMMISION_PER", 12);
		ta8.put("PHONE_NO", 25874365);
		Tuple tupa8 = new Tuple(ta8);

		HashMap<String, Object> ta9 = new HashMap<String, Object>();
		ta9.put("AGENT_CODE", "A009");
		ta9.put("AGENT_NAME", "Benjamin");
		ta9.put("WORKING_AREA", "Hampshire");
		ta9.put("COMMISION_PER", 11);
		ta9.put("PHONE_NO", 22536178);
		Tuple tupa9 = new Tuple(ta9);

		HashMap<String, Object> ta10 = new HashMap<String, Object>();
		ta10.put("AGENT_CODE", "A010");
		ta10.put("AGENT_NAME", "Sanchez");
		ta10.put("WORKING_AREA", "Madrid");
		ta10.put("COMMISION_PER", 14);
		ta10.put("PHONE_NO", 22388644);
		Tuple tupa10 = new Tuple(ta10);

		HashMap<String, Object> ta11 = new HashMap<String, Object>();
		ta11.put("AGENT_CODE", "A001");
		ta11.put("AGENT_NAME", "Stevens");
		ta11.put("WORKING_AREA", "Dublin");
		ta11.put("COMMISION_PER", 15);
		ta11.put("PHONE_NO", 45625874);
		Tuple tupa11 = new Tuple(ta11);

		HashMap<String, Object> ta12 = new HashMap<String, Object>();
		ta12.put("AGENT_CODE", "A011");
		ta12.put("AGENT_NAME", "Stevens");
		ta12.put("WORKING_AREA", "Dublin");
		ta12.put("COMMISION_PER", 15);
		ta12.put("PHONE_NO", 45625874);
		Tuple tupa12 = new Tuple(ta12);

		HashMap<String, Object> ta13 = new HashMap<String, Object>();
		ta13.put("AGENT_CODE", "A012");
		ta13.put("AGENT_NAME", "Lucida");
		ta13.put("WORKING_AREA", "San Jose");
		ta13.put("COMMISION_PER", 12);
		ta13.put("PHONE_NO", 52981425);
		Tuple tupa13 = new Tuple(ta13);

		HashMap<String, Object> ta14 = new HashMap<String, Object>();
		ta14.put("AGENT_CODE", "A005");
		ta14.put("AGENT_NAME", "Anderson");
		ta14.put("WORKING_AREA", "Brisbane");
		ta14.put("COMMISION_PER", 13);
		ta14.put("PHONE_NO", 21447739);
		Tuple tupa14 = new Tuple(ta14);

		r1.insertTuple("SALES", tupa1);
		r1.insertTuple("SALES", tupa2);
		r1.insertTuple("SALES", tupa3);
		r1.insertTuple("SALES", tupa4);
		r1.insertTuple("SALES", tupa5);
		r1.insertTuple("SALES", tupa6);
		r1.insertTuple("SALES", tupa7);
		r1.insertTuple("SALES", tupa8);
		r1.insertTuple("SALES", tupa9);
		r1.insertTuple("SALES", tupa10);
		r1.insertTuple("SALES", tupa11);
		r1.insertTuple("SALES", tupa12);
		r1.insertTuple("SALES", tupa13);
		r1.insertTuple("SALES", tupa14);

		r1.printRelation();

		HashMap<String, Object> tc1 = new HashMap<String, Object>();
		tc1.put("CUST_CODE", "C00014");
		tc1.put("CUST_NAME", "Victor");
		tc1.put("CUST_CITY", "Paris");
		tc1.put("CUST_COUNTRY", "France");
		tc1.put("GRADE", 2);
		tc1.put("BALANCE", 8000);
		Tuple tupc1 = new Tuple(tc1);

		HashMap<String, Object> tc2 = new HashMap<String, Object>();
		tc2.put("CUST_CODE", "C00005");
		tc2.put("CUST_NAME", "Sasikant");
		tc2.put("CUST_CITY", "Mumbai");
		tc2.put("CUST_COUNTRY", "India");
		tc2.put("GRADE", 1);
		tc2.put("BALANCE", 7000);
		Tuple tupc2 = new Tuple(tc2);

		HashMap<String, Object> tc3 = new HashMap<String, Object>();
		tc3.put("CUST_CODE", "C00009");
		tc3.put("CUST_NAME", "Ramesh");
		tc3.put("CUST_CITY", "Mumbai");
		tc3.put("CUST_COUNTRY", "India");
		tc3.put("GRADE", 3);
		tc3.put("BALANCE", 8000);
		Tuple tupc3 = new Tuple(tc3);

		HashMap<String, Object> tc4 = new HashMap<String, Object>();
		tc4.put("CUST_CODE", "C00022");
		tc4.put("CUST_NAME", "Avinash");
		tc4.put("CUST_CITY", "Mumbai");
		tc4.put("CUST_COUNTRY", "India");
		tc4.put("GRADE", 2);
		tc4.put("BALANCE", 7000);
		Tuple tupc4 = new Tuple(tc4);

		HashMap<String, Object> tc5 = new HashMap<String, Object>();
		tc5.put("CUST_CODE", "C00013");
		tc5.put("CUST_NAME", "Holmes");
		tc5.put("CUST_CITY", "London");
		tc5.put("CUST_COUNTRY", "UK");
		tc5.put("GRADE", 2);
		tc5.put("BALANCE", 6000);
		Tuple tupc5 = new Tuple(tc5);

		HashMap<String, Object> tc6 = new HashMap<String, Object>();
		tc6.put("CUST_CODE", "C00015");
		tc6.put("CUST_NAME", "Stuart");
		tc6.put("CUST_CITY", "London");
		tc6.put("CUST_COUNTRY", "UK");
		tc6.put("GRADE", 1);
		tc6.put("BALANCE", 6000);
		Tuple tupc6 = new Tuple(tc6);

		HashMap<String, Object> tc7 = new HashMap<String, Object>();
		tc7.put("CUST_CODE", "C00003");
		tc7.put("CUST_NAME", "Martin");
		tc7.put("CUST_CITY", "Toronto");
		tc7.put("CUST_COUNTRY", "Canada");
		tc7.put("GRADE", 2);
		tc7.put("BALANCE", 8000);
		Tuple tupc7 = new Tuple(tc7);

		HashMap<String, Object> tc8 = new HashMap<String, Object>();
		tc8.put("CUST_CODE", "C00006");
		tc8.put("CUST_NAME", "Shilton");
		tc8.put("CUST_CITY", "Toronto");
		tc8.put("CUST_COUNTRY", "Canada");
		tc8.put("GRADE", 1);
		tc8.put("BALANCE", 10000);
		Tuple tupc8 = new Tuple(tc8);

		HashMap<String, Object> tc9 = new HashMap<String, Object>();
		tc9.put("CUST_CODE", "C00008");
		tc9.put("CUST_NAME", "Karolina");
		tc9.put("CUST_CITY", "Toronto");
		tc9.put("CUST_COUNTRY", "Canada");
		tc9.put("GRADE", 1);
		tc9.put("BALANCE", 7000);
		Tuple tupc9 = new Tuple(tc9);

		HashMap<String, Object> tc10 = new HashMap<String, Object>();
		tc10.put("CUST_CODE", "C00004");
		tc10.put("CUST_NAME", "Winston");
		tc10.put("CUST_CITY", "Brisbane");
		tc10.put("CUST_COUNTRY", "Australia");
		tc10.put("GRADE", 1);
		tc10.put("BALANCE", 5000);
		Tuple tupc10 = new Tuple(tc10);

		HashMap<String, Object> tc11 = new HashMap<String, Object>();
		tc11.put("CUST_CODE", "C00018");
		tc11.put("CUST_NAME", "Fleming");
		tc11.put("CUST_CITY", "Brisbane");
		tc11.put("CUST_COUNTRY", "Australia");
		tc11.put("GRADE", 2);
		tc11.put("BALANCE", 7000);
		Tuple tupc11 = new Tuple(tc11);

		HashMap<String, Object> tc12 = new HashMap<String, Object>();
		tc12.put("CUST_CODE", "C01011");
		tc12.put("CUST_NAME", "Salvador");
		tc12.put("CUST_CITY", "Madrid");
		tc12.put("CUST_COUNTRY", 0);
		tc12.put("GRADE", "Spain");
		tc12.put("BALANCE", 1000);
		Tuple tupc12 = new Tuple(tc12);

		HashMap<String, Object> tc13 = new HashMap<String, Object>();
		tc13.put("CUST_CODE", "C00021");
		tc13.put("CUST_NAME", "Jacks");
		tc13.put("CUST_CITY", "Brisbane");
		tc13.put("CUST_COUNTRY", "Australia");
		tc13.put("GRADE", 1);
		tc13.put("BALANCE", 7000);
		Tuple tupc13 = new Tuple(tc13);

		HashMap<String, Object> tc14 = new HashMap<String, Object>();
		tc14.put("CUST_CODE", "C00023");
		tc14.put("CUST_NAME", "Karl");
		tc14.put("CUST_CITY", "London");
		tc14.put("CUST_COUNTRY", "UK");
		tc14.put("GRADE", 0);
		tc14.put("BALANCE", 4000);
		Tuple tupc14 = new Tuple(tc14);

		HashMap<String, Object> tc15 = new HashMap<String, Object>();
		tc15.put("CUST_CODE", "C00024");
		tc15.put("CUST_NAME", "Cook");
		tc15.put("CUST_CITY", "London");
		tc15.put("CUST_COUNTRY", "UK");
		tc15.put("GRADE", 2);
		tc15.put("BALANCE", 4000);
		Tuple tupc15 = new Tuple(tc15);

		HashMap<String, Object> tc16 = new HashMap<String, Object>();
		tc16.put("CUST_CODE", "C00016");
		tc16.put("CUST_NAME", "Venkatpati");
		tc16.put("CUST_CITY", "Bangalore");
		tc16.put("CUST_COUNTRY", "India");
		tc16.put("GRADE", 2);
		tc16.put("BALANCE", 8000);
		Tuple tupc16 = new Tuple(tc16);

		HashMap<String, Object> tc17 = new HashMap<String, Object>();
		tc17.put("CUST_CODE", "C00017");
		tc17.put("CUST_NAME", "Srinivas");
		tc17.put("CUST_CITY", "Bangalore");
		tc17.put("CUST_COUNTRY", "India");
		tc17.put("GRADE", 2);
		tc17.put("BALANCE", 8000);
		Tuple tupc17 = new Tuple(tc17);

		HashMap<String, Object> tc18 = new HashMap<String, Object>();
		tc18.put("CUST_CODE", "C00001");
		tc18.put("CUST_NAME", "Michael");
		tc18.put("CUST_CITY", "New York");
		tc18.put("CUST_COUNTRY", "USA");
		tc18.put("GRADE", 2);
		tc18.put("BALANCE", 3000);
		Tuple tupc18 = new Tuple(tc18);

		HashMap<String, Object> tc19 = new HashMap<String, Object>();
		tc19.put("CUST_CODE", "C00002");
		tc19.put("CUST_NAME", "Bolt");
		tc19.put("CUST_CITY", "New York");
		tc19.put("CUST_COUNTRY", "USA");
		tc19.put("GRADE", 3);
		tc19.put("BALANCE", 5000);
		Tuple tupc19 = new Tuple(tc19);

		HashMap<String, Object> tc20 = new HashMap<String, Object>();
		tc20.put("CUST_CODE", "C00013");
		tc20.put("CUST_NAME", "Erin");
		tc20.put("CUST_CITY", "Los Angeles");
		tc20.put("CUST_COUNTRY", "USA");
		tc20.put("GRADE", 5);
		tc20.put("BALANCE", 7000);
		Tuple tupc20 = new Tuple(tc20);

		HashMap<String, Object> tc21 = new HashMap<String, Object>();
		tc21.put("CUST_CODE", "C00020");
		tc21.put("CUST_NAME", "Albert");
		tc21.put("CUST_CITY", "New York");
		tc21.put("CUST_COUNTRY", "USA");
		tc21.put("GRADE", 3);
		tc21.put("BALANCE", 5000);
		Tuple tupc21 = new Tuple(tc21);

		HashMap<String, Object> tc22 = new HashMap<String, Object>();
		tc22.put("CUST_CODE", "C00010");
		tc22.put("CUST_NAME", "Charles");
		tc22.put("CUST_CITY", "hampshire");
		tc22.put("CUST_COUNTRY", "UK");
		tc22.put("GRADE", 3);
		tc22.put("BALANCE", 6000);
		Tuple tupc22 = new Tuple(tc22);

		HashMap<String, Object> tc23 = new HashMap<String, Object>();
		tc23.put("CUST_CODE", "C00007");
		tc23.put("CUST_NAME", "Oscar");
		tc23.put("CUST_CITY", "Madrid");
		tc23.put("CUST_COUNTRY", "Spain");
		tc23.put("GRADE", 1);
		tc23.put("BALANCE", 7000);
		Tuple tupc23 = new Tuple(tc23);

		HashMap<String, Object> tc24 = new HashMap<String, Object>();
		tc24.put("CUST_CODE", "C00011");
		tc24.put("CUST_NAME", "Sergio");
		tc24.put("CUST_CITY", "Madrid");
		tc24.put("CUST_COUNTRY", "Spain");
		tc24.put("GRADE", 3);
		tc24.put("BALANCE", 7000);
		Tuple tupc24 = new Tuple(tc24);

		HashMap<String, Object> tc25 = new HashMap<String, Object>();
		tc25.put("CUST_CODE", "C00019");
		tc25.put("CUST_NAME", "Alberto");
		tc25.put("CUST_CITY", "Madrid");
		tc25.put("CUST_COUNTRY", "Spain");
		tc25.put("GRADE", 1);
		tc25.put("BALANCE", 8000);
		Tuple tupc25 = new Tuple(tc25);

		HashMap<String, Object> tc26 = new HashMap<String, Object>();
		tc26.put("CUST_CODE", "C00011");
		tc26.put("CUST_NAME", "Tara");
		tc26.put("CUST_CITY", "London");
		tc26.put("CUST_COUNTRY", "UK");
		tc26.put("GRADE", 2);
		tc26.put("BALANCE", 1000);
		Tuple tupc26 = new Tuple(tc26);

		HashMap<String, Object> tc27 = new HashMap<String, Object>();
		tc27.put("CUST_CODE", "C00025");
		tc27.put("CUST_NAME", "Gary");
		tc27.put("CUST_CITY", "Dublin");
		tc27.put("CUST_COUNTRY", "Ireland");
		tc27.put("GRADE", 2);
		tc27.put("BALANCE", 5000);
		Tuple tupc27 = new Tuple(tc27);

		HashMap<String, Object> tc28 = new HashMap<String, Object>();
		tc28.put("CUST_CODE", "C00012");
		tc28.put("CUST_NAME", "Steven");
		tc28.put("CUST_CITY", "San Jose");
		tc28.put("CUST_COUNTRY", "USA");
		tc28.put("GRADE", 1);
		tc28.put("BALANCE", 5000);
		Tuple tupc28 = new Tuple(tc28);

		r2.insertTuple("SALES", tupc1);
		r2.insertTuple("SALES", tupc2);
		r2.insertTuple("SALES", tupc3);
		r2.insertTuple("SALES", tupc4);
		r2.insertTuple("SALES", tupc5);
		r2.insertTuple("SALES", tupc6);
		r2.insertTuple("SALES", tupc7);
		r2.insertTuple("SALES", tupc8);
		r2.insertTuple("SALES", tupc9);
		r2.insertTuple("SALES", tupc10);
		r2.insertTuple("SALES", tupc11);
		r2.insertTuple("SALES", tupc12);
		r2.insertTuple("SALES", tupc13);
		r2.insertTuple("SALES", tupc14);
		r2.insertTuple("SALES", tupc15);
		r2.insertTuple("SALES", tupc16);
		r2.insertTuple("SALES", tupc17);
		r2.insertTuple("SALES", tupc18);
		r2.insertTuple("SALES", tupc19);
		r2.insertTuple("SALES", tupc20);
		r2.insertTuple("SALES", tupc21);
		r2.insertTuple("SALES", tupc22);
		r2.insertTuple("SALES", tupc23);
		r2.insertTuple("SALES", tupc24);
		r2.insertTuple("SALES", tupc25);
		r2.insertTuple("SALES", tupc26);
		r2.insertTuple("SALES", tupc27);
		r2.insertTuple("SALES", tupc28);
		r2.printRelation();

		HashMap<String, Object> to1 = new HashMap<String, Object>();
		to1.put("ORD_NUM", 200117);
		to1.put("ORD_AMOUNT", 800);
		to1.put("ADVANCE_AMOUNT", 200);
		to1.put("ORD_DATE", "10/20/2008");
		to1.put("CUST_CODE", "C00014");
		to1.put("AGENT_CODE", "A001");
		Tuple tupo1 = new Tuple(to1);

		HashMap<String, Object> to2 = new HashMap<String, Object>();
		to2.put("ORD_NUM", 200106);
		to2.put("ORD_AMOUNT", 2500);
		to2.put("ADVANCE_AMOUNT", 700);
		to2.put("ORD_DATE", "04/20/2008");
		to2.put("CUST_CODE", "C00005");
		to2.put("AGENT_CODE", "A002");
		Tuple tupo2 = new Tuple(to2);

		HashMap<String, Object> to3 = new HashMap<String, Object>();
		to3.put("ORD_NUM", 200113);
		to3.put("ORD_AMOUNT", 4000);
		to3.put("ADVANCE_AMOUNT", 600);
		to3.put("ORD_DATE", "06/10/2008");
		to3.put("CUST_CODE", "C00022");
		to3.put("AGENT_CODE", "A002");
		Tuple tupo3 = new Tuple(to3);

		HashMap<String, Object> to4 = new HashMap<String, Object>();
		to4.put("ORD_NUM", 200120);
		to4.put("ORD_AMOUNT", 500);
		to4.put("ADVANCE_AMOUNT", 100);
		to4.put("ORD_DATE", "07/20/2008");
		to4.put("CUST_CODE", "C00009");
		to4.put("AGENT_CODE", "A002");
		Tuple tupo4 = new Tuple(to4);

		HashMap<String, Object> to5 = new HashMap<String, Object>();
		to5.put("ORD_NUM", 200123);
		to5.put("ORD_AMOUNT", 500);
		to5.put("ADVANCE_AMOUNT", 100);
		to5.put("ORD_DATE", "09/16/2008");
		to5.put("CUST_CODE", "C00022");
		to5.put("AGENT_CODE", "A002");
		Tuple tupo5 = new Tuple(to5);

		HashMap<String, Object> to6 = new HashMap<String, Object>();
		to6.put("ORD_NUM", 200126);
		to6.put("ORD_AMOUNT", 500);
		to6.put("ADVANCE_AMOUNT", 100);
		to6.put("ORD_DATE", "06/24/2008");
		to6.put("CUST_CODE", "C00022");
		to6.put("AGENT_CODE", "A002");
		Tuple tupo6 = new Tuple(to6);

		HashMap<String, Object> to7 = new HashMap<String, Object>();
		to7.put("ORD_NUM", 200128);
		to7.put("ORD_AMOUNT", 3500);
		to7.put("ADVANCE_AMOUNT", 1500);
		to7.put("ORD_DATE", "07/20/2008");
		to7.put("CUST_CODE", "C00009");
		to7.put("AGENT_CODE", "A002");
		Tuple tupo7 = new Tuple(to7);

		HashMap<String, Object> to8 = new HashMap<String, Object>();
		to8.put("ORD_NUM", 200133);
		to8.put("ORD_AMOUNT", 1200);
		to8.put("ADVANCE_AMOUNT", 400);
		to8.put("ORD_DATE", "06/29/2008");
		to8.put("CUST_CODE", "C00009");
		to8.put("AGENT_CODE", "A002");
		Tuple tupo8 = new Tuple(to8);

		HashMap<String, Object> to9 = new HashMap<String, Object>();
		to9.put("ORD_NUM", 200117);
		to9.put("ORD_AMOUNT", 1200);
		to9.put("ADVANCE_AMOUNT", 400);
		to9.put("ORD_DATE", "06/29/2008");
		to9.put("CUST_CODE", "C00009");
		to9.put("AGENT_CODE", "A002");
		Tuple tupo9 = new Tuple(to9);

		HashMap<String, Object> to10 = new HashMap<String, Object>();
		to10.put("ORD_NUM", 200127);
		to10.put("ORD_AMOUNT", 2500);
		to10.put("ADVANCE_AMOUNT", 400);
		to10.put("ORD_DATE", "07/20/2008");
		to10.put("CUST_CODE", "C00015");
		to10.put("AGENT_CODE", "A003");
		Tuple tupo10 = new Tuple(to10);

		HashMap<String, Object> to11 = new HashMap<String, Object>();
		to11.put("ORD_NUM", 200104);
		to11.put("ORD_AMOUNT", 1500);
		to11.put("ADVANCE_AMOUNT", 500);
		to11.put("ORD_DATE", "03/13/2008");
		to11.put("CUST_CODE", "C00006");
		to11.put("AGENT_CODE", "A004");
		Tuple tupo11 = new Tuple(to11);

		HashMap<String, Object> to12 = new HashMap<String, Object>();
		to12.put("ORD_NUM", 200108);
		to12.put("ORD_AMOUNT", 4000);
		to12.put("ADVANCE_AMOUNT", 600);
		to12.put("ORD_DATE", "09/23/2008");
		to12.put("CUST_CODE", "C00008");
		to12.put("AGENT_CODE", "A004");
		Tuple tupo12 = new Tuple(to12);

		HashMap<String, Object> to13 = new HashMap<String, Object>();
		to13.put("ORD_NUM", 200121);
		to13.put("ORD_AMOUNT", 1500);
		to13.put("ADVANCE_AMOUNT", 600);
		to13.put("ORD_DATE", "09/23/2008");
		to13.put("CUST_CODE", "C00008");
		to13.put("AGENT_CODE", "A004");
		Tuple tupo13 = new Tuple(to13);

		HashMap<String, Object> to14 = new HashMap<String, Object>();
		to14.put("ORD_NUM", 200122);
		to14.put("ORD_AMOUNT", 2500);
		to14.put("ADVANCE_AMOUNT", 400);
		to14.put("ORD_DATE", "09/16/2008");
		to14.put("CUST_CODE", "C00003");
		to14.put("AGENT_CODE", "A004");
		Tuple tupo14 = new Tuple(to14);

		HashMap<String, Object> to15 = new HashMap<String, Object>();
		to15.put("ORD_NUM", 200222);
		to15.put("ORD_AMOUNT", 2500);
		to15.put("ADVANCE_AMOUNT", 400);
		to15.put("ORD_DATE", "09/16/2008");
		to15.put("CUST_CODE", "C00004");
		to15.put("AGENT_CODE", "A004");
		Tuple tupo15 = new Tuple(to15);

		HashMap<String, Object> to16 = new HashMap<String, Object>();
		to16.put("ORD_NUM", 200103);
		to16.put("ORD_AMOUNT", 1500);
		to16.put("ADVANCE_AMOUNT", 700);
		to16.put("ORD_DATE", "05/15/2008");
		to16.put("CUST_CODE", "C00021");
		to16.put("AGENT_CODE", "A005");
		Tuple tupo16 = new Tuple(to16);

		HashMap<String, Object> to17 = new HashMap<String, Object>();
		to17.put("ORD_NUM", 200125);
		to17.put("ORD_AMOUNT", 2000);
		to17.put("ADVANCE_AMOUNT", 600);
		to17.put("ORD_DATE", "10/10/2008");
		to17.put("CUST_CODE", "C00018");
		to17.put("AGENT_CODE", "A005");
		Tuple tupo17 = new Tuple(to17);

		HashMap<String, Object> to18 = new HashMap<String, Object>();
		to18.put("ORD_NUM", 200134);
		to18.put("ORD_AMOUNT", 4200);
		to18.put("ADVANCE_AMOUNT", 1800);
		to18.put("ORD_DATE", "09/25/2008");
		to18.put("CUST_CODE", "C00004");
		to18.put("AGENT_CODE", "A005");
		Tuple tupo18 = new Tuple(to18);

		HashMap<String, Object> to19 = new HashMap<String, Object>();
		to19.put("ORD_NUM", 200136);
		to19.put("ORD_AMOUNT", 4200);
		to19.put("ADVANCE_AMOUNT", 1800);
		to19.put("ORD_DATE", "09/25/2008");
		to19.put("CUST_CODE", "C40004");
		to19.put("AGENT_CODE", "A005");
		Tuple tupo19 = new Tuple(to19);

		HashMap<String, Object> to20 = new HashMap<String, Object>();
		to20.put("ORD_NUM", 200118);
		to20.put("ORD_AMOUNT", 500);
		to20.put("ADVANCE_AMOUNT", 100);
		to20.put("ORD_DATE", "07/20/2008");
		to20.put("CUST_CODE", "C00023");
		to20.put("AGENT_CODE", "A006");
		Tuple tupo20 = new Tuple(to20);

		HashMap<String, Object> to21 = new HashMap<String, Object>();
		to21.put("ORD_NUM", 200129);
		to21.put("ORD_AMOUNT", 2500);
		to21.put("ADVANCE_AMOUNT", 500);
		to21.put("ORD_DATE", "07/20/2008");
		to21.put("CUST_CODE", "C00024");
		to21.put("AGENT_CODE", "A006");
		Tuple tupo21 = new Tuple(to21);

		HashMap<String, Object> to22 = new HashMap<String, Object>();
		to22.put("ORD_NUM", 200112);
		to22.put("ORD_AMOUNT", 2000);
		to22.put("ADVANCE_AMOUNT", 400);
		to22.put("ORD_DATE", "05/30/2008");
		to22.put("CUST_CODE", "C00016");
		to22.put("AGENT_CODE", "A007");
		Tuple tupo22 = new Tuple(to22);

		HashMap<String, Object> to23 = new HashMap<String, Object>();
		to23.put("ORD_NUM", 200124);
		to23.put("ORD_AMOUNT", 500);
		to23.put("ADVANCE_AMOUNT", 100);
		to23.put("ORD_DATE", "06/20/2008");
		to23.put("CUST_CODE", "C00017");
		to23.put("AGENT_CODE", "A007");
		Tuple tupo23 = new Tuple(to23);

		HashMap<String, Object> to24 = new HashMap<String, Object>();
		to24.put("ORD_NUM", 200101);
		to24.put("ORD_AMOUNT", 3000);
		to24.put("ADVANCE_AMOUNT", 1000);
		to24.put("ORD_DATE", "07/15/2008");
		to24.put("CUST_CODE", "C00001");
		to24.put("AGENT_CODE", "A008");
		Tuple tupo24 = new Tuple(to24);

		HashMap<String, Object> to25 = new HashMap<String, Object>();
		to25.put("ORD_NUM", 200111);
		to25.put("ORD_AMOUNT", 1000);
		to25.put("ADVANCE_AMOUNT", 300);
		to25.put("ORD_DATE", "07/10/2008");
		to25.put("CUST_CODE", "C00020");
		to25.put("AGENT_CODE", "A008");
		Tuple tupo25 = new Tuple(to25);

		HashMap<String, Object> to26 = new HashMap<String, Object>();
		to26.put("ORD_NUM", 200114);
		to26.put("ORD_AMOUNT", 3500);
		to26.put("ADVANCE_AMOUNT", 2000);
		to26.put("ORD_DATE", "08/15/2008");
		to26.put("CUST_CODE", "C00002");
		to26.put("AGENT_CODE", "A008");
		Tuple tupo26 = new Tuple(to26);

		HashMap<String, Object> to27 = new HashMap<String, Object>();
		to27.put("ORD_NUM", 200116);
		to27.put("ORD_AMOUNT", 500);
		to27.put("ADVANCE_AMOUNT", 100);
		to27.put("ORD_DATE", "07/30/2008");
		to27.put("CUST_CODE", "C00011");
		to27.put("AGENT_CODE", "A009");
		Tuple tupo27 = new Tuple(to27);

		HashMap<String, Object> to28 = new HashMap<String, Object>();
		to28.put("ORD_NUM", 200107);
		to28.put("ORD_AMOUNT", 4500);
		to28.put("ADVANCE_AMOUNT", 900);
		to28.put("ORD_DATE", "08/30/2008");
		to28.put("CUST_CODE", "C00007");
		to28.put("AGENT_CODE", "A010");
		Tuple tupo28 = new Tuple(to28);

		HashMap<String, Object> to29 = new HashMap<String, Object>();
		to29.put("ORD_NUM", 200109);
		to29.put("ORD_AMOUNT", 3500);
		to29.put("ADVANCE_AMOUNT", 800);
		to29.put("ORD_DATE", "07/30/2008");
		to29.put("CUST_CODE", "C00011");
		to29.put("AGENT_CODE", "A010");
		Tuple tupo29 = new Tuple(to29);

		HashMap<String, Object> to30 = new HashMap<String, Object>();
		to30.put("ORD_NUM", 200110);
		to30.put("ORD_AMOUNT", 3000);
		to30.put("ADVANCE_AMOUNT", 500);
		to30.put("ORD_DATE", "04/15/2008");
		to30.put("CUST_CODE", "C00019");
		to30.put("AGENT_CODE", "A010");
		Tuple tupo30 = new Tuple(to30);

		HashMap<String, Object> to31 = new HashMap<String, Object>();
		to31.put("ORD_NUM", 200119);
		to31.put("ORD_AMOUNT", 4000);
		to31.put("ADVANCE_AMOUNT", 700);
		to31.put("ORD_DATE", "09/16/2008");
		to31.put("CUST_CODE", "C00007");
		to31.put("AGENT_CODE", "A010");
		Tuple tupo31 = new Tuple(to31);

		HashMap<String, Object> to32 = new HashMap<String, Object>();
		to32.put("ORD_NUM", 200135);
		to32.put("ORD_AMOUNT", 2000);
		to32.put("ADVANCE_AMOUNT", 800);
		to32.put("ORD_DATE", "09/16/2008");
		to32.put("CUST_CODE", "C00007");
		to32.put("AGENT_CODE", "A010");
		Tuple tupo32 = new Tuple(to32);

		HashMap<String, Object> to33 = new HashMap<String, Object>();
		to33.put("ORD_NUM", 200105);
		to33.put("ORD_AMOUNT", 2500);
		to33.put("ADVANCE_AMOUNT", 500);
		to33.put("ORD_DATE", "07/18/2008");
		to33.put("CUST_CODE", "C00025");
		to33.put("AGENT_CODE", "A011");
		Tuple tupo33 = new Tuple(to33);

		HashMap<String, Object> to34 = new HashMap<String, Object>();
		to34.put("ORD_NUM", 200130);
		to34.put("ORD_AMOUNT", 2500);
		to34.put("ADVANCE_AMOUNT", 400);
		to34.put("ORD_DATE", "07/30/2008");
		to34.put("CUST_CODE", "C00025");
		to34.put("AGENT_CODE", "A011");
		Tuple tupo34 = new Tuple(to34);

		HashMap<String, Object> to35 = new HashMap<String, Object>();
		to35.put("ORD_NUM", 200102);
		to35.put("ORD_AMOUNT", 2000);
		to35.put("ADVANCE_AMOUNT", 300);
		to35.put("ORD_DATE", "05/25/2008");
		to35.put("CUST_CODE", "C00012");
		to35.put("AGENT_CODE", "A012");
		Tuple tupo35 = new Tuple(to35);

		HashMap<String, Object> to36 = new HashMap<String, Object>();
		to36.put("ORD_NUM", 200131);
		to36.put("ORD_AMOUNT", 900);
		to36.put("ADVANCE_AMOUNT", 150);
		to36.put("ORD_DATE", "08/26/2008");
		to36.put("CUST_CODE", "C00012");
		to36.put("AGENT_CODE", "A012");
		Tuple tupo36 = new Tuple(to36);

		HashMap<String, Object> to37 = new HashMap<String, Object>();
		to37.put("ORD_NUM", 200137);
		to37.put("ORD_AMOUNT", 2000);
		to37.put("ADVANCE_AMOUNT", 800);
		to37.put("ORD_DATE", "09/16/2008");
		to37.put("CUST_CODE", "C00007");
		to37.put("AGENT_CODE", "A110");
		Tuple tupo37 = new Tuple(to37);

		r3.insertTuple("SALES", tupo1);
		r3.insertTuple("SALES", tupo2);
		r3.insertTuple("SALES", tupo3);
		r3.insertTuple("SALES", tupo4);
		r3.insertTuple("SALES", tupo5);
		r3.insertTuple("SALES", tupo6);
		r3.insertTuple("SALES", tupo7);
		r3.insertTuple("SALES", tupo8);
		r3.insertTuple("SALES", tupo9);
		r3.insertTuple("SALES", tupo10);
		r3.insertTuple("SALES", tupo11);
		r3.insertTuple("SALES", tupo12);
		r3.insertTuple("SALES", tupo13);
		r3.insertTuple("SALES", tupo14);
		r3.insertTuple("SALES", tupo15);
		r3.insertTuple("SALES", tupo16);
		r3.insertTuple("SALES", tupo17);
		r3.insertTuple("SALES", tupo18);
		r3.insertTuple("SALES", tupo19);
		r3.insertTuple("SALES", tupo20);
		r3.insertTuple("SALES", tupo21);
		r3.insertTuple("SALES", tupo22);
		r3.insertTuple("SALES", tupo23);
		r3.insertTuple("SALES", tupo24);
		r3.insertTuple("SALES", tupo25);
		r3.insertTuple("SALES", tupo26);
		r3.insertTuple("SALES", tupo27);
		r3.insertTuple("SALES", tupo28);
		r3.insertTuple("SALES", tupo29);
		r3.insertTuple("SALES", tupo30);
		r3.insertTuple("SALES", tupo31);
		r3.insertTuple("SALES", tupo32);
		r3.insertTuple("SALES", tupo33);
		r3.insertTuple("SALES", tupo34);
		r3.insertTuple("SALES", tupo35);
		r3.insertTuple("SALES", tupo36);
		r3.insertTuple("SALES", tupo37);
		r3.printRelation();

		r1.updateTuple("SALES", "AGENT_CODE", "A017", "AGENT_CODE", "=", "A007");
		r1.printRelation();
		r3.printRelation();

		r3.updateTuple("SALES", "ORD_AMOUNT", 3400, "ORD_NUM", "=", 200222);
		r3.printRelation();

		r3.updateTuple("SALES", "CUST_CODE", "C1000", "ORD_NUM", "=", 200222);
		r3.printRelation();

		r3.deleteTuple("SALES", "ORD_NUM", "=", 200222);
		r3.printRelation();

		r1.deleteTuple("SALES", "AGENT_CODE", "=", "A017");
		r1.printRelation();
		r3.printRelation();

		Relation r01 = r3.selection("ORD_AMOUNT", ">", 4000);
		Relation r02 = r01.naturalJoin(r2);
		Relation r03 = r02.naturalJoin(r1);
		ArrayList<String> prj0 = new ArrayList<String>();
		prj0.add("CUST_NAME");
		prj0.add("AGENT_NAME");
		Relation r04 = r03.projection(prj0);
		r04.printRelation();

		ArrayList<String> prj1 = new ArrayList<String>();
		prj1.add("CUST_NAME");
		Relation r11 = r2.projection(prj1);
		r11.printRelation();

		ArrayList<String> prj2 = new ArrayList<String>();
		prj2.add("AGENT_NAME");
		prj2.add("PHONE_NO");
		Relation r21 = r1.selection("WORKING_AREA", "=", "Bangalore");
		Relation r22=r21.projection(prj2);
		r22.printRelation();

		ArrayList<String> prj31 = new ArrayList<String>();
		prj31.add("AGENT_NAME");
		Relation r31 = r1.projection(prj31);
		ArrayList<String> prj32 = new ArrayList<String>();
		prj32.add("CUST_NAME");
		Relation r32 = r2.projection(prj32);
		r31.Union(r32);

		Relation r40 = r2.selection("CUST_COUNTRY", "=", "USA");
		Relation r41 = r40.naturalJoin(r3);
		r41.printRelation();

		Relation r51 = r3.group_aggregate("AGENT_CODE", "count", "CUST_CODE");
		Relation r52 = r3.group_aggregate("AGENT_CODE", "sum", "ORD_AMOUNT");
		Relation r53 = r51.naturalJoin(r52);
		Relation r54 = r53.naturalJoin(r1);
		ArrayList<String> prj5 = new ArrayList<String>();
		prj5.add("AGENT_CODE");
		prj5.add("AGENT_NAME");
		prj5.add("PHONE_NO");
		prj5.add("count_CUST_CODE");
		prj5.add("sum_ORD_AMOUNT");
		Relation r55 = r54.projection(prj5);
		r55.printRelation();
	}
}
