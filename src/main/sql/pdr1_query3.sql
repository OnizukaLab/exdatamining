-- クエリ３
-ー- 少数の条件からカタログの多くの部分を持って来るようなクエリ
-- S17A 2h2m48s - 結果サイズオーバーでエラーになっている

SELECT 
  pm.object_id,pm.ra,pm.dec,pm.gcmodel_mag,pm.rcmodel_mag,pm.icmodel_mag,pm.zcmodel_mag,pm.ycmodel_mag,pm.gcmodel_mag_err,pm.rcmodel_mag_err,pm.icmodel_mag_err,pm.zcmodel_mag_err,pm.ycmodel_mag_err
,zp.photoz_mean,zp.photoz_median,zp.photoz_best,zp.photoz_err68_min,zp.photoz_err68_max,zp.photoz_std_mean,zp.photoz_std_median,zp.photoz_std_best,zp.photoz_mode

FROM pdr1_wide.photoz_demp as zp, pdr1_wide.forced as pm 

WHERE pm.object_id = zp.object_id
  AND zp.photoz_best is not null
;

-- PDR1にあわせてカラム名を修正
