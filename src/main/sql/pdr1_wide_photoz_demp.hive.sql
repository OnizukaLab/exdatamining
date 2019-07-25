use pdr1_hive;
drop table if exists pdr1_wide_photoz_demp;
create EXTERNAL TABLE pdr1_wide_photoz_demp(
object_id bigint
,photoz_mean float
,photoz_mode float
,photoz_median float
,photoz_best float
,photoz_mc float
,photoz_conf_mean float
,photoz_conf_mode float
,photoz_conf_median float
,photoz_conf_best float
,photoz_risk_mean float
,photoz_risk_mode float
,photoz_risk_median float
,photoz_risk_best float
,photoz_std_mean float
,photoz_std_mode float
,photoz_std_median float
,photoz_std_best float
,photoz_err68_min float
,photoz_err68_max float
,photoz_err95_min float
,photoz_err95_max float
) ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
 WITH SERDEPROPERTIES (
 'separatorChar' = ',',
 'quoteChar' = '"',
 'escapeChar' = '\\')
 STORED AS TEXTFILE
 LOCATION '/user/suga/pdr1_hive/pdr1_wide_photoz_demp/';
