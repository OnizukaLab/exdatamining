--- クエリ１
--- 天体の明るさや色の条件、および空の領域の範囲の条件を
--- 組み合わせて興味ある天体を選択する典型的なクエリ。
--- S17A 12:00:06 検索時間が12時間を超えてタイムアウト

SELECT
    main.object_id, main.ra, main.dec, main.tract, main.patch,

--- =========================
--- ### Forced photometry ###
--- =========================
--- ##### Kron (mag) #####
    main.gmag_kron, main.rmag_kron, main.imag_kron, main.zmag_kron, main.ymag_kron,
    main.gmag_kron_err, main.rmag_kron_err, main.imag_kron_err, main.zmag_kron_err, main.ymag_kron_err,

--- ##### Kron (flux) #####
    main.gflux_kron, main.rflux_kron, main.iflux_kron, main.zflux_kron, main.yflux_kron,
    main.gflux_kron_err, main.rflux_kron_err, main.iflux_kron_err, main.zflux_kron_err, main.yflux_kron_err,

--- ##### Kron (radius) #####
    main.gflux_kron_radius, main.rflux_kron_radius, main.iflux_kron_radius, main.zflux_kron_radius, main.yflux_kron_radius,

--- ##### Cmodel (mag) #####
    main.gcmodel_mag, main.rcmodel_mag, main.icmodel_mag, main.zcmodel_mag, main.ycmodel_mag,
    main.gcmodel_mag_err, main.rcmodel_mag_err, main.icmodel_mag_err, main.zcmodel_mag_err, main.ycmodel_mag_err,

--- ##### Cmodel (mag) #####
    main.gcmodel_flux, main.rcmodel_flux, main.icmodel_flux, main.zcmodel_flux, main.ycmodel_flux,
    main.gcmodel_flux_err, main.rcmodel_flux_err, main.icmodel_flux_err, main.zcmodel_flux_err, main.ycmodel_flux_err,

--- ##### Cmodel (mag) #####
    main.gmag_psf, main.rmag_psf, main.imag_psf, main.zmag_psf, main.ymag_psf,
    main.gmag_psf_err, main.rmag_psf_err, main.imag_psf_err, main.zmag_psf_err, main.ymag_psf_err,

--- ##### Cmodel (mag) #####
    main.gflux_psf, main.rflux_psf, main.iflux_psf, main.zflux_psf, main.yflux_psf,
    main.gflux_psf_err, main.rflux_psf_err, main.iflux_psf_err, main.zflux_psf_err, main.yflux_psf_err,

--- =========================
--- ### nomal  parameters ###
--- =========================
--- ##### Galactic extinction #####
    main.a_g, main.a_r, main.a_i, main.a_z, main.a_y,

--- ##### merge peak flag #####
    main.merge_peak_g, main.merge_peak_r, main.merge_peak_i, main.merge_peak_z, main.merge_peak_y, 

--- ##### bright_object flag #####
    main.gflags_pixel_bright_object_center, main.rflags_pixel_bright_object_center, main.iflags_pixel_bright_object_center, 
    main.zflags_pixel_bright_object_center, main.yflags_pixel_bright_object_center,

    main.gflags_pixel_bright_object_any, main.rflags_pixel_bright_object_any, main.iflags_pixel_bright_object_any, 
    main.zflags_pixel_bright_object_any, main.yflags_pixel_bright_object_any,

--- ##### blendedness parameter #####
    meas.gblendedness_abs_flux, meas.rblendedness_abs_flux, meas.iblendedness_abs_flux, meas.zblendedness_abs_flux, meas.yblendedness_abs_flux,

--- ##### countinputs #####
    meas.gcountinputs, meas.rcountinputs, meas.icountinputs, meas.zcountinputs, meas.ycountinputs,

--- ##### Galaxy/star classification #####
    main.gclassification_extendedness, main.rclassification_extendedness, main.iclassification_extendedness, 
    main.zclassification_extendedness, main.yclassification_extendedness,

--- ##### flags for deblending #####
    main.parent_id,
    main.deblend_nchild,

--- ##### detect_is_primary #####
    main.detect_is_primary,

--- ##### merge_flootprint flags #####
    main.merge_footprint_g, main.merge_footprint_r, main.merge_footprint_i, main.merge_footprint_z, main.merge_footprint_y,

--- ##### other flags (see also Ono+2017) #####
    main.gcmodel_flux_flags, main.rcmodel_flux_flags, main.icmodel_flux_flags, main.zcmodel_flux_flags, main.ycmodel_flux_flags

FROM
    pdr1_wide.forced AS main
    LEFT JOIN pdr1_wide.meas AS meas ON main.object_id = meas.object_id

WHERE
    main.tract IN (10054,10055,10056,9569,9570,9571,9572,9812,9813,9814,8766,8765,8524,8523,10056,10055,10054,9814,9813,9812,9571,9570,9572,9571,9570,9569,9708,9707,9706,9705,9465,9464,9463,9462,9221,9220,9219,17407,17406,17272,17271,17270,17131,17130,17129,16985,16984,8767,8766,8765,8525,8524,8523,8284,8283,8282)

    AND main.gcmodel_mag > 0.0 AND main.rcmodel_mag > 0.0 AND main.icmodel_mag > 0.0 AND main.zcmodel_mag > 0.0
    AND main.gcmodel_mag < 26.5 AND main.rcmodel_mag < 26.0 AND main.icmodel_mag < 25.8 AND main.zcmodel_mag < 25.2
    AND main.gcmodel_mag_err < 0.2
    AND main.rcmodel_mag_err < 0.2
    AND main.icmodel_mag_err < 0.2
    AND main.zcmodel_mag_err < 0.2
    AND (main.rcmodel_mag-main.a_r)-(main.icmodel_mag-main.a_i)<-0.3
    AND ((main.gcmodel_mag-main.a_g)-(main.rcmodel_mag-main.a_r)) < -0.3125*((main.rcmodel_mag-main.a_r)-(main.icmodel_mag-main.a_i))+0.1375

    /* tract_inner and patch_inner */
    AND main.detect_is_patch_inner = 't' AND main.detect_is_tract_inner = 't'

--- ===== Flags =====

    /* flags_pixel_edge */
    AND (
    main.gflags_pixel_edge = 'f' 
    AND main.rflags_pixel_edge = 'f' 
    AND main.iflags_pixel_edge = 'f' 
    AND main.zflags_pixel_edge = 'f' 
--- AND main.yflags_pixel_edge = 'f'
    )

    /* flags_pixel_interpolated_center */
    AND (
    main.gflags_pixel_interpolated_center = 'f' 
    AND main.rflags_pixel_interpolated_center = 'f' 
    AND main.iflags_pixel_interpolated_center = 'f' 
    AND main.zflags_pixel_interpolated_center = 'f' 
--- AND main.yflags_pixel_interpolated_center = 'f'
    )

    /* flags_pixel_saturated_center */
    AND ( 
    main.gflags_pixel_saturated_center = 'f' 
    AND main.rflags_pixel_saturated_center = 'f' 
    AND main.iflags_pixel_saturated_center = 'f' 
    AND main.zflags_pixel_saturated_center = 'f' 
--- AND main.yflags_pixel_saturated_center = 'f'
    )

    /* flags_pixel_cr_center */
    AND (
    main.gflags_pixel_cr_center = 'f' 
    AND main.rflags_pixel_cr_center = 'f' 
    AND main.iflags_pixel_cr_center = 'f' 
    AND main.zflags_pixel_cr_center = 'f' 
--- AND main.yflags_pixel_cr_center = 'f'
    )

    /* flags_pixel_bad */ 
    AND (
    main.gflags_pixel_bad = 'f' 
    AND main.rflags_pixel_bad = 'f' 
    AND main.iflags_pixel_bad = 'f' 
    AND main.zflags_pixel_bad = 'f' 
--- AND main.yflags_pixel_bad = 'f'
    )

    /* deblend_nchild */
    AND (
    main.deblend_nchild = 0
    AND main.detect_is_primary = 't'
    )

--- AND (
--- main.gflags_pixel_bright_object_center = 'f'
--- AND main.rflags_pixel_bright_object_center = 'f'
--- AND main.iflags_pixel_bright_object_center = 'f'
--- AND main.zflags_pixel_bright_object_center = 'f'
--- AND main.yflags_pixel_bright_object_center = 'f'
--- )

    /* pixel_bright_object_any */
--- AND (
--- main.gflags_pixel_bright_object_center = 'f'
--- AND main.rflags_pixel_bright_object_center = 'f'
--- AND main.iflags_pixel_bright_object_center = 'f'
--- AND main.zflags_pixel_bright_object_center = 'f'
--- AND main.yflags_pixel_bright_object_center = 'f'
--- )

    /* centroid_sdss_flags */
--- AND (
--- meas2.gsdsscentroid_flag = 'f'
--- AND meas2.rsdsscentroid_flag = 'f'
--- AND meas2.isdsscentroid_flag = 'f'
--- AND meas2.zsdsscentroid_flag = 'f'
--- AND meas2.ysdsscentroid_flag = 'f'
--- )

    /* cmodel_flux_flags */
    AND (
    main.gcmodel_flux_flags = 'f'
    AND main.rcmodel_flux_flags = 'f'
    AND main.icmodel_flux_flags = 'f'
    AND main.zcmodel_flux_flags = 'f'
--- AND main.ycmodel_flux_flags = 'f'
    )


    /* merge_peak */
    AND (
    main.merge_peak_g = 't'
    AND main.merge_peak_r = 't'
    AND main.merge_peak_i = 't'
    AND main.merge_peak_z = 't'
--- AND main.merge_peak_y = 't'
    )

    /* blendedness_abs_flux */
    AND (
    meas.gblendedness_abs_flux < 0.5
    AND meas.rblendedness_abs_flux < 0.5
    AND meas.iblendedness_abs_flux < 0.5
    AND meas.zblendedness_abs_flux < 0.5
--- AND meas.yblendedness_abs_flux < 0.5
    )
;

-- PDR1に合わせたカラム名の変更
-- dudは存在しないので代わりにwideまたはdeepまたはudeepとする
