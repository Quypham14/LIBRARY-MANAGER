## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

----------------------------------------------------------
Mô hình sử dụng là mô hình 3 lớp
- Tầng Trình bày (Presentation Tier): Sẽ được xử lý trực tiếp trong lớp Main.java. Lớp này sẽ chịu trách nhiệm hiển thị thông tin ra console (sử dụng System.out.println()) và nhận dữ liệu đầu vào từ người dùng (sử dụng Scanner hoặc các phương thức tương tự).

- Tầng Ứng dụng/Logic nghiệp vụ (Application/Business Logic Tier): Các lớp trong thư mục manager (AuthorManager.java, DocumentManager.java, UserManager.java) vẫn giữ vai trò chứa logic nghiệp vụ. Chúng sẽ nhận dữ liệu từ tầng trình bày, thực hiện các xử lý cần thiết, và tương tác với tầng dữ liệu để lưu trữ hoặc truy xuất thông tin.

- Tầng Dữ liệu (Data Tier): Các lớp trong thư mục model (Author.java, Document.java, User.java) vẫn định nghĩa cấu trúc dữ liệu. Các lớp Manager sẽ sử dụng các đối tượng này để tương tác với cơ sở dữ liệu MySQL thông qua thư viện mysql-connector-j-9.3.0.jar.
------->
1. File: README.md
Chức năng:
Cung cấp hướng dẫn và thông tin khởi đầu cho người dùng về cách sử dụng dự án.
Giải thích cấu trúc thư mục, cách biên dịch và chạy ứng dụng, cũng như các thông tin cần thiết khác.
Bao gồm thông tin về mô hình 3 lớp của ứng dụng:
Tầng Trình bày (Presentation Tier): Xử lý giao diện người dùng.
Tầng Ứng dụng (Application Tier): Chứa logic nghiệp vụ.
Tầng Dữ liệu (Data Tier): Định nghĩa cấu trúc dữ liệu và tương tác với cơ sở dữ liệu.
2. File: settings.json
Chức năng:
Cấu hình cho dự án Java trong Visual Studio Code.
Định nghĩa các đường dẫn cho mã nguồn (java.project.sourcePaths), đường dẫn đầu ra (java.project.outputPath), và các thư viện tham chiếu (java.project.referencedLibraries).
Giúp IDE nhận diện cấu trúc dự án và các phụ thuộc cần thiết.
3. File: tasks.json
Chức năng:
Định nghĩa các tác vụ để biên dịch và chạy mã Java.
Bao gồm các lệnh shell cho việc biên dịch (javac) và chạy chương trình (java).
Cấu hình các tham số cần thiết như đường dẫn đến thư viện MySQL Connector và các file nguồn Java.
Khi cần chạy dự án, thay vì việc ta cần chạy một câu lệnh dài thì ta chỉ cần ấn ctrl+shift+B
4. Folder: src
Chức năng:
Chứa mã nguồn của dự án, bao gồm các lớp Java được tổ chức theo cấu trúc hợp lý.
4.1. File: Main.java
Chức năng:
Điểm vào chính của ứng dụng, nơi bắt đầu thực thi chương trình.
Xử lý quá trình đăng nhập của người dùng, yêu cầu nhập tên người dùng và mật khẩu.
Dựa trên vai trò của người dùng (admin, staff, reader), điều hướng đến các menu quản lý tương ứng.
4.2. Folder: manager
Chức năng:
Chứa các lớp quản lý logic nghiệp vụ cho ứng dụng, xử lý các yêu cầu từ tầng trình bày và tương tác với tầng dữ liệu.
4.2.1. File: AuthorManager.java
Chức năng:
Quản lý các chức năng liên quan đến tác giả.
Cung cấp các phương thức để xem, thêm, cập nhật và xóa tác giả trong cơ sở dữ liệu.
Sử dụng DBConnection để kết nối với cơ sở dữ liệu và thực hiện các truy vấn SQL.
4.2.2. File: UserManager.java
Chức năng:
Quản lý chức năng đăng nhập của người dùng.
Xác thực thông tin người dùng với cơ sở dữ liệu thông qua phương thức login.
Trả về đối tượng User  nếu đăng nhập thành công, hoặc thông báo lỗi nếu không.
4.2.3. File: DocumentManager.java
Chức năng:
Quản lý các chức năng liên quan đến tài liệu.
Cung cấp các phương thức để xem, thêm, cập nhật và xóa tài liệu trong cơ sở dữ liệu.
Thực hiện các truy vấn SQL để tương tác với bảng tài liệu.
4.3. Folder: model
Chức năng:
Chứa các lớp mô hình dữ liệu, định nghĩa cấu trúc dữ liệu cho các thực thể trong ứng dụng.
4.3.1. File: User.java
Chức năng:
Định nghĩa cấu trúc dữ liệu cho người dùng.
Bao gồm các thuộc tính như ID, tên người dùng, mật khẩu và vai trò.
Cung cấp các phương thức getter và setter để truy cập và thay đổi thông tin người dùng.
4.3.2. File: Author.java
Chức năng:
Định nghĩa cấu trúc dữ liệu cho tác giả.
Bao gồm các thuộc tính như ID, tên đầy đủ và tiểu sử.
Cung cấp các phương thức getter và setter để truy cập và thay đổi thông tin tác giả.
4.3.3. File: Document.java
Chức năng:
Định nghĩa cấu trúc dữ liệu cho tài liệu.
Bao gồm các thuộc tính như ID, tiêu đề, ID nhà xuất bản, năm xuất bản, thể loại, số lượng bản sao và giá.
Cung cấp các phương thức getter và setter để truy cập và thay đổi thông tin tài liệu.
4.4. Folder: utils
Chức năng:
Chứa các lớp tiện ích hỗ trợ cho ứng dụng, giúp tái sử dụng mã và giảm thiểu sự trùng lặp.
4.4.1. File: DBConnection.java
Chức năng:
Quản lý kết nối đến cơ sở dữ liệu MySQL.
Cung cấp phương thức getConnection để lấy kết nối đến cơ sở dữ liệu, xử lý các ngoại lệ liên quan đến kết nối.
Đảm bảo rằng ứng dụng có thể tương tác với cơ sở dữ liệu một cách hiệu quả.
5. Folder: lib
Chức năng:
Chứa các thư viện bên ngoài cần thiết cho dự án, ví dụ như thư viện MySQL Connector.
Giúp ứng dụng có thể kết nối và tương tác với cơ sở dữ liệu MySQL.
6. File: CREATE DATABASE IF NOT EXISTS libra.txt
Chức năng:
Các câu lệnh sql note lại
