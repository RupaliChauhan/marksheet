import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

public class TestMarksheetModel {
	public static void main(String[] args) throws Exception {
		TestMarksheetModel tc = new TestMarksheetModel();
		// tc.testadd();
		// tc.testupdate();
		// tc.testdelete();
		//tc.testselect();
		// testgetbycoloumn();
		
		testgetMerrit();
		//testgetMerritlist();
	}

	public static void testgetMerritlist() throws Exception
	{
		MarksheetModel model = new MarksheetModel();
		ArrayList<MarksheetBean> list=model.getMerritlist();
		
		Iterator<MarksheetBean> it =list.iterator();
		
		while (it.hasNext()) 
		{
			MarksheetBean mb = (MarksheetBean) it.next();
			System.out.print("\t"+mb.getId());
			System.out.print("\t"+mb.getRoll_no());
			System.out.print("\t"+mb.getFname());
			System.out.print("\t"+mb.getLname());
			System.out.print("\t"+mb.getPhysics());
			System.out.print("\t"+mb.getChemistry());
			System.out.println("\t"+mb.getMaths());
		}
			
		
	}

	public static void testgetMerrit() throws Exception
	{
		MarksheetModel model= new MarksheetModel();
		model.getMerrit();
		
	}

	public static void testadd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(14);
		bean.setRoll_no("101");
		bean.setFname("Ansh");
		bean.setLname("sharma");
		bean.setPhysics(77);
		bean.setChemistry(66);
		bean.setMaths(65);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);

	}

	public void testupdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setRoll_no("101");
		bean.setFname("Tanu");
		bean.setLname("sharma");
		bean.setPhysics(77);
		bean.setChemistry(66);
		bean.setMaths(65);
		bean.setId(10);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);
	}

	public void testdelete() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setRoll_no("101");
		bean.setFname("Tanu");
		bean.setLname("sharma");
		bean.setPhysics(77);
		bean.setChemistry(66);
		bean.setMaths(65);
		bean.setId(10);

		MarksheetModel model = new MarksheetModel();
		model.delete(bean);
	}

	public void testselect() throws Exception 

	{
		MarksheetModel model = new MarksheetModel();
		
		ArrayList<MarksheetBean> list = model.select();
		
		Iterator< MarksheetBean> it = list.iterator();
		
		while (it.hasNext()) 
		{
			MarksheetBean mb = (MarksheetBean) it.next();
			 
			System.out.print("\t"+mb.getId());
			System.out.print("\t"+mb.getRoll_no());
			System.out.print("\t"+mb.getFname());
			System.out.print("\t"+mb.getLname());
			System.out.print("\t"+mb.getPhysics());
			System.out.print("\t"+mb.getChemistry());
			System.out.println("\t"+mb.getMaths());
		
		}
	

	}

	public static void testgetbycoloumn() throws Exception
	{
		MarksheetModel model = new MarksheetModel();
		model.getbycolumn();
	}
	
	

}
