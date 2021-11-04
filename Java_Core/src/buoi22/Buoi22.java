package buoi22;

public class Buoi22 {
    /*
    *** MySQL ***
    *
    * Relational Databases - Mối quan hệ:
    * 1-1 : quan hệ sở hữu 1-1
    * VD: 1 người chỉ có thể có 1 CCCD
    *   Công dân (bảng)
    *       id      name        id_cccd
    *       1       sang        1
    *   CCCD (bảng)
    *       id      cccd
    *       1       001199023024
    * 1-n : quan hệ sở hữu 1-n
    * VD: 1 người thì có thể có nhiều chiếc xe máy
    *   Người (bảng)
    *       id      name
    *       1       sang
    *       2       nam
    *   Xe máy (bảng)
    *       id      nameXe        id-người
    *       1       HonDa           1
    *       2       Wave            1
    * n-1 : ngược lại với 1-n , tương tự.
    * n-n : quan hệ sở hữu n-n => tách ra là 1 -n và n-1 :  thêm bảng phụ
    * vD:  1 người học nhiều môn học      1-n
    *      1 môn học có nhiều người học   n-1
    *   Sinh viên (bảng)
    *       id      name
    *       1       sang
    *       2       nam
    *   Môn học (bảng)
    *       id      nameMonHoc
    *       1       toan
    *       2       ly
    *       3       anh
    *   Xác nhận (bảng) => bảng phụ
    *       id_sv      id_mh
    *       1           1
    *       1           3
    *       2           2
    *       2           3
    *
    *
    *
    * */
}
