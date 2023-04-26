Các biến trong chương trình:

arr: mảng chứa n phần tử.
k: số lượng phần tử trong một tổ hợp.
combo: mảng chứa các phần tử của một tổ hợp.
Hàm printCombinations() sử dụng kỹ thuật đệ quy để liệt kê tất cả các tổ hợp có k phần tử của mảng arr. Các tham số đầu vào của hàm là:

arr: mảng chứa các phần tử của tập hợp ban đầu.
combo: mảng chứa các phần tử của tổ hợp đang được xây dựng.
i: chỉ số của phần tử đang được xét trong mảng arr.
j: chỉ số của phần tử đang được thêm vào trong mảng combo.
Cách thức hoạt động của hàm printCombinations() như sau:

Nếu combo đã chứa đủ k phần tử, ta in ra tổ hợp đó và kết thúc hàm.
Nếu đã duyệt hết tất cả các phần tử của arr, ta kết thúc hàm.
Nếu chưa chọn đủ k phần tử cho tổ hợp, ta chọn phần tử ở vị trí i vào combo và gọi đệ quy để tiếp tục thêm phần tử vào combo. Sau khi quay lại từ đệ quy, ta thử không chọn phần tử ở vị trí i và tiếp tục với phần tử tiếp theo.



