-- 코드를 입력하세요
SELECT MCDP_CD AS "진료과코드", COUNT(*) AS "5월예약건수"
FROM APPOINTMENT
-- 성능에 좋지 않는 조건절
--WHERE TO_CHAR(APNT_YMD,'YYYY-MM') = '2022-05'
-- 좌변 가공하지 않는 조건절
WHERE APNT_YMD BETWEEN TO_DATE('2022-05-01','YYYY-MM-DD')
                AND TO_DATE('2022-05-31','YYYY-MM-DD')
GROUP BY MCDP_CD
ORDER BY "5월예약건수" ASC, "진료과코드" ASC;