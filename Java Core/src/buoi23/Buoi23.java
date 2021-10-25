package buoi23;

public class Buoi23 {

    /*
### Chọn và kết
#Câu 1:
SELECT * FROM chuyenbay
WHERE GaDi = 'DAD';

#Câu 2:
SELECT * FROM maybay
WHERE TamBay > 10000;

#Câu 3:
SELECT * FROM csdlhangkhong.nhanvien
WHERE Luong < 10000;

#Câu 4:
SELECT * FROM chuyenbay
WHERE DoDai < 10000 AND DoDai > 8000;
-- BETWEEN <=> >= và <=
SELECT * FROM chuyenbay
WHERE DoDai BETWEEN 8000 AND 10000;

#Câu 5:
SELECT * FROM chuyenbay
WHERE GaDi = 'SGN' AND GaDen = 'BMV';

#Câu 6:
SELECT * FROM chuyenbay
WHERE GaDi = 'SGN';
SELECT COUNT(1) FROM chuyenbay
WHERE GaDi = 'SGN';

#Câu 7:
SELECT * FROM maybay
WHERE Loai LIKE '%Boeing%';
SELECT COUNT(1) FROM maybay
WHERE Loai LIKE '%Boeing%';
SELECT COUNT(1) as TongSo FROM maybay
WHERE Loai LIKE '%Boeing%';

#Câu 8:
SELECT SUM(Luong) as TongSoLuong FROM csdlhangkhong.nhanvien;

#Câu 9:
-- INNER JOIN
SELECT MaNV FROM chungnhan cn
    INNER JOIN maybay mb on cn.MaMB = mb.MaMB
WHERE Loai LIKE 'Boeing%';
-- => bị lặp
-- DISTINCT : Lấy ra duy nhất, tránh lặp
SELECT DISTINCT MaNV FROM chungnhan cn
    INNER JOIN maybay mb on cn.MaMB = mb.MaMB AND Loai LIKE 'Boeing%';
-- => nên dùng như vậy để câu query nhanh hơn

#Câu 10:
SELECT nv.* FROM csdlhangkhong.nhanvien nv
    INNER JOIN chungnhan cn on nv.MaNV = cn.MaNV AND MaMB = 747;

#Câu 11:
SELECT MaMB FROM chungnhan cn
    INNER JOIN csdlhangkhong.nhanvien nv on cn.MaNV = nv.MaNV AND Ten LIKE 'Nguyen%';

#Câu 12:
-- Tự viết => sai!!!
SELECT DISTINCT MaNV FROM chungnhan cn
    INNER JOIN maybay m on cn.MaMB = m.MaMB AND Loai LIKE 'Boeing%' OR 'Airbus%';
-- Chữa
-- Cách 1:
SELECT DISTINCT chungnhan.MaNV, rs.MaNV FROM chungnhan
    INNER JOIN maybay m on chungnhan.MaMB = m.MaMB AND Loai LIKE 'Boeing%'
        LEFT JOIN (SELECT DISTINCT MaNV FROM chungnhan
                        INNER JOIN maybay m on chungnhan.MaMB = m.MaMB AND Loai LIKE 'Airbus%') as rs
        ON rs.MaNV = chungnhan.MaNV
WHERE rs.MaNV is not null;
-- Cách 2:
SELECT DISTINCT chungnhan.MaNV FROM chungnhan
    INNER JOIN maybay m on chungnhan.MaMB = m.MaMB AND Loai LIKE 'Boeing%'
WHERE MaNV IN (SELECT DISTINCT MaNV FROM chungnhan
                    INNER JOIN maybay m on chungnhan.MaMB = m.MaMB AND Loai LIKE 'Airbus%');
-- Cách 3:
SELECT DISTINCT cn.MaNV FROM chungnhan cn
    LEFT JOIN maybay m on cn.MaMB = m.MaMB AND Loai LIKE 'Boeing%'
WHERE EXISTS(SELECT * FROM (SELECT DISTINCT MaNV FROM chungnhan
                                INNER JOIN maybay m on chungnhan.MaMB = m.MaMB AND Loai LIKE 'Airbus%') as rs
                            WHERE rs.MaNV = CN.MaNV
    );

#Câu 13:
-- câu lệnh lồng => sub query
SELECT * FROM maybay
WHERE TamBay >= (SELECT DoDai FROM chuyenbay WHERE MaCB = 'VN280');

#Câu 14:
SELECT * FROM chuyenbay
WHERE DoDai <= (SELECT  TamBay FROM maybay WHERE Loai = 'Airbus A320');

#Câu 15:
--
SELECT DISTINCT Ten FROM csdlhangkhong.nhanvien nv
    INNER JOIN chungnhan c on nv.MaNV = c.MaNV
        INNER JOIN maybay m on m.MaMB = c.MaMB AND Loai LIKE 'Boeing%';
--
SELECT DISTINCT Ten FROM chungnhan c
    INNER JOIN maybay m on c.MaMB = m.MaMB AND Loai LIKE 'Boeing%'
        LEFT JOIN csdlhangkhong.nhanvien n on c.MaNV = n.MaNV;
SELECT DISTINCT Ten FROM chungnhan c
    INNER JOIN maybay m on c.MaMB = m.MaMB AND Loai LIKE 'Boeing%'
        INNER JOIN csdlhangkhong.nhanvien n on c.MaNV = n.MaNV;

#Câu 16:
SELECT Loai, COUNT(MaNV) TONG_PHI_CONG_CO_THE_LAI FROM maybay
    LEFT JOIN chungnhan c on maybay.MaMB = c.MaMB
GROUP BY c.MaMB;

#Câu 17:
-- SEFL JOIN
SELECT * FROM chuyenbay A, chuyenbay B
WHERE A.GaDi = B.GaDen AND A.GaDen = B.GaDi;

### Gom nhóm
#Câu 18:
-- Tự làm
SELECT GaDi, COUNT(GaDi) SO_CHUYEN_BAY_KHOI_HANH FROM chuyenbay
GROUP BY GaDi;
-- chữa
SELECT GaDi, COUNT(MaCB) SO_CHUYEN_BAY_KHOI_HANH FROM chuyenbay
GROUP BY GaDi;

#Câu 19:
SELECT GaDi, SUM(ChiPhi) TONG_CHI_PHI FROM chuyenbay
GROUP BY chuyenbay.GaDi;
-- Nếu tư duy đề bài phức tạp hơn
SELECT GaDi, SUM(rs.Luong) TONG_CHI_PHI FROM chuyenbay c,
    (SELECT DISTINCT TamBay, Luong FROM chungnhan
        INNER JOIN maybay m on chungnhan.MaMB = m.MaMB
        INNER JOIN csdlhangkhong.nhanvien n on chungnhan.MaNV = n.MaNV) as rs
WHERE rs.TamBay > c.DoDai
GROUP BY GaDi;

#Câu 20:
SELECT GaDi, GioDi, COUNT(MaCB) FROM chuyenbay
WHERE GioDi < '12:00'
GROUP BY GioDi;

#Câu 21:
SELECT MaNV, COUNT(1) FROM chungnhan
GROUP BY MaNV
HAVING COUNT(MaNV) = 3;

#Câu 22:
-- danh sách
SELECT MaNV, m.MaMB, TamBay FROM chungnhan c
    INNER JOIN maybay m on c.MaMB = m.MaMB;
-- Tự làm
SELECT MaNV, COUNT(1), MAX(TamBay) FROM chungnhan c
    INNER JOIN maybay m on c.MaMB = m.MaMB
GROUP BY MaNV
HAVING COUNT(MaNV) > 3;

#Câu 23:
-- Tự làm
SELECT MaNV, COUNT(1) FROM chungnhan
GROUP BY MaNV;
-- Chữa
SELECT MaNV, COUNT(MaMB) FROM chungnhan
GROUP BY MaNV;
-- => GROUP BY : sắp xếp
-- => gom nhóm --> Dùng GROUP BY thì tốn kém time --> Performance không tốt
-- Trong GROUP BY có chứa ORDER BY => có chữa câu lệnh sắp xếp rồi
-- Trong DISTINCT có chữa câu lệnh sắp xếp rồi => tốn time --> làm giảm Performance

#Câu 24:
SELECT MaNV
FROM (SELECT MaNV, COUNT(MaMB) TONG_LOAI_MAY_BAY
      FROM chungnhan
      GROUP BY MaNV) rs
WHERE rs.TONG_LOAI_MAY_BAY = (SELECT MAX(rs.TONG_LOAI_MAY_BAY)
                              FROM (SELECT MaNV, COUNT(MaMB) TONG_LOAI_MAY_BAY
                                    FROM chungnhan
                                    GROUP BY MaNV) rs
                              );

#Câu 25:
SELECT MaNV
FROM (SELECT MaNV, COUNT(MaMB) TONG_LOAI_MAY_BAY
      FROM chungnhan
      GROUP BY MaNV) rs
WHERE rs.TONG_LOAI_MAY_BAY = (SELECT MIN(rs.TONG_LOAI_MAY_BAY)
                              FROM (SELECT MaNV, COUNT(MaMB) TONG_LOAI_MAY_BAY
                                    FROM chungnhan
                                    GROUP BY MaNV) rs
                              );

### Truy vấn lồng
#Câu 26:
-- Tự làm
SELECT * FROM csdlhangkhong.nhanvien n
    LEFT JOIN chungnhan c on n.MaNV = c.MaNV
HAVING c.MaMB IS NULL;
-- Chữa
-- Cách 1:
SELECT * FROM csdlhangkhong.nhanvien n
    LEFT JOIN chungnhan c on n.MaNV = c.MaNV
HAVING c.MaNV IS NULL;
-- Cách 2:
SELECT * FROM csdlhangkhong.nhanvien n
WHERE NOT EXISTS
    (SELECT MaNV FROM chungnhan c WHERE n.MaNV = c.MaNV);
-- => Không nên dùng NOT EXISTS
-- => Nhưng EXISTS thì nên dùng => là 1 cách tối ưu Performance rất nhiều
-- Cách 3:
SELECT * FROM csdlhangkhong.nhanvien n
WHERE n.MaNV NOT IN(SELECT MaNV FROM chungnhan);

#Câu 27:
SELECT MaNV
FROM csdlhangkhong.nhanvien
WHERE Luong = (SELECT MAX(Luong) FROM csdlhangkhong.nhanvien);

#Câu 28:
-- Tự làm => bị dài
SELECT SUM(rs.Luong) TONG_SO_LUONG
FROM (SELECT *
      FROM csdlhangkhong.nhanvien n
      WHERE EXISTS(SELECT MaNV FROM chungnhan c WHERE c.MaNV = n.MaNV)) rs;
-- Chữa
-- Cách 1: INNER JOIN hay LEFT JOIN đều đc
SELECT SUM(Luong)
FROM csdlhangkhong.nhanvien n
WHERE MaNV IN (SELECT DISTINCT c.MaNV
               FROM csdlhangkhong.nhanvien n
                    LEFT JOIN chungnhan c on n.MaNV = c.MaNV
               WHERE c.MaNV IS NOT NULL);
-- Cách 2:
SELECT SUM(Luong)
FROM csdlhangkhong.nhanvien n
WHERE EXISTS(SELECT * FROM chungnhan c WHERE c.MaNV = n.MaNV);

-- Cách làm này sai: => SAI vì bị lặp
-- Danh sách -> bị lặp
SELECT *
FROM csdlhangkhong.nhanvien n
         LEFT JOIN chungnhan c on n.MaNV = c.MaNV
WHERE c.MaNV IS NOT NULL;
-- Tổng lương
SELECT SUM(Luong) TONG_SO_LUONG
FROM csdlhangkhong.nhanvien n
    LEFT JOIN chungnhan c on n.MaNV = c.MaNV
WHERE c.MaNV IS NOT NULL;

#Câu 29:
SELECT * FROM chuyenbay
WHERE DoDai <= (SELECT MIN(TamBay) FROM maybay
               WHERE Loai LIKE 'Boeing%');

#Câu 30:
SELECT MaMB FROM maybay
WHERE TamBay >= (SELECT DoDai FROM chuyenbay
                WHERE GaDi = 'SGN' AND GaDen = 'HUI');

#Câu 31:
-- Tự làm
SELECT * FROM chuyenbay c
WHERE DoDai < ANY
    (SELECT TamBay
    FROM maybay m
        INNER JOIN chungnhan c on c.MaMB = m.MaMB
                INNER JOIN csdlhangkhong.nhanvien n on n.MaNV = c.MaNV
    WHERE Luong > 100000);
-- Chữa
-- Cách 1:
SELECT * FROM chuyenbay c
WHERE DoDai < ANY
      (SELECT TamBay
       FROM csdlhangkhong.nhanvien n
                INNER JOIN chungnhan c on c.MaNV= n.MaNV
                INNER JOIN maybay m on m.MaMB = c.MaMB
       WHERE Luong > 100000);
-- Cách 2:
SELECT c.MaNV, c.TamBay, cb.*
FROM (SELECT c.MaNV, TamBay
      FROM csdlhangkhong.nhanvien n
            INNER JOIN chungnhan c on n.MaNV = c.MaNV
            INNER JOIN maybay m on c.MaMB = m.MaMB
      WHERE Luong > 100000) AS c,
     chuyenbay cb
WHERE cb.DoDai <= c.TamBay
ORDER BY c.MaNV;

#Câu 32:
-- Tự làm
SELECT * FROM csdlhangkhong.nhanvien n
    LEFT JOIN chungnhan c on n.MaNV = c.MaNV
WHERE C.MaNV IS NOT NULL
AND Luong < (SELECT MIN(ChiPhi)
               FROM chuyenbay
               WHERE GaDi = 'SGN' AND GaDen = 'BMV');

#Câu 33:
-- Tự làm
SELECT * FROM csdlhangkhong.nhanvien n
WHERE EXISTS(SELECT MaNV FROM chungnhan c WHERE c.MaNV = n.MaNV)
AND Luong = (SELECT MAX(Luong)
            FROM csdlhangkhong.nhanvien n
            WHERE EXISTS(SELECT MaNV FROM chungnhan c WHERE c.MaNV = n.MaNV));

#Câu 34:
-- Tự làm => bị dài
SELECT * FROM csdlhangkhong.nhanvien n
WHERE Luong = (SELECT MAX(rs.Luong)
               FROM (SELECT Luong
                     FROM csdlhangkhong.nhanvien
                     WHERE Luong <> (SELECT MAX(Luong)
                                        FROM csdlhangkhong.nhanvien)) rs );
-- Chữa
SELECT * FROM csdlhangkhong.nhanvien n
WHERE Luong = (SELECT MAX(Luong)
               FROM csdlhangkhong.nhanvien
               WHERE Luong <> (SELECT MAX(Luong)
                               FROM csdlhangkhong.nhanvien));

#Câu 35:
-- UNION : bỏ trùng nhau
-- UNION ALL : trùng cũng lấy => lấy hết
SELECT MaNV FROM csdlhangkhong.nhanvien n
WHERE Luong = (SELECT MAX(Luong)
               FROM csdlhangkhong.nhanvien)
UNION ALL
SELECT MaNV FROM csdlhangkhong.nhanvien n
WHERE Luong = (SELECT MAX(Luong)
               FROM csdlhangkhong.nhanvien
               WHERE Luong <> (SELECT MAX(Luong)
                               FROM csdlhangkhong.nhanvien));
-- => Biết chắc dữ liệu không trùng nhau => dùng UNION
-- => Vì UNION ALL giúp câu lệnh tối ưu Performance
-- => Với UNION, UNION cần sắp xếp những phần tử trùng nhau đứng cạnh nhau rồi loại bỏ trùng nhau

#Câu 36:
-- Tự làm
SELECT * FROM csdlhangkhong.nhanvien n
    LEFT JOIN chungnhan c on n.MaNV = c.MaNV
WHERE c.MaNV IS NULL
AND Luong > (SELECT AVG(Luong)
            FROM csdlhangkhong.nhanvien nv
            WHERE EXISTS(SELECT MaNV FROM chungnhan cn WHERE nv.MaNV = cn.MaNV));
-- => có thể biến tấu dùng IN, DISTINCT

#Câu 37:
-- Chữa
-- Cách 1: => đã chỉnh thêm
SELECT MaNV, Ten
FROM csdlhangkhong.nhanvien nv
WHERE MaNV IN(SELECT MaNV FROM chungnhan cn
                INNER JOIN maybay m on m.MaMB = cn.MaMB AND m.TamBay > 4800
            WHERE MaNV NOT IN(SELECT DISTINCT MaNV
                            FROM chungnhan c
                                INNER JOIN maybay m on c.MaMB = m.MaMB
                            WHERE Loai LIKE 'Boeing%'));
-- Cách 2 => dùng EXISTS

#Câu 38:
SELECT rs.Ten FROM (SELECT Ten, COUNT(c.MaMB) count
                    FROM csdlhangkhong.nhanvien n
                        LEFT JOIN chungnhan c on n.MaNV = c.MaNV
                            INNER JOIN maybay m on c.MaMB = m.MaMB
                    WHERE c.MaNV IS NOT NULL AND TamBay > 3200
                    GROUP BY Ten) rs
WHERE rs.count >= 3;

### Kết ngoài
#Câu 39:
SELECT nv.MaNV, Ten, COUNT(MaMB)
FROM csdlhangkhong.nhanvien nv
    LEFT JOIN chungnhan c on nv.MaNV = c.MaNV
GROUP BY nv.MaNV;

#Câu 40:
SELECT nv.MaNV, Ten, COUNT(MaMB)
FROM csdlhangkhong.nhanvien nv
         LEFT JOIN chungnhan c on nv.MaNV = c.MaNV
WHERE c.MaMB = ANY(SELECT m.MaMB FROM maybay m WHERE Loai LIKE 'Boeing%')
GROUP BY nv.MaNV;

#Câu 41:
-- Tự làm
SELECT Loai, COUNT(MaNV)
FROM maybay mb
    INNER JOIN chungnhan c on mb.MaMB = c.MaMB
GROUP BY Loai;
-- Chữa
SELECT Loai, COUNT(MaNV)
FROM chungnhan
    INNER JOIN maybay m on chungnhan.MaMB = m.MaMB
GROUP BY Loai;

#Câu 42:
-- Tự làm => bỏ mất 2 giá trị = 0
SELECT Loai, COUNT(MaCB)
FROM maybay
    INNER JOIN chuyenbay on TamBay < DoDai
GROUP BY Loai;
-- Chữa
SELECT Loai,
    (SELECT COUNT(MaCB) FROM chuyenbay WHERE DoDai > maybay.TamBay) AS SO_CHUYEN_BAY
FROM maybay;

#Câu 43:
-- Tự làm
SELECT Loai, COUNT(c.MaNV)
FROM maybay m
    LEFT JOIN chungnhan c on m.MaMB = c.MaMB
WHERE c.MaNV IN(SELECT MaNV FROM csdlhangkhong.nhanvien WHERE Luong > 100000)
GROUP BY Loai;
-- Chữa
SELECT Loai, COUNT(n.MaNV)
FROM maybay m
    INNER JOIN chungnhan c on m.MaMB = c.MaMB
        INNER JOIN csdlhangkhong.nhanvien n on c.MaNV = n.MaNV AND Luong > 100000
GROUP BY Loai;

#Câu 44:
-- Tự làm
SELECT Loai, AVG(Luong)
FROM maybay mb
    INNER JOIN chungnhan c on mb.MaMB = c.MaMB
        INNER JOIN csdlhangkhong.nhanvien n on c.MaNV = n.MaNV
WHERE TamBay > 3200
GROUP BY Loai;
-- Chữa
SELECT Loai, AVG(Luong)
FROM chungnhan c
    INNER JOIN maybay m on c.MaMB = m.MaMB AND TamBay > 3200
        INNER JOIN csdlhangkhong.nhanvien n on c.MaNV = n.MaNV
GROUP BY Loai;

#Câu 45:
-- Chữa
SELECT Loai,
       (SELECT COUNT(1) FROM csdlhangkhong.nhanvien) - (SELECT COUNT(1) FROM chungnhan c WHERE c.MaMB = m.MaMB)
FROM maybay m;

#Câu 46:
-- Chữa
SELECT Loai,
       (SELECT COUNT(DISTINCT MaNV) FROM chungnhan) - (SELECT COUNT(MaNV) FROM chungnhan c WHERE c.MaMB = m.MaMB)
FROM maybay m;

#Câu 47:
-- Tự làm => không đúng
SELECT nv.MaNV, Ten, COUNT(MaMB)
FROM csdlhangkhong.nhanvien nv
         LEFT JOIN chungnhan c on nv.MaNV = c.MaNV
WHERE c.MaMB = ANY(SELECT m.MaMB
                    FROM maybay m
                        INNER JOIN chuyenbay cb on TamBay >= cb.DoDai
                    WHERE GaDi = 'SGN')
GROUP BY nv.MaNV;
-- Chữa
-- Cách 1
SELECT rs.MaNV, rs.Ten, (SELECT COUNT(1) FROM chuyenbay WHERE DoDai < rs.MAX_TAM_BAY AND GaDi = 'SGN')
FROM (SELECT nv.MaNV, nv.Ten, MAX(TamBay) AS MAX_TAM_BAY
    FROM csdlhangkhong.nhanvien nv
        LEFT JOIN chungnhan c on nv.MaNV = c.MaNV
            LEFT JOIN maybay m on c.MaMB = m.MaMB
    GROUP BY nv.MaNV) AS rs;
-- Cách 2
SELECT nv.MaNV, nv.Ten,
       (SELECT COUNT(1)
        FROM chuyenbay
        WHERE DoDai < (SELECT MAX(TamBay)
                        FROM maybay mb
                            INNER JOIN chungnhan c on mb.MaMB = c.MaMB
                        WHERE nv.MaNV = c.MaNV)
        AND GaDi = 'SGN')
FROM csdlhangkhong.nhanvien nv;

#Câu 48:
-- Chữa
-- Cách 1
SELECT rs.MaNV, rs.Ten,
       (SELECT COUNT(1) FROM chuyenbay WHERE GaDi = 'SGN') - (SELECT COUNT(1) FROM chuyenbay WHERE DoDai < rs.MAX_TAM_BAY AND GaDi = 'SGN')
FROM (SELECT nv.MaNV, nv.Ten, MAX(TamBay) AS MAX_TAM_BAY
      FROM csdlhangkhong.nhanvien nv
            LEFT JOIN chungnhan c on nv.MaNV = c.MaNV
               LEFT JOIN maybay m on c.MaMB = m.MaMB
      GROUP BY nv.MaNV) AS rs;
-- Cách 2
SELECT nv.MaNV, nv.Ten,
       (SELECT COUNT(1) FROM chuyenbay WHERE GaDi = 'SGN')
           -
       (SELECT COUNT(1) FROM chuyenbay
       WHERE DoDai < (SELECT MAX(TamBay)
                       FROM maybay mb
                            INNER JOIN chungnhan c on mb.MaMB = c.MaMB
                       WHERE nv.MaNV = c.MaNV)
        AND GaDi = 'SGN')
FROM csdlhangkhong.nhanvien nv;

#Câu 49:
-- Chữa
SELECT rs.MaNV, rs.Ten, (SELECT COUNT(1) FROM chuyenbay WHERE DoDai < rs.MAX_TAM_BAY AND GaDi = 'SGN')
FROM (SELECT nv.MaNV, nv.Ten, MAX(TamBay) AS MAX_TAM_BAY
      FROM csdlhangkhong.nhanvien nv
            INNER JOIN chungnhan c on nv.MaNV = c.MaNV
                INNER JOIN maybay m on c.MaMB = m.MaMB
      GROUP BY nv.MaNV) AS rs;

#Câu 50:
-- Chữa
SELECT rs.MaNV, rs.Ten,
       (SELECT COUNT(1) FROM chuyenbay WHERE GaDi = 'SGN') - (SELECT COUNT(1) FROM chuyenbay WHERE DoDai < rs.MAX_TAM_BAY AND GaDi = 'SGN')
FROM (SELECT nv.MaNV, nv.Ten, MAX(TamBay) AS MAX_TAM_BAY
      FROM csdlhangkhong.nhanvien nv
               INNER JOIN chungnhan c on nv.MaNV = c.MaNV
               INNER JOIN maybay m on c.MaMB = m.MaMB
      GROUP BY nv.MaNV) AS rs;

#Câu 51:
-- Chữa
SELECT MaCB,
    (SELECT COUNT(Loai) FROM maybay WHERE TamBay < chuyenbay.DoDai)
FROM chuyenbay;

#Câu 52:
-- Chữa
SELECT MaCB,
    (SELECT COUNT(Loai) FROM maybay WHERE TamBay > chuyenbay.DoDai)
FROM chuyenbay;

#Câu 53:
-- Chữa
SELECT MaCB,
    (SELECT COUNT(1) FROM csdlhangkhong.nhanvien)
        -
    (SELECT COUNT(rs.MaNV)
     FROM (SELECT nv.MaNV, MAX(TamBay) AS MAX_TAM_BAY
           FROM csdlhangkhong.nhanvien nv
                LEFT JOIN chungnhan c on nv.MaNV = c.MaNV
                    LEFT JOIN maybay m on m.MaMB = c.MaMB
           GROUP BY nv.MaNV) AS rs
     WHERE c.DoDai < rs.MAX_TAM_BAY)
FROM chuyenbay c;

#Câu 54:
-- Chữa
SELECT MaCB,
       (SELECT COUNT(DISTINCT MaNV) FROM chungnhan)
           -
       (SELECT COUNT(rs.MaNV)
        FROM (SELECT nv.MaNV, MAX(TamBay) AS MAX_TAM_BAY
              FROM csdlhangkhong.nhanvien nv
                    LEFT JOIN chungnhan c on nv.MaNV = c.MaNV
                       LEFT JOIN maybay m on m.MaMB = c.MaMB
              GROUP BY nv.MaNV) AS rs
        WHERE c.DoDai < rs.MAX_TAM_BAY)
FROM chuyenbay c;

### Exists và các dạng khác
#Câu 55:
-- Tự làm
SELECT cb1.MaCB, cb1.GioDi, cb1.GaDi, cb1.GaDen
FROM chuyenbay cb1
WHERE ( cb1.GaDi = 'HAN' AND cb1.GaDen = 'CXR' AND cb1.GioDen < '16:00' )
OR ( cb1.GaDi = 'HAN' AND cb1.GaDen = ANY(SELECT cb2.GaDi FROM chuyenbay cb2
                                            WHERE cb2.GaDen = 'CXR' AND cb1.GioDen < cb2.GioDi));

#Câu 56:
-- Tự làm
SELECT Loai, COUNT(c.MaNV) FROM chungnhan c
    LEFT JOIN maybay m on c.MaMB = m.MaMB
        LEFT JOIN csdlhangkhong.nhanvien n on c.MaNV = n.MaNV
WHERE Luong > 200000
GROUP BY Loai;

#Câu 57:
-- Chưa làm được



#Câu 58:
SELECT * FROM csdlhangkhong.nhanvien nv
WHERE EXISTS(SELECT MaNV FROM chungnhan cn WHERE nv.MaNV = cn.MaNV)
AND MaNV <> ALL(SELECT MaNV FROM chungnhan c
                        INNER JOIN maybay m on c.MaMB = m.MaMB
                    WHERE TamBay <= 3200);

#Câu 59:
-- Tự làm
SELECT DISTINCT Ten FROM csdlhangkhong.nhanvien nv
    INNER JOIN chungnhan c2 on nv.MaNV = c2.MaNV AND c2.MaNV IS NOT NULL
        INNER JOIN maybay m2 on c2.MaMB = m2.MaMB AND Loai LIKE 'Boeing%'
WHERE nv.MaNV <> ALL(SELECT MaNV FROM chungnhan c
                        INNER JOIN maybay m on c.MaMB = m.MaMB
                  WHERE TamBay <= 3200);
-- Chữa => có vẻ k chuẩn
SELECT DISTINCT Ten
FROM csdlhangkhong.nhanvien nv
    INNER JOIN chungnhan c on nv.MaNV = c.MaNV
        INNER JOIN maybay m on c.MaMB = m.MaMB
                                   AND TamBay > 3200
                                   AND Loai LIKE 'Boeing%';

#Câu 60:
-- Chữa
SELECT MaNV
FROM chungnhan c
    INNER JOIN maybay m on c.MaMB = m.MaMB
GROUP BY MaNV
HAVING COUNT(m.Loai) = (SELECT COUNT(Loai) FROM maybay);

#Câu 61:
-- Chữa
SELECT MaNV
FROM chungnhan c
         INNER JOIN maybay m on c.MaMB = m.MaMB
WHERE m.Loai LIKE 'Boeing%'
GROUP BY MaNV
HAVING COUNT(m.Loai) = (SELECT COUNT(Loai) FROM maybay
                        WHERE Loai LIKE 'Boeing%');

#
Các cách optimize 1 query
- indexing : chỉ mục của các đầu mục
    => tức là nó sẽ chuyển 1 hoặc nhiều column sang 1 table mới
    => Các đặc điểm khi đánh index
        - Table index nó sẽ được sắp xếp
        - Nó tìm kiếm nhanh hơn với các điều kiện của cái row được đánh index
    => dùng index giúp tăng performance
- join table :
    => Nested loop join : 0(n*m) , n: không gian mảng 1, m: không gian mảng 2
        --> bản thân nó là vòng for 2 lần
        --> duyệt qua từng phần tử của mảng thứ 1, rồi mảng thứ 2, rồi so sánh với nhau
        --> Càng loop nhiều thì độ phức tạp càng cao
    => hash join
        --> hash table : 0(1)
- partition :
    => table lớn chia nó thành sub-table nhỏ hơn theo 1 điều kiện nào đó
    => giảm thời gian tìm kiếm trên 1 table lớn

=> Tổ chức dữ liệu theo một cái cấu trúc dữ liệu

#

    */

}
