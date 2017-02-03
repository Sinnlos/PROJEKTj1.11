package dao;

public interface IRepositoryCatalog {

	public IPersonRepository people();
	public IBookRepository books();
	public void save();
	public void saveAndClose();
	
}
