package com.nabil.anl.jdbi;

import javax.management.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import com.nabil.anl.model.Book;
import com.nabil.anl.model.Person;

public class DBManager {
	public static void main(String[] args) {
		 Person p = new Person();
	
		//getAllPersonList();
		/* String sql = "SELECT count(*) as count FROM NABIL.P_B_LEND";
		 List<Map<String, Object>> rs=  queryEx(sql);
		 
		 if(rs!= null )
		 {
			 for (Map<String, Object> m : rs) {   
	             System.out.printf("%d ", m.get("count"));
	         
	         }
		 }*/
	}
	
	
	
	public static List<Person> getAllPersonList()
	{
		List<Person> pList = new ArrayList<Person>();
		String sql = "SELECT P.P_ID,P.P_NAME, P.P_MOBILE, P.P_EMAIL,COUNT(L.P_ID) as count FROM NABIL.PERSON_LIST P, NABIL.P_B_LEND L WHERE L.P_ID = P.P_ID GROUP BY L.P_ID ;";
		List<Map<String, Object>> rs= (List<Map<String, Object>>) queryEx(sql);
		 if(rs!= null )
		 {
			 for (Map<String, Object> m : rs) {   
				 Person p = new Person();
				 p.setpId((Integer) m.get("P_ID"));
				 p.setpName(m.get("P_NAME")+"");
				 p.setpMobile(m.get("P_MOBILE") +"");
				 p.setpEmail(m.get("P_EMAIL") +"");
				 p.setbCount(m.get("count") +"");
				 pList.add(p);
	         }
		 }
		
		return pList;
	}
	
	

	
	
	public static List<Book> getAllLendBookListByPerson(Integer p)
	{
		List<Book> bList = new ArrayList<Book>();
		System.out.println("in book list");
		
		String sql = "SELECT B.B_ID , B.B_NAME, B.B_AUTHOR, B.B_ISBN FROM Nabil.P_B_LEND L , Nabil.BOOK_LIST B , Nabil.PERSON_LIST P WHERE L.B_ID = B.B_ID AND L.P_ID = P.P_ID AND P.P_ID = "+p;
		List<Map<String, Object>> rs= (List<Map<String, Object>>) queryEx(sql);
		 if(rs!= null )
		 {
			 for (Map<String, Object> m : rs) {   
				 Book b = new Book();
				 b.setbId((Integer) m.get("B_ID"));
				 b.setbName(m.get("B_NAME")+"");
				 b.setbAuthor(m.get("B_AUTHOR")+"");
				 b.setbISBN(m.get("B_ISBN")+"");
				 bList.add(b);
	         }
		 }
		return bList;
	}
	
	
	
	
	
	
	
	
	
	
	
	private static List<Map<String, Object>> queryEx (String sql) {

        Handle handle = null;
        List<Map<String, Object>> rs = null;
        DBI dbi = new DBI("jdbc:h2:~/test", "sa", "sa");
       
        try {
            handle  = dbi.open();
             rs = handle.select(sql);

        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        
        return rs;
    }



	

}
