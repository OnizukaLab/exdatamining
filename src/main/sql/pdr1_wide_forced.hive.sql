use pdr1_hive;

drop table if exists pdr1_wide_forced;

create EXTERNAL TABLE pdr1_wide_forced(
object_id bigint
,ra double
,dec double
,coord string
,skymap_id int
,tract int
,patch int
,patch_s string
,parent_id bigint
,deblend_nchild int
,a_g float
,a_r float
,a_i float
,a_z float
,a_y float
,detect_is_primary boolean
,merge_footprint_i2 boolean
,merge_footprint_i boolean
,merge_footprint_r boolean
,merge_footprint_z boolean
,merge_footprint_y boolean
,merge_footprint_g boolean
,merge_footprint_n921 boolean
,merge_footprint_n816 boolean
,merge_footprint_n1010 boolean
,merge_footprint_n387 boolean
,merge_footprint_n515 boolean
,merge_footprint_sky boolean
,merge_peak_i2 boolean
,merge_peak_i boolean
,merge_peak_r boolean
,merge_peak_z boolean
,merge_peak_y boolean
,merge_peak_g boolean
,merge_peak_n921 boolean
,merge_peak_n816 boolean
,merge_peak_n1010 boolean
,merge_peak_n387 boolean
,merge_peak_n515 boolean
,merge_peak_sky boolean
,detect_is_patch_inner boolean
,detect_is_tract_inner boolean
,merge_measurement_i2 boolean
,merge_measurement_i boolean
,merge_measurement_r boolean
,merge_measurement_z boolean
,merge_measurement_y boolean
,merge_measurement_g boolean
,merge_measurement_n921 boolean
,merge_measurement_n816 boolean
,merge_measurement_n1010 boolean
,merge_measurement_n387 boolean
,merge_measurement_n515 boolean
,gflux_naive double
,gmag_naive float
,gflux_naive_err double
,gmag_naive_err float
,gflux_naive_flags boolean
,gflux_sinc double
,gmag_sinc float
,gflux_sinc_err double
,gmag_sinc_err float
,gflux_sinc_flags boolean
,gflux_psf double
,gmag_psf float
,gflux_psf_err double
,gmag_psf_err float
,gflux_psf_apcorr float
,gflux_psf_apcorr_err float
,gflux_psf_flags boolean
,gflux_psf_flags_apcorr boolean
,gflux_kron double
,gmag_kron float
,gflux_kron_err double
,gmag_kron_err float
,gflux_kron_radius float
,gflux_kron_radiusforradius float
,gflux_kron_psfradius float
,gflux_kron_apcorr float
,gflux_kron_apcorr_err float
,gflux_kron_flags boolean
,gflux_kron_flags_edge boolean
,gflux_kron_flags_radius boolean
,gflux_kron_flags_smallradius boolean
,gflux_kron_flags_usedminimumradius boolean
,gflux_kron_flags_usedpsfradius boolean
,gflux_kron_flags_badshape boolean
,gflux_kron_flags_apcorr boolean
,gflux_aperture10 double
,gmag_aperture10 float
,gflux_aperture15 double
,gmag_aperture15 float
,gflux_aperture20 double
,gmag_aperture20 float
,gflux_aperture30 double
,gmag_aperture30 float
,gflux_aperture40 double
,gmag_aperture40 float
,gflux_aperture57 double
,gmag_aperture57 float
,gflux_aperture84 double
,gmag_aperture84 float
,gflux_aperture118 double
,gmag_aperture118 float
,gflux_aperture168 double
,gmag_aperture168 float
,gflux_aperture235 double
,gmag_aperture235 float
,gflux_aperture10_err double
,gmag_aperture10_err float
,gflux_aperture15_err double
,gmag_aperture15_err float
,gflux_aperture20_err double
,gmag_aperture20_err float
,gflux_aperture30_err double
,gmag_aperture30_err float
,gflux_aperture40_err double
,gmag_aperture40_err float
,gflux_aperture57_err double
,gmag_aperture57_err float
,gflux_aperture84_err double
,gmag_aperture84_err float
,gflux_aperture118_err double
,gmag_aperture118_err float
,gflux_aperture168_err double
,gmag_aperture168_err float
,gflux_aperture235_err double
,gmag_aperture235_err float
,gflux_aperture10_ninterpolatedpixel smallint
,gflux_aperture15_ninterpolatedpixel smallint
,gflux_aperture20_ninterpolatedpixel smallint
,gflux_aperture30_ninterpolatedpixel smallint
,gflux_aperture40_ninterpolatedpixel smallint
,gflux_aperture57_ninterpolatedpixel smallint
,gflux_aperture84_ninterpolatedpixel smallint
,gflux_aperture118_ninterpolatedpixel smallint
,gflux_aperture168_ninterpolatedpixel smallint
,gflux_aperture235_ninterpolatedpixel smallint
,gflux_aperture_nprofile smallint
,gflux_aperture_flags boolean
,gcentroid_naive_ra double
,gcentroid_naive_dec double
,gcentroid_naive_flags boolean
,gcentroid_sdss_ra double
,gcentroid_sdss_dec double
,gcentroid_sdss_err_11 float
,gcentroid_sdss_err_22 float
,gcentroid_sdss_flags boolean
,gmultishapelet_psf_inner0 float
,gmultishapelet_psf_inner1 float
,gmultishapelet_psf_inner2 float
,gmultishapelet_psf_inner3 float
,gmultishapelet_psf_inner4 float
,gmultishapelet_psf_inner5 float
,gmultishapelet_psf_outer0 float
,gmultishapelet_psf_outer1 float
,gmultishapelet_psf_outer2 float
,gmultishapelet_psf_ellipse_11 float
,gmultishapelet_psf_ellipse_22 float
,gmultishapelet_psf_ellipse_12 float
,gmultishapelet_psf_chisq float
,gmultishapelet_psf_integral float
,gmultishapelet_psf_flags boolean
,gmultishapelet_psf_flags_maxiter boolean
,gmultishapelet_psf_flags_tinystep boolean
,gmultishapelet_psf_flags_constraint_r boolean
,gmultishapelet_psf_flags_constraint_q boolean
,gshape_sdss_11 float
,gshape_sdss_22 float
,gshape_sdss_12 float
,gshape_sdss_err_11_11 float
,gshape_sdss_err_22_22 float
,gshape_sdss_err_12_12 float
,gshape_sdss_centroid_ra double
,gshape_sdss_centroid_dec double
,gshape_sdss_psf_11 float
,gshape_sdss_psf_22 float
,gshape_sdss_psf_12 float
,gshape_sdss_flags boolean
,gshape_sdss_centroid_flags boolean
,gshape_sdss_flags_unweightedbad boolean
,gshape_sdss_flags_unweighted boolean
,gshape_sdss_flags_shift boolean
,gshape_sdss_flags_maxiter boolean
,gshape_sdss_flags_psf boolean
,gcmodel_initial_flux double
,gcmodel_initial_mag float
,gcmodel_initial_flux_err double
,gcmodel_initial_mag_err float
,gcmodel_initial_flux_inner double
,gcmodel_initial_mag_inner float
,gcmodel_exp_flux double
,gcmodel_exp_mag float
,gcmodel_exp_flux_err double
,gcmodel_exp_mag_err float
,gcmodel_exp_flux_inner double
,gcmodel_exp_mag_inner float
,gcmodel_dev_flux double
,gcmodel_dev_mag float
,gcmodel_dev_flux_err double
,gcmodel_dev_mag_err float
,gcmodel_dev_flux_inner double
,gcmodel_dev_mag_inner float
,gcmodel_center_ra double
,gcmodel_center_dec double
,gcmodel_flux double
,gcmodel_mag float
,gcmodel_flux_err double
,gcmodel_mag_err float
,gcmodel_flux_inner double
,gcmodel_mag_inner float
,gcmodel_fracdev float
,gcmodel_objective float
,gcmodel_dev_flux_apcorr float
,gcmodel_dev_flux_apcorr_err float
,gcmodel_exp_flux_apcorr float
,gcmodel_exp_flux_apcorr_err float
,gcmodel_flux_apcorr float
,gcmodel_flux_apcorr_err float
,gcmodel_initial_flux_flags boolean
,gcmodel_initial_flags_badreference boolean
,gcmodel_initial_flags_numericerror boolean
,gcmodel_exp_flux_flags boolean
,gcmodel_exp_flags_badreference boolean
,gcmodel_exp_flags_numericerror boolean
,gcmodel_dev_flux_flags boolean
,gcmodel_dev_flags_badreference boolean
,gcmodel_dev_flags_numericerror boolean
,gcmodel_flux_flags boolean
,gcmodel_flags_region_maxarea boolean
,gcmodel_flags_region_maxbadpixelfraction boolean
,gcmodel_flags_badreference boolean
,gcmodel_flags_nopsf boolean
,gcmodel_flags_nowcs boolean
,gcmodel_flags_nocalib boolean
,gcmodel_flags_badcentroid boolean
,gcmodel_dev_flux_flags_apcorr boolean
,gcmodel_exp_flux_flags_apcorr boolean
,gcmodel_flux_flags_apcorr boolean
,gcountinputs smallint
,gvariance float
,gclassification_extendedness float
,gflags_pixel_edge boolean
,gflags_pixel_interpolated_any boolean
,gflags_pixel_interpolated_center boolean
,gflags_pixel_saturated_any boolean
,gflags_pixel_saturated_center boolean
,gflags_pixel_cr_any boolean
,gflags_pixel_cr_center boolean
,gflags_pixel_bad boolean
,gflags_pixel_suspect_any boolean
,gflags_pixel_suspect_center boolean
,gflags_pixel_offimage boolean
,gflags_pixel_bright_object_center boolean
,gflags_pixel_clipped_any boolean
,gflags_pixel_bright_object_any boolean
,rflux_naive double
,rmag_naive float
,rflux_naive_err double
,rmag_naive_err float
,rflux_naive_flags boolean
,rflux_sinc double
,rmag_sinc float
,rflux_sinc_err double
,rmag_sinc_err float
,rflux_sinc_flags boolean
,rflux_psf double
,rmag_psf float
,rflux_psf_err double
,rmag_psf_err float
,rflux_psf_apcorr float
,rflux_psf_apcorr_err float
,rflux_psf_flags boolean
,rflux_psf_flags_apcorr boolean
,rflux_kron double
,rmag_kron float
,rflux_kron_err double
,rmag_kron_err float
,rflux_kron_radius float
,rflux_kron_radiusforradius float
,rflux_kron_psfradius float
,rflux_kron_apcorr float
,rflux_kron_apcorr_err float
,rflux_kron_flags boolean
,rflux_kron_flags_edge boolean
,rflux_kron_flags_radius boolean
,rflux_kron_flags_smallradius boolean
,rflux_kron_flags_usedminimumradius boolean
,rflux_kron_flags_usedpsfradius boolean
,rflux_kron_flags_badshape boolean
,rflux_kron_flags_apcorr boolean
,rflux_aperture10 double
,rmag_aperture10 float
,rflux_aperture15 double
,rmag_aperture15 float
,rflux_aperture20 double
,rmag_aperture20 float
,rflux_aperture30 double
,rmag_aperture30 float
,rflux_aperture40 double
,rmag_aperture40 float
,rflux_aperture57 double
,rmag_aperture57 float
,rflux_aperture84 double
,rmag_aperture84 float
,rflux_aperture118 double
,rmag_aperture118 float
,rflux_aperture168 double
,rmag_aperture168 float
,rflux_aperture235 double
,rmag_aperture235 float
,rflux_aperture10_err double
,rmag_aperture10_err float
,rflux_aperture15_err double
,rmag_aperture15_err float
,rflux_aperture20_err double
,rmag_aperture20_err float
,rflux_aperture30_err double
,rmag_aperture30_err float
,rflux_aperture40_err double
,rmag_aperture40_err float
,rflux_aperture57_err double
,rmag_aperture57_err float
,rflux_aperture84_err double
,rmag_aperture84_err float
,rflux_aperture118_err double
,rmag_aperture118_err float
,rflux_aperture168_err double
,rmag_aperture168_err float
,rflux_aperture235_err double
,rmag_aperture235_err float
,rflux_aperture10_ninterpolatedpixel smallint
,rflux_aperture15_ninterpolatedpixel smallint
,rflux_aperture20_ninterpolatedpixel smallint
,rflux_aperture30_ninterpolatedpixel smallint
,rflux_aperture40_ninterpolatedpixel smallint
,rflux_aperture57_ninterpolatedpixel smallint
,rflux_aperture84_ninterpolatedpixel smallint
,rflux_aperture118_ninterpolatedpixel smallint
,rflux_aperture168_ninterpolatedpixel smallint
,rflux_aperture235_ninterpolatedpixel smallint
,rflux_aperture_nprofile smallint
,rflux_aperture_flags boolean
,rcentroid_naive_ra double
,rcentroid_naive_dec double
,rcentroid_naive_flags boolean
,rcentroid_sdss_ra double
,rcentroid_sdss_dec double
,rcentroid_sdss_err_11 float
,rcentroid_sdss_err_22 float
,rcentroid_sdss_flags boolean
,rmultishapelet_psf_inner0 float
,rmultishapelet_psf_inner1 float
,rmultishapelet_psf_inner2 float
,rmultishapelet_psf_inner3 float
,rmultishapelet_psf_inner4 float
,rmultishapelet_psf_inner5 float
,rmultishapelet_psf_outer0 float
,rmultishapelet_psf_outer1 float
,rmultishapelet_psf_outer2 float
,rmultishapelet_psf_ellipse_11 float
,rmultishapelet_psf_ellipse_22 float
,rmultishapelet_psf_ellipse_12 float
,rmultishapelet_psf_chisq float
,rmultishapelet_psf_integral float
,rmultishapelet_psf_flags boolean
,rmultishapelet_psf_flags_maxiter boolean
,rmultishapelet_psf_flags_tinystep boolean
,rmultishapelet_psf_flags_constraint_r boolean
,rmultishapelet_psf_flags_constraint_q boolean
,rshape_sdss_11 float
,rshape_sdss_22 float
,rshape_sdss_12 float
,rshape_sdss_err_11_11 float
,rshape_sdss_err_22_22 float
,rshape_sdss_err_12_12 float
,rshape_sdss_centroid_ra double
,rshape_sdss_centroid_dec double
,rshape_sdss_psf_11 float
,rshape_sdss_psf_22 float
,rshape_sdss_psf_12 float
,rshape_sdss_flags boolean
,rshape_sdss_centroid_flags boolean
,rshape_sdss_flags_unweightedbad boolean
,rshape_sdss_flags_unweighted boolean
,rshape_sdss_flags_shift boolean
,rshape_sdss_flags_maxiter boolean
,rshape_sdss_flags_psf boolean
,rcmodel_initial_flux double
,rcmodel_initial_mag float
,rcmodel_initial_flux_err double
,rcmodel_initial_mag_err float
,rcmodel_initial_flux_inner double
,rcmodel_initial_mag_inner float
,rcmodel_exp_flux double
,rcmodel_exp_mag float
,rcmodel_exp_flux_err double
,rcmodel_exp_mag_err float
,rcmodel_exp_flux_inner double
,rcmodel_exp_mag_inner float
,rcmodel_dev_flux double
,rcmodel_dev_mag float
,rcmodel_dev_flux_err double
,rcmodel_dev_mag_err float
,rcmodel_dev_flux_inner double
,rcmodel_dev_mag_inner float
,rcmodel_center_ra double
,rcmodel_center_dec double
,rcmodel_flux double
,rcmodel_mag float
,rcmodel_flux_err double
,rcmodel_mag_err float
,rcmodel_flux_inner double
,rcmodel_mag_inner float
,rcmodel_fracdev float
,rcmodel_objective float
,rcmodel_dev_flux_apcorr float
,rcmodel_dev_flux_apcorr_err float
,rcmodel_exp_flux_apcorr float
,rcmodel_exp_flux_apcorr_err float
,rcmodel_flux_apcorr float
,rcmodel_flux_apcorr_err float
,rcmodel_initial_flux_flags boolean
,rcmodel_initial_flags_badreference boolean
,rcmodel_initial_flags_numericerror boolean
,rcmodel_exp_flux_flags boolean
,rcmodel_exp_flags_badreference boolean
,rcmodel_exp_flags_numericerror boolean
,rcmodel_dev_flux_flags boolean
,rcmodel_dev_flags_badreference boolean
,rcmodel_dev_flags_numericerror boolean
,rcmodel_flux_flags boolean
,rcmodel_flags_region_maxarea boolean
,rcmodel_flags_region_maxbadpixelfraction boolean
,rcmodel_flags_badreference boolean
,rcmodel_flags_nopsf boolean
,rcmodel_flags_nowcs boolean
,rcmodel_flags_nocalib boolean
,rcmodel_flags_badcentroid boolean
,rcmodel_dev_flux_flags_apcorr boolean
,rcmodel_exp_flux_flags_apcorr boolean
,rcmodel_flux_flags_apcorr boolean
,rcountinputs smallint
,rvariance float
,rclassification_extendedness float
,rflags_pixel_edge boolean
,rflags_pixel_interpolated_any boolean
,rflags_pixel_interpolated_center boolean
,rflags_pixel_saturated_any boolean
,rflags_pixel_saturated_center boolean
,rflags_pixel_cr_any boolean
,rflags_pixel_cr_center boolean
,rflags_pixel_bad boolean
,rflags_pixel_suspect_any boolean
,rflags_pixel_suspect_center boolean
,rflags_pixel_offimage boolean
,rflags_pixel_bright_object_center boolean
,rflags_pixel_clipped_any boolean
,rflags_pixel_bright_object_any boolean
,iflux_naive double
,imag_naive float
,iflux_naive_err double
,imag_naive_err float
,iflux_naive_flags boolean
,iflux_sinc double
,imag_sinc float
,iflux_sinc_err double
,imag_sinc_err float
,iflux_sinc_flags boolean
,iflux_psf double
,imag_psf float
,iflux_psf_err double
,imag_psf_err float
,iflux_psf_apcorr float
,iflux_psf_apcorr_err float
,iflux_psf_flags boolean
,iflux_psf_flags_apcorr boolean
,iflux_kron double
,imag_kron float
,iflux_kron_err double
,imag_kron_err float
,iflux_kron_radius float
,iflux_kron_radiusforradius float
,iflux_kron_psfradius float
,iflux_kron_apcorr float
,iflux_kron_apcorr_err float
,iflux_kron_flags boolean
,iflux_kron_flags_edge boolean
,iflux_kron_flags_radius boolean
,iflux_kron_flags_smallradius boolean
,iflux_kron_flags_usedminimumradius boolean
,iflux_kron_flags_usedpsfradius boolean
,iflux_kron_flags_badshape boolean
,iflux_kron_flags_apcorr boolean
,iflux_aperture10 double
,imag_aperture10 float
,iflux_aperture15 double
,imag_aperture15 float
,iflux_aperture20 double
,imag_aperture20 float
,iflux_aperture30 double
,imag_aperture30 float
,iflux_aperture40 double
,imag_aperture40 float
,iflux_aperture57 double
,imag_aperture57 float
,iflux_aperture84 double
,imag_aperture84 float
,iflux_aperture118 double
,imag_aperture118 float
,iflux_aperture168 double
,imag_aperture168 float
,iflux_aperture235 double
,imag_aperture235 float
,iflux_aperture10_err double
,imag_aperture10_err float
,iflux_aperture15_err double
,imag_aperture15_err float
,iflux_aperture20_err double
,imag_aperture20_err float
,iflux_aperture30_err double
,imag_aperture30_err float
,iflux_aperture40_err double
,imag_aperture40_err float
,iflux_aperture57_err double
,imag_aperture57_err float
,iflux_aperture84_err double
,imag_aperture84_err float
,iflux_aperture118_err double
,imag_aperture118_err float
,iflux_aperture168_err double
,imag_aperture168_err float
,iflux_aperture235_err double
,imag_aperture235_err float
,iflux_aperture10_ninterpolatedpixel smallint
,iflux_aperture15_ninterpolatedpixel smallint
,iflux_aperture20_ninterpolatedpixel smallint
,iflux_aperture30_ninterpolatedpixel smallint
,iflux_aperture40_ninterpolatedpixel smallint
,iflux_aperture57_ninterpolatedpixel smallint
,iflux_aperture84_ninterpolatedpixel smallint
,iflux_aperture118_ninterpolatedpixel smallint
,iflux_aperture168_ninterpolatedpixel smallint
,iflux_aperture235_ninterpolatedpixel smallint
,iflux_aperture_nprofile smallint
,iflux_aperture_flags boolean
,icentroid_naive_ra double
,icentroid_naive_dec double
,icentroid_naive_flags boolean
,icentroid_sdss_ra double
,icentroid_sdss_dec double
,icentroid_sdss_err_11 float
,icentroid_sdss_err_22 float
,icentroid_sdss_flags boolean
,imultishapelet_psf_inner0 float
,imultishapelet_psf_inner1 float
,imultishapelet_psf_inner2 float
,imultishapelet_psf_inner3 float
,imultishapelet_psf_inner4 float
,imultishapelet_psf_inner5 float
,imultishapelet_psf_outer0 float
,imultishapelet_psf_outer1 float
,imultishapelet_psf_outer2 float
,imultishapelet_psf_ellipse_11 float
,imultishapelet_psf_ellipse_22 float
,imultishapelet_psf_ellipse_12 float
,imultishapelet_psf_chisq float
,imultishapelet_psf_integral float
,imultishapelet_psf_flags boolean
,imultishapelet_psf_flags_maxiter boolean
,imultishapelet_psf_flags_tinystep boolean
,imultishapelet_psf_flags_constraint_r boolean
,imultishapelet_psf_flags_constraint_q boolean
,ishape_sdss_11 float
,ishape_sdss_22 float
,ishape_sdss_12 float
,ishape_sdss_err_11_11 float
,ishape_sdss_err_22_22 float
,ishape_sdss_err_12_12 float
,ishape_sdss_centroid_ra double
,ishape_sdss_centroid_dec double
,ishape_sdss_psf_11 float
,ishape_sdss_psf_22 float
,ishape_sdss_psf_12 float
,ishape_sdss_flags boolean
,ishape_sdss_centroid_flags boolean
,ishape_sdss_flags_unweightedbad boolean
,ishape_sdss_flags_unweighted boolean
,ishape_sdss_flags_shift boolean
,ishape_sdss_flags_maxiter boolean
,ishape_sdss_flags_psf boolean
,icmodel_initial_flux double
,icmodel_initial_mag float
,icmodel_initial_flux_err double
,icmodel_initial_mag_err float
,icmodel_initial_flux_inner double
,icmodel_initial_mag_inner float
,icmodel_exp_flux double
,icmodel_exp_mag float
,icmodel_exp_flux_err double
,icmodel_exp_mag_err float
,icmodel_exp_flux_inner double
,icmodel_exp_mag_inner float
,icmodel_dev_flux double
,icmodel_dev_mag float
,icmodel_dev_flux_err double
,icmodel_dev_mag_err float
,icmodel_dev_flux_inner double
,icmodel_dev_mag_inner float
,icmodel_center_ra double
,icmodel_center_dec double
,icmodel_flux double
,icmodel_mag float
,icmodel_flux_err double
,icmodel_mag_err float
,icmodel_flux_inner double
,icmodel_mag_inner float
,icmodel_fracdev float
,icmodel_objective float
,icmodel_dev_flux_apcorr float
,icmodel_dev_flux_apcorr_err float
,icmodel_exp_flux_apcorr float
,icmodel_exp_flux_apcorr_err float
,icmodel_flux_apcorr float
,icmodel_flux_apcorr_err float
,icmodel_initial_flux_flags boolean
,icmodel_initial_flags_badreference boolean
,icmodel_initial_flags_numericerror boolean
,icmodel_exp_flux_flags boolean
,icmodel_exp_flags_badreference boolean
,icmodel_exp_flags_numericerror boolean
,icmodel_dev_flux_flags boolean
,icmodel_dev_flags_badreference boolean
,icmodel_dev_flags_numericerror boolean
,icmodel_flux_flags boolean
,icmodel_flags_region_maxarea boolean
,icmodel_flags_region_maxbadpixelfraction boolean
,icmodel_flags_badreference boolean
,icmodel_flags_nopsf boolean
,icmodel_flags_nowcs boolean
,icmodel_flags_nocalib boolean
,icmodel_flags_badcentroid boolean
,icmodel_dev_flux_flags_apcorr boolean
,icmodel_exp_flux_flags_apcorr boolean
,icmodel_flux_flags_apcorr boolean
,icountinputs smallint
,ivariance float
,iclassification_extendedness float
,iflags_pixel_edge boolean
,iflags_pixel_interpolated_any boolean
,iflags_pixel_interpolated_center boolean
,iflags_pixel_saturated_any boolean
,iflags_pixel_saturated_center boolean
,iflags_pixel_cr_any boolean
,iflags_pixel_cr_center boolean
,iflags_pixel_bad boolean
,iflags_pixel_suspect_any boolean
,iflags_pixel_suspect_center boolean
,iflags_pixel_offimage boolean
,iflags_pixel_bright_object_center boolean
,iflags_pixel_clipped_any boolean
,iflags_pixel_bright_object_any boolean
,zflux_naive double
,zmag_naive float
,zflux_naive_err double
,zmag_naive_err float
,zflux_naive_flags boolean
,zflux_sinc double
,zmag_sinc float
,zflux_sinc_err double
,zmag_sinc_err float
,zflux_sinc_flags boolean
,zflux_psf double
,zmag_psf float
,zflux_psf_err double
,zmag_psf_err float
,zflux_psf_apcorr float
,zflux_psf_apcorr_err float
,zflux_psf_flags boolean
,zflux_psf_flags_apcorr boolean
,zflux_kron double
,zmag_kron float
,zflux_kron_err double
,zmag_kron_err float
,zflux_kron_radius float
,zflux_kron_radiusforradius float
,zflux_kron_psfradius float
,zflux_kron_apcorr float
,zflux_kron_apcorr_err float
,zflux_kron_flags boolean
,zflux_kron_flags_edge boolean
,zflux_kron_flags_radius boolean
,zflux_kron_flags_smallradius boolean
,zflux_kron_flags_usedminimumradius boolean
,zflux_kron_flags_usedpsfradius boolean
,zflux_kron_flags_badshape boolean
,zflux_kron_flags_apcorr boolean
,zflux_aperture10 double
,zmag_aperture10 float
,zflux_aperture15 double
,zmag_aperture15 float
,zflux_aperture20 double
,zmag_aperture20 float
,zflux_aperture30 double
,zmag_aperture30 float
,zflux_aperture40 double
,zmag_aperture40 float
,zflux_aperture57 double
,zmag_aperture57 float
,zflux_aperture84 double
,zmag_aperture84 float
,zflux_aperture118 double
,zmag_aperture118 float
,zflux_aperture168 double
,zmag_aperture168 float
,zflux_aperture235 double
,zmag_aperture235 float
,zflux_aperture10_err double
,zmag_aperture10_err float
,zflux_aperture15_err double
,zmag_aperture15_err float
,zflux_aperture20_err double
,zmag_aperture20_err float
,zflux_aperture30_err double
,zmag_aperture30_err float
,zflux_aperture40_err double
,zmag_aperture40_err float
,zflux_aperture57_err double
,zmag_aperture57_err float
,zflux_aperture84_err double
,zmag_aperture84_err float
,zflux_aperture118_err double
,zmag_aperture118_err float
,zflux_aperture168_err double
,zmag_aperture168_err float
,zflux_aperture235_err double
,zmag_aperture235_err float
,zflux_aperture10_ninterpolatedpixel smallint
,zflux_aperture15_ninterpolatedpixel smallint
,zflux_aperture20_ninterpolatedpixel smallint
,zflux_aperture30_ninterpolatedpixel smallint
,zflux_aperture40_ninterpolatedpixel smallint
,zflux_aperture57_ninterpolatedpixel smallint
,zflux_aperture84_ninterpolatedpixel smallint
,zflux_aperture118_ninterpolatedpixel smallint
,zflux_aperture168_ninterpolatedpixel smallint
,zflux_aperture235_ninterpolatedpixel smallint
,zflux_aperture_nprofile smallint
,zflux_aperture_flags boolean
,zcentroid_naive_ra double
,zcentroid_naive_dec double
,zcentroid_naive_flags boolean
,zcentroid_sdss_ra double
,zcentroid_sdss_dec double
,zcentroid_sdss_err_11 float
,zcentroid_sdss_err_22 float
,zcentroid_sdss_flags boolean
,zmultishapelet_psf_inner0 float
,zmultishapelet_psf_inner1 float
,zmultishapelet_psf_inner2 float
,zmultishapelet_psf_inner3 float
,zmultishapelet_psf_inner4 float
,zmultishapelet_psf_inner5 float
,zmultishapelet_psf_outer0 float
,zmultishapelet_psf_outer1 float
,zmultishapelet_psf_outer2 float
,zmultishapelet_psf_ellipse_11 float
,zmultishapelet_psf_ellipse_22 float
,zmultishapelet_psf_ellipse_12 float
,zmultishapelet_psf_chisq float
,zmultishapelet_psf_integral float
,zmultishapelet_psf_flags boolean
,zmultishapelet_psf_flags_maxiter boolean
,zmultishapelet_psf_flags_tinystep boolean
,zmultishapelet_psf_flags_constraint_r boolean
,zmultishapelet_psf_flags_constraint_q boolean
,zshape_sdss_11 float
,zshape_sdss_22 float
,zshape_sdss_12 float
,zshape_sdss_err_11_11 float
,zshape_sdss_err_22_22 float
,zshape_sdss_err_12_12 float
,zshape_sdss_centroid_ra double
,zshape_sdss_centroid_dec double
,zshape_sdss_psf_11 float
,zshape_sdss_psf_22 float
,zshape_sdss_psf_12 float
,zshape_sdss_flags boolean
,zshape_sdss_centroid_flags boolean
,zshape_sdss_flags_unweightedbad boolean
,zshape_sdss_flags_unweighted boolean
,zshape_sdss_flags_shift boolean
,zshape_sdss_flags_maxiter boolean
,zshape_sdss_flags_psf boolean
,zcmodel_initial_flux double
,zcmodel_initial_mag float
,zcmodel_initial_flux_err double
,zcmodel_initial_mag_err float
,zcmodel_initial_flux_inner double
,zcmodel_initial_mag_inner float
,zcmodel_exp_flux double
,zcmodel_exp_mag float
,zcmodel_exp_flux_err double
,zcmodel_exp_mag_err float
,zcmodel_exp_flux_inner double
,zcmodel_exp_mag_inner float
,zcmodel_dev_flux double
,zcmodel_dev_mag float
,zcmodel_dev_flux_err double
,zcmodel_dev_mag_err float
,zcmodel_dev_flux_inner double
,zcmodel_dev_mag_inner float
,zcmodel_center_ra double
,zcmodel_center_dec double
,zcmodel_flux double
,zcmodel_mag float
,zcmodel_flux_err double
,zcmodel_mag_err float
,zcmodel_flux_inner double
,zcmodel_mag_inner float
,zcmodel_fracdev float
,zcmodel_objective float
,zcmodel_dev_flux_apcorr float
,zcmodel_dev_flux_apcorr_err float
,zcmodel_exp_flux_apcorr float
,zcmodel_exp_flux_apcorr_err float
,zcmodel_flux_apcorr float
,zcmodel_flux_apcorr_err float
,zcmodel_initial_flux_flags boolean
,zcmodel_initial_flags_badreference boolean
,zcmodel_initial_flags_numericerror boolean
,zcmodel_exp_flux_flags boolean
,zcmodel_exp_flags_badreference boolean
,zcmodel_exp_flags_numericerror boolean
,zcmodel_dev_flux_flags boolean
,zcmodel_dev_flags_badreference boolean
,zcmodel_dev_flags_numericerror boolean
,zcmodel_flux_flags boolean
,zcmodel_flags_region_maxarea boolean
,zcmodel_flags_region_maxbadpixelfraction boolean
,zcmodel_flags_badreference boolean
,zcmodel_flags_nopsf boolean
,zcmodel_flags_nowcs boolean
,zcmodel_flags_nocalib boolean
,zcmodel_flags_badcentroid boolean
,zcmodel_dev_flux_flags_apcorr boolean
,zcmodel_exp_flux_flags_apcorr boolean
,zcmodel_flux_flags_apcorr boolean
,zcountinputs smallint
,zvariance float
,zclassification_extendedness float
,zflags_pixel_edge boolean
,zflags_pixel_interpolated_any boolean
,zflags_pixel_interpolated_center boolean
,zflags_pixel_saturated_any boolean
,zflags_pixel_saturated_center boolean
,zflags_pixel_cr_any boolean
,zflags_pixel_cr_center boolean
,zflags_pixel_bad boolean
,zflags_pixel_suspect_any boolean
,zflags_pixel_suspect_center boolean
,zflags_pixel_offimage boolean
,zflags_pixel_bright_object_center boolean
,zflags_pixel_clipped_any boolean
,zflags_pixel_bright_object_any boolean
,yflux_naive double
,ymag_naive float
,yflux_naive_err double
,ymag_naive_err float
,yflux_naive_flags boolean
,yflux_sinc double
,ymag_sinc float
,yflux_sinc_err double
,ymag_sinc_err float
,yflux_sinc_flags boolean
,yflux_psf double
,ymag_psf float
,yflux_psf_err double
,ymag_psf_err float
,yflux_psf_apcorr float
,yflux_psf_apcorr_err float
,yflux_psf_flags boolean
,yflux_psf_flags_apcorr boolean
,yflux_kron double
,ymag_kron float
,yflux_kron_err double
,ymag_kron_err float
,yflux_kron_radius float
,yflux_kron_radiusforradius float
,yflux_kron_psfradius float
,yflux_kron_apcorr float
,yflux_kron_apcorr_err float
,yflux_kron_flags boolean
,yflux_kron_flags_edge boolean
,yflux_kron_flags_radius boolean
,yflux_kron_flags_smallradius boolean
,yflux_kron_flags_usedminimumradius boolean
,yflux_kron_flags_usedpsfradius boolean
,yflux_kron_flags_badshape boolean
,yflux_kron_flags_apcorr boolean
,yflux_aperture10 double
,ymag_aperture10 float
,yflux_aperture15 double
,ymag_aperture15 float
,yflux_aperture20 double
,ymag_aperture20 float
,yflux_aperture30 double
,ymag_aperture30 float
,yflux_aperture40 double
,ymag_aperture40 float
,yflux_aperture57 double
,ymag_aperture57 float
,yflux_aperture84 double
,ymag_aperture84 float
,yflux_aperture118 double
,ymag_aperture118 float
,yflux_aperture168 double
,ymag_aperture168 float
,yflux_aperture235 double
,ymag_aperture235 float
,yflux_aperture10_err double
,ymag_aperture10_err float
,yflux_aperture15_err double
,ymag_aperture15_err float
,yflux_aperture20_err double
,ymag_aperture20_err float
,yflux_aperture30_err double
,ymag_aperture30_err float
,yflux_aperture40_err double
,ymag_aperture40_err float
,yflux_aperture57_err double
,ymag_aperture57_err float
,yflux_aperture84_err double
,ymag_aperture84_err float
,yflux_aperture118_err double
,ymag_aperture118_err float
,yflux_aperture168_err double
,ymag_aperture168_err float
,yflux_aperture235_err double
,ymag_aperture235_err float
,yflux_aperture10_ninterpolatedpixel smallint
,yflux_aperture15_ninterpolatedpixel smallint
,yflux_aperture20_ninterpolatedpixel smallint
,yflux_aperture30_ninterpolatedpixel smallint
,yflux_aperture40_ninterpolatedpixel smallint
,yflux_aperture57_ninterpolatedpixel smallint
,yflux_aperture84_ninterpolatedpixel smallint
,yflux_aperture118_ninterpolatedpixel smallint
,yflux_aperture168_ninterpolatedpixel smallint
,yflux_aperture235_ninterpolatedpixel smallint
,yflux_aperture_nprofile smallint
,yflux_aperture_flags boolean
,ycentroid_naive_ra double
,ycentroid_naive_dec double
,ycentroid_naive_flags boolean
,ycentroid_sdss_ra double
,ycentroid_sdss_dec double
,ycentroid_sdss_err_11 float
,ycentroid_sdss_err_22 float
,ycentroid_sdss_flags boolean
,ymultishapelet_psf_inner0 float
,ymultishapelet_psf_inner1 float
,ymultishapelet_psf_inner2 float
,ymultishapelet_psf_inner3 float
,ymultishapelet_psf_inner4 float
,ymultishapelet_psf_inner5 float
,ymultishapelet_psf_outer0 float
,ymultishapelet_psf_outer1 float
,ymultishapelet_psf_outer2 float
,ymultishapelet_psf_ellipse_11 float
,ymultishapelet_psf_ellipse_22 float
,ymultishapelet_psf_ellipse_12 float
,ymultishapelet_psf_chisq float
,ymultishapelet_psf_integral float
,ymultishapelet_psf_flags boolean
,ymultishapelet_psf_flags_maxiter boolean
,ymultishapelet_psf_flags_tinystep boolean
,ymultishapelet_psf_flags_constraint_r boolean
,ymultishapelet_psf_flags_constraint_q boolean
,yshape_sdss_11 float
,yshape_sdss_22 float
,yshape_sdss_12 float
,yshape_sdss_err_11_11 float
,yshape_sdss_err_22_22 float
,yshape_sdss_err_12_12 float
,yshape_sdss_centroid_ra double
,yshape_sdss_centroid_dec double
,yshape_sdss_psf_11 float
,yshape_sdss_psf_22 float
,yshape_sdss_psf_12 float
,yshape_sdss_flags boolean
,yshape_sdss_centroid_flags boolean
,yshape_sdss_flags_unweightedbad boolean
,yshape_sdss_flags_unweighted boolean
,yshape_sdss_flags_shift boolean
,yshape_sdss_flags_maxiter boolean
,yshape_sdss_flags_psf boolean
,ycmodel_initial_flux double
,ycmodel_initial_mag float
,ycmodel_initial_flux_err double
,ycmodel_initial_mag_err float
,ycmodel_initial_flux_inner double
,ycmodel_initial_mag_inner float
,ycmodel_exp_flux double
,ycmodel_exp_mag float
,ycmodel_exp_flux_err double
,ycmodel_exp_mag_err float
,ycmodel_exp_flux_inner double
,ycmodel_exp_mag_inner float
,ycmodel_dev_flux double
,ycmodel_dev_mag float
,ycmodel_dev_flux_err double
,ycmodel_dev_mag_err float
,ycmodel_dev_flux_inner double
,ycmodel_dev_mag_inner float
,ycmodel_center_ra double
,ycmodel_center_dec double
,ycmodel_flux double
,ycmodel_mag float
,ycmodel_flux_err double
,ycmodel_mag_err float
,ycmodel_flux_inner double
,ycmodel_mag_inner float
,ycmodel_fracdev float
,ycmodel_objective float
,ycmodel_dev_flux_apcorr float
,ycmodel_dev_flux_apcorr_err float
,ycmodel_exp_flux_apcorr float
,ycmodel_exp_flux_apcorr_err float
,ycmodel_flux_apcorr float
,ycmodel_flux_apcorr_err float
,ycmodel_initial_flux_flags boolean
,ycmodel_initial_flags_badreference boolean
,ycmodel_initial_flags_numericerror boolean
,ycmodel_exp_flux_flags boolean
,ycmodel_exp_flags_badreference boolean
,ycmodel_exp_flags_numericerror boolean
,ycmodel_dev_flux_flags boolean
,ycmodel_dev_flags_badreference boolean
,ycmodel_dev_flags_numericerror boolean
,ycmodel_flux_flags boolean
,ycmodel_flags_region_maxarea boolean
,ycmodel_flags_region_maxbadpixelfraction boolean
,ycmodel_flags_badreference boolean
,ycmodel_flags_nopsf boolean
,ycmodel_flags_nowcs boolean
,ycmodel_flags_nocalib boolean
,ycmodel_flags_badcentroid boolean
,ycmodel_dev_flux_flags_apcorr boolean
,ycmodel_exp_flux_flags_apcorr boolean
,ycmodel_flux_flags_apcorr boolean
,ycountinputs smallint
,yvariance float
,yclassification_extendedness float
,yflags_pixel_edge boolean
,yflags_pixel_interpolated_any boolean
,yflags_pixel_interpolated_center boolean
,yflags_pixel_saturated_any boolean
,yflags_pixel_saturated_center boolean
,yflags_pixel_cr_any boolean
,yflags_pixel_cr_center boolean
,yflags_pixel_bad boolean
,yflags_pixel_suspect_any boolean
,yflags_pixel_suspect_center boolean
,yflags_pixel_offimage boolean
,yflags_pixel_bright_object_center boolean
,yflags_pixel_clipped_any boolean
,yflags_pixel_bright_object_any boolean
)
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
WITH SERDEPROPERTIES (
'separatorChar' = ',',
'quoteChar' = '"',
'escapeChar' = '\\'
)
STORED AS TEXTFILE
LOCATION '/user/suga/pdr1_hive/pdr1_wide/forced/';
