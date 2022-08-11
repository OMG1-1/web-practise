create database if not exists practice_b_web;
use practice_b_web;
create table if not exists emp
(
    id        int auto_increment comment 'ID' primary key,
    name      varchar(50) not null comment '姓名',
    age       int         null comment '年龄',
    job       varchar(20) null comment '职位',
    salary    int         null comment '薪资',
    entrydate date        null comment '入职时间',
    manage_id int         null comment '直属领导ID',
    dept_id   int         null comment '部门id'
) comment '员工表';

INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('彭于晏', 19, '总裁', 200000, '2021-06-16', 0, 5);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('马费覅', 24, '架构', 100000, '2021-06-17', 1, 1);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('李四', 18, '测试', 130000, '2021-06-17', 4, 1);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('马在天', 20, '开发', 60000, '2021-10-23', 2, 1);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('赵子龙', 21, '运维', 120000, '2021-07-01', 2, 1);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('小白脸001', 51, '保安', 3000, '2021-06-20', 1, 6);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('小黑脸001', 52, '保洁', 3000, '2021-06-20', 1, 7);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('白脸002', 50, '保安', 2500, '2021-06-22', 6, 6);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('黑脸002', 50, '保洁', 2500, '2021-06-22', 5, 7);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('销售精英001', 31, '产品销售', 30000, '2021-06-16', 1, 4);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('市场英雄007', 38, '活动策划', 30000, '2021-10-08', 1, 2);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('百邢建', 29, '会计', 30000, '2021-07-01', 1, 3);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('程橙', 22, '初级开发', 10000, '2022-06-20', 4, 1);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('谢霆锋', 33, '审计', 30000, '2021-07-30', 12, 3);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('张勇', 22, '初级开发', 10000, '2022-05-10', 4, 1);
INSERT INTO practice_b_web.emp (name, age, job, salary, entrydate, manage_id, dept_id)
VALUES ('张亮', 22, '会计', 30000, '2021-07-01', 1, 3);