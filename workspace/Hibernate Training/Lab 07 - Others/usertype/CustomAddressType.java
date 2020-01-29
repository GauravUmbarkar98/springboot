package usertype;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;

import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public class CustomAddressType implements UserType {

	public CustomAddressType() { }

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.STRUCT };
	}

	@Override
	public Class<Address> returnedClass() {
		return Address.class;
	}

	@Override
	public Object nullSafeGet(ResultSet inResultSet, String[] names,
			SessionImplementor session, Object o) throws HibernateException,
			SQLException {
		Struct struct = (Struct) inResultSet.getObject(names[0]);
		Address addr = new Address();
		Object[] attr = struct.getAttributes();
		addr.setCity((String)attr[0]);
		addr.setState((String)attr[1]);
		addr.setCountry((String)attr[2]);
		return addr;
	}

	@Override
	public void nullSafeSet(PreparedStatement inPreparedStatement, Object o, int index,
			SessionImplementor session) throws HibernateException, SQLException {
		Address addr = (Address) o;
		System.out.println(addr);
		Object[] values = {addr.getCity(), addr.getState(), addr.getCountry()};
		Connection connection = inPreparedStatement.getConnection();
		STRUCT struct = new STRUCT(StructDescriptor.createDescriptor("CUST_ADDR", connection),connection,values);
		inPreparedStatement.setObject(index, struct, Types.STRUCT); 
	}

	
	@Override
	public Object assemble(Serializable arg0, Object arg1)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object deepCopy(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable disassemble(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashCode(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object replace(Object arg0, Object arg1, Object arg2)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object arg0, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

}