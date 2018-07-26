INSERT INTO sys_user (id, username, password) values (1, 'wyf', '$2a$10$auAZ.0p.NWeUcAfMJBp.2.qS0U5Ox0Ur9KEewzaFn/7..dWIZD62a');
INSERT INTO sys_user (id, username, password) values (2, 'wisely', '$2a$10$pV7iYNQZQQv.NW.rlLpas.5C0Je4jDRhIxe74ZP39kiG.oW/gX4I2');

INSERT INTO sys_role (id, name) values (1, 'ROLE_ADMIN');
INSERT INTO sys_role (id, name) values (2, 'ROLE_USER');

INSERT INTO sys_user_roles(SYS_USER_ID, ROLES_ID) values (1, 1);
INSERT INTO sys_user_roles(SYS_USER_ID, ROLES_ID) values (2, 2);