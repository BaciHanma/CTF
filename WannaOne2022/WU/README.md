# STEGANO
![](https://github.com/northern-cyber/CTF/blob/main/WannaOne2022/WU/challenge.png)

Đầu tiên, khi tải ảnh của challenge về chúng ta thấy:
![](https://github.com/northern-cyber/CTF/blob/main/WannaOne2022/WU/decode-get-flag.png)

Với tên file là "decode-get-flag" có thể nhiều bạn sẽ tìm cách để lấy được các mã base64 mà tác giả viết ở trong ảnh và thử decode. Nếu bạn làm vậy thì chúc mừng bạn.
Đây là flag: [Flag Xịnnnnn](https://bit.ly/3Wd1Myu](https://www.google.com/search?q=h%C3%ACnh+troll&sxsrf=ALiCzsazNaa9xanTQWF49caNg3sokJBp8Q:3667008736853&source=lnms&tbm=isch&sa=X&ved=2ahUKEwj4zOO8q4T7AhUl-jgGHahNBNoQ_AUoAXoECAIQAw&biw=730&bih=981&dpr=0.94#io.rc=BDbujqGIWFYSZM))

Đùa chút thôi, mình cũng đã thử lấy hết các đoạn base64 trong ảnh nhưng tất cả đều vô nghĩa.

Bạn có thể dùng hexedit để xem trong file có ẩn các file signature khác ẩn bên trong không. Mình thử binwalk và trong file có ẩn 1 file zip và 1 file ảnh khác.

![image](https://user-images.githubusercontent.com/65294114/207081272-9c0a27d0-14dd-4486-9642-949d668e1b86.png)

Tuy nhiên file zip cần phải có password mới có thể giải nén được. Tìm password ở đâu được nhỉ?? Thử crack zip với passlist rockyou thì không được. Vậy chắc chắn file ảnh bên cạnh có chứa password.
![image](https://user-images.githubusercontent.com/65294114/207084524-71a796f9-3e3f-4465-a1e6-dd7b0ed366ca.png)

Mình có chạy thử zsteg ngay từ ban đầu nhưng không nhận ra đoạn base32 ẩn đằng sau cho đến gần hết giải mới nhận ra và thử decode. Thì thật bất ngờ đây là pass của file zip.

![image](https://user-images.githubusercontent.com/65294114/207086324-e52a8094-920f-475a-af6d-4862af22c9f7.png)

Tưởng là flag đây rồi! Nhưng không! Không hề. Lại một file ảnh nữa. Ném file này vào hexedit thì thấy cuối file có điều khá bất thường.

Có thể đây là gợi ý để sử dụng steghide.

![image](https://user-images.githubusercontent.com/65294114/207093067-b110c881-ff71-45de-98c2-3ad73ed83c48.png)
![image](https://user-images.githubusercontent.com/65294114/207093379-f079440a-bbdf-4ea4-8afa-c661c3f31dff.png)

Sau khi xong chúng ta được 1 file là pass.
Mở ra sẽ thấy một [link drive](https://drive.google.com/file/d/1huVD4WvErpgr5Bhc3ArkXYNu4Hoe8kpk/view?usp=sharing):
![image](https://user-images.githubusercontent.com/65294114/207093550-647d3152-967c-483e-8f7e-625278e463eb.png)

flag ư?? Không! Không!! Lại một file ảnh nữa!!

![image](https://user-images.githubusercontent.com/65294114/207094574-fe695ad6-40c1-4476-9eef-1403faf6936b.png)

Mình bế tắc ở bước này, sau khi giải kết thúc mình có hỏi superidol ***BlueDragonAkaBquanman*** thì mới biết là bức ảnh này thực chất đang bị sai size. Để có thể chỉnh chiều cao ảnh hoặc chiều ngang ảnh các bạn có thể đọc [ở đây](https://blog.cyberhacktics.com/hiding-information-by-changing-an-images-height/).

Mở file info thì các bạn có thể thấy chiều dài và chiều rộng của ảnh:
![image](https://user-images.githubusercontent.com/65294114/207096477-2621013c-b051-4358-9364-a4b6a76d4f5b.png)

Để chỉnh chiều dài thì mình sẽ sử dụng cyberchef:
![image](https://user-images.githubusercontent.com/65294114/207096132-308fc85e-7272-4470-ace8-897cd81a8db0.png)

Search theo signature mà các bạn đọc ở link trên:

![image](https://user-images.githubusercontent.com/65294114/207096623-8c22fba1-af11-43ff-b2e8-01b1da719a10.png)

Có thể thấy chiều dài ảnh là 853 (0x355 in Hex). Chúng ta sẽ sửa để nó dài hơn và render lại ảnh:
![image](https://user-images.githubusercontent.com/65294114/207097175-238d0c87-781f-4857-8870-9e126aede9d3.png)

Và Nooooo! Vẫn chưa hết! lại ra một đoạn mã morse ở phía dưới. 
Sau khi decode đoạn mã morse này sẽ ra flag?? Không! Vẫn chưa hết! Ra một [link pastebin](https://kt.gy/tools.html#conv/https%3A%2F%2Fpastebin.com%2Fraw%2FM0V3YD43).
Tưởng rằng mọi thứ đã xong nhưng không. Phải tìm đúng url của pastebin nữa :( .
Có thể tham khảo code tìm của mình: [brute.py](https://github.com/northern-cyber/CTF/blob/main/WannaOne2022/WU/brute.py)
Sau khi tìm được đúng url. Ta được một [link drive](https://drive.google.com/file/d/1HrY6vWcSAOTXQT-DgOKc1E4VHDXqhfKY/view) dẫn đến một file âm thanh.
Để tìm được flag các bạn có thể tải app ***robot36*** trên android để thu sóng phát ra từ file âm thanh:

![image](https://user-images.githubusercontent.com/65294114/207100077-e6595c51-929e-4071-94b0-b40046c997e5.png)

![image](https://user-images.githubusercontent.com/65294114/207100727-88d1433c-0d02-4efb-a59e-49c7894a1299.png)


