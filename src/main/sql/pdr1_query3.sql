-- $B%/%(%j#3(B
-$B!<(B- $B>/?t$N>r7o$+$i%+%?%m%0$NB?$/$NItJ,$r;}$C$FMh$k$h$&$J%/%(%j(B
-- S17A 2h2m48s - $B7k2L%5%$%:%*!<%P!<$G%(%i!<$K$J$C$F$$$k(B

SELECT 
  pm.object_id,pm.ra,pm.dec,pm.gcmodel_mag,pm.rcmodel_mag,pm.icmodel_mag,pm.zcmodel_mag,pm.ycmodel_mag,pm.gcmodel_mag_err,pm.rcmodel_mag_err,pm.icmodel_mag_err,pm.zcmodel_mag_err,pm.ycmodel_mag_err
,zp.photoz_mean,zp.photoz_median,zp.photoz_best,zp.photoz_err68_min,zp.photoz_err68_max,zp.photoz_std_mean,zp.photoz_std_median,zp.photoz_std_best,zp.photoz_mode

FROM pdr1_wide.photoz_demp as zp, pdr1_wide.forced as pm 

WHERE pm.object_id = zp.object_id
  AND zp.photoz_best is not null
;

-- PDR1$B$K$"$o$;$F%+%i%`L>$r=$@5(B
