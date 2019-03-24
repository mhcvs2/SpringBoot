create table dts_dispatcher_tenant_ref
(
  id              bigint auto_increment
    primary key,
  tenant_id       varchar(32) not null,
  dispatcher_node varchar(32) not null,
  create_time     datetime    null
);