public static void main(String[] args) {
    FileService<Company> companyFileService = new FileService<>();
    
    // đọc dữ liệu từ file
    List<Company> companies = companyFileService.readFile("company.dat");
    System.out.println("List company in file: ");
    companyFileService.printList(companies);

    Company shoppe = new Company("Shoppe", "admin@shoppe.com", "0123456789", "5 Science Park Drive, Shopee Building", "118265", "Singapore");
    companies.add(shoppe);

    // ghi dữ liệu vào file
    companyFileService.writeFile("company.dat", companies);

    companies = companyFileService.readFile("company.dat");
    System.out.println("List company in file: ");
    companyFileService.printList(companies);

}

public List<T> readFile(String fileName){
    List<T> objects = new ArrayList<>();
    try(ObjectInputStream file = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
        boolean eof = false;
        while(!eof) {
            try {
                T object = (T) file.readObject();
                objects.add(object);
            } catch(EOFException e) {
                eof = true;
            }
        }
    } catch(IOException io) {
        System.out.println("IO Exception" + io.getMessage());
    } catch(ClassNotFoundException e) {
        System.out.println("ClassNotFoundException " + e.getMessage());
    }
    return objects;
}

public void writeFile(String fileName, List<T> objects){
    try (ObjectOutputStream companyFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
        for (T object : objects) {
            companyFile.writeObject(object);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
	. 
	// Hiển thị dữ liệu của các công ty ra màn hình
	// Thực hiện thêm mới một công ty vào danh sách
	// Ghi danh sách mới cập nhật vào file
	// Sử dụng đọc ghi file sử dụng ObjectInputStream và ObjectOutputStream
}