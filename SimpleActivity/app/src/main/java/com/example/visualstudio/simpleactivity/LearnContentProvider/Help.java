package com.example.visualstudio.simpleactivity.LearnContentProvider;

/**
 * Created by Visual Studio on 6/29/2017.
 */
/*
//Lý thuyết cần nắm
Content Provider
    - Là một thành phần cung cấp dữ liệu từ một ứng dụng này đến ứng dụng khác dựa trên các request.
    - Mỗi request là một phương thức của class ContentPresolver.
    - Mỗi ContentProvider có thể lưu trữ dữ liệu trong database,file,Network.
    - Cho phép tập trung dữ liệu vào một nơi và các ứng dụng khác truy xuất vào nó khi cần thiết.
    - Hoạt động giống như một cơ sở dữ liệu, có thể thực hiện các phương thức: insert(), update(),delete(),query()...
    - Trong nhiều trường hợp nó được lưu lại trong SQLite.

Content Provider kế thừa từ class ContentProvider{} và imlement từ một tập API chuẩn để giao tiếp, xử lí các yêu cầu.
    public class MyContentProvider extends ContentProvider{
        .....
    }


Content URI
    Để truy vấn một Content Provider thì cần phải chỉ định một chuỗi truy vấn theo định dạng sau:

    <prefix>://<authority>/<data_type>/<id>

        prefix      : Nó luôn được thiết lập là content://
        authority   : Chỉ định tên cụ thể của content Provider(VD:Contacts,Browser,..)
                      Đối với một số Content Provider khác thì phải nhập tên đầy đủ
                      VD: com.example.visualstudio.simpleactivity.ContentProvider
        data_type   : Kiêu dữ liệu (VD để lấy tất cả các liên hệ trong Contacts content
                    thì kiểu dữ liệu phải là
                    URI: content://contacts/people.
        id          : Chỉ rõ một record ( bản ghi) (VD: Nếu muốn lấy một địa chỉ liên lạc thứ 5 trong
                    Contact Content Provider thì URI: content://contacts/people/5.

//Thực hành
Tạo một Content Provider của riêng bạn: gồm 5 bước:
    Bước 1: Tạo một class kế thừ từ class ContentProvider
    Bước 2: Khai báo một URI cho Content Provider nó được dùng để truy xuất nội dung.
    Bước 3: Bạn cần tạo một CSDL của riêng bạn để lưu các Content. Thông thường,
            Android sử dụng CSDL SQLite, cần phải Override phương thức onCreate() nó sẽ sử dụng
            phương thức SQLite Open Helper để tạo hoặc mở CSDL của provider.
            Khi ứng dụng của bạn khởi chạy, phương thức onCreate() sẽ xử lý các Content Providers
            của nó.
    Bước 4: implement tất cả các phương thức của Content Provider để xử lí các dữ liệu trả về.
    Bước 5: Đăng ký Content Provider của bạn bằng cách sử dụng nhãn <provider>

Các phương thức cần được override trong class ContentProvider
    onCreate()  : Phương thức này được gọi khi một Provider được bắt đầu.
    query()     : Phương thức dùng để nhận yêu cầu từ Client. Kết quả trả về là một đối tượng
                  Cursor (con trỏ).
    insert()    : Phương thức chèn một dòng dữ liệu mới vòa ContentProvider.
    delete()    : Phương thức xóa một dòng dữ liệu đã tồn tại.
    update()    : Phương thức cập nhật một dòng dữ liệu nào đó đã tồn tại.
    getType()   : Phưuong thức trả về kiểu MIME của dữ liệu tại các URI.
* */