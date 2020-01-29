package events;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class CustomInterceptor extends EmptyInterceptor {

	   // This method is called before an object is deleted.
	   public void onDelete(Object entity,
	                     Serializable id,
	                     Object[] state,
	                     String[] propertyNames,
	                     Type[] types) {
	       System.out.println("onDelete called..");
	   }

	   // This method is called when an object gets updated.
	   public boolean onFlushDirty(Object entity,
	                     Serializable id,
	                     Object[] currentState,
	                     Object[] previousState,
	                     String[] propertyNames,
	                     Type[] types) {
		   System.out.println("onFlushDirty called..");
		   return true;
	   }
	   
	// This method is called just before an object is initialized.
	   public boolean onLoad(Object entity,
	                    Serializable id,
	                    Object[] state,
	                    String[] propertyNames,
	                    Type[] types) {
		   System.out.println("onLoad called..");
	       return true;
	   }
	   
	   // This method is called before an object is saved.
	   public boolean onSave(Object entity,
	                    Serializable id,
	                    Object[] state,
	                    String[] propertyNames,
	                    Type[] types) {
	       System.out.println("onSave called..");
	       return true;
	   }
	   
	}