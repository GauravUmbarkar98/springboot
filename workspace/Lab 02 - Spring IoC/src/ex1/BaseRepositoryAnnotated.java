package ex1;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseRepositoryAnnotated {

	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	
}
