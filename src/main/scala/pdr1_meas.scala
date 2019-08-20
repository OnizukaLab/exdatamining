package udafApp

import org.apache.spark.SparkContext

object meas {

  case class pdr1meas(
                       object_id: Long
                       , gra: Double
                       , gdec: Double
                       , gcoord: String
                       , rra: Double
                       , rdec: Double
                       , rcoord: String
                       , ira: Double
                       , idec: Double
                       , icoord: String
                       , zra: Double
                       , zdec: Double
                       , zcoord: String
                       , yra: Double
                       , ydec: Double
                       , ycoord: String
                       , skymap_id: Int
                       , tract: Int
                       , patch: Int
                       , patch_s: String
                       , parent_id: Long
                       , deblend_nchild: Int
                       , merge_footprint_i2: String
                       , merge_footprint_i: String
                       , merge_footprint_r: String
                       , merge_footprint_z: String
                       , merge_footprint_y: String
                       , merge_footprint_g: String
                       , merge_footprint_n921: String
                       , merge_footprint_n816: String
                       , merge_footprint_n1010: String
                       , merge_footprint_n387: String
                       , merge_footprint_n515: String
                       , merge_footprint_sky: String
                       , merge_peak_i2: String
                       , merge_peak_i: String
                       , merge_peak_r: String
                       , merge_peak_z: String
                       , merge_peak_y: String
                       , merge_peak_g: String
                       , merge_peak_n921: String
                       , merge_peak_n816: String
                       , merge_peak_n1010: String
                       , merge_peak_n387: String
                       , merge_peak_n515: String
                       , merge_peak_sky: String
                       , gflux_naive: Double
                       , gmag_naive: Float
                       , gflux_naive_err: Double
                       , gmag_naive_err: Float
                       , gflux_naive_flags: String
                       , gflux_sinc: Double
                       , gmag_sinc: Float
                       , gflux_sinc_err: Double
                       , gmag_sinc_err: Float
                       , gflux_sinc_flags: String
                       , gflux_psf: Double
                       , gmag_psf: Float
                       , gflux_psf_err: Double
                       , gmag_psf_err: Float
                       , gflux_psf_apcorr: Float
                       , gflux_psf_apcorr_err: Float
                       , gflux_psf_flags: String
                       , gflux_psf_flags_apcorr: String
                       , gflux_kron: Double
                       , gmag_kron: Float
                       , gflux_kron_err: Double
                       , gmag_kron_err: Float
                       , gflux_kron_radius: Float
                       , gflux_kron_radiusforradius: Float
                       , gflux_kron_psfradius: Float
                       , gflux_kron_apcorr: Float
                       , gflux_kron_apcorr_err: Float
                       , gflux_kron_flags: String
                       , gflux_kron_flags_edge: String
                       , gflux_kron_flags_radius: String
                       , gflux_kron_flags_smallradius: String
                       , gflux_kron_flags_usedminimumradius: String
                       , gflux_kron_flags_usedpsfradius: String
                       , gflux_kron_flags_badshape: String
                       , gflux_kron_flags_apcorr: String
                       , gflux_gaussian: Double
                       , gmag_gaussian: Float
                       , gflux_gaussian_err: Double
                       , gmag_gaussian_err: Float
                       , gflux_gaussian_apcorr: Float
                       , gflux_gaussian_apcorr_err: Float
                       , gflux_gaussian_flags: String
                       , gflux_gaussian_flags_apcorr: String
                       , gcmodel_initial_flux: Double
                       , gcmodel_initial_mag: Float
                       , gcmodel_initial_flux_err: Double
                       , gcmodel_initial_mag_err: Float
                       , gcmodel_initial_flux_inner: Double
                       , gcmodel_initial_mag_inner: Float
                       , gcmodel_initial_ellipse_11: Float
                       , gcmodel_initial_ellipse_22: Float
                       , gcmodel_initial_ellipse_12: Float
                       , gcmodel_initial_objective: Float
                       , gcmodel_initial_nonlinear0: Float
                       , gcmodel_initial_nonlinear1: Float
                       , gcmodel_initial_nonlinear2: Float
                       , gcmodel_initial_fixed0: Float
                       , gcmodel_initial_fixed1: Float
                       , gcmodel_initial_niter: Int
                       , gcmodel_initial_time: Float
                       , gcmodel_exp_flux: Double
                       , gcmodel_exp_mag: Float
                       , gcmodel_exp_flux_err: Double
                       , gcmodel_exp_mag_err: Float
                       , gcmodel_exp_flux_inner: Double
                       , gcmodel_exp_mag_inner: Float
                       , gcmodel_exp_ellipse_11: Float
                       , gcmodel_exp_ellipse_22: Float
                       , gcmodel_exp_ellipse_12: Float
                       , gcmodel_exp_objective: Float
                       , gcmodel_exp_nonlinear0: Float
                       , gcmodel_exp_nonlinear1: Float
                       , gcmodel_exp_nonlinear2: Float
                       , gcmodel_exp_fixed0: Float
                       , gcmodel_exp_fixed1: Float
                       , gcmodel_exp_niter: Int
                       , gcmodel_exp_time: Float
                       , gcmodel_dev_flux: Double
                       , gcmodel_dev_mag: Float
                       , gcmodel_dev_flux_err: Double
                       , gcmodel_dev_mag_err: Float
                       , gcmodel_dev_flux_inner: Double
                       , gcmodel_dev_mag_inner: Float
                       , gcmodel_dev_ellipse_11: Float
                       , gcmodel_dev_ellipse_22: Float
                       , gcmodel_dev_ellipse_12: Float
                       , gcmodel_dev_objective: Float
                       , gcmodel_dev_nonlinear0: Float
                       , gcmodel_dev_nonlinear1: Float
                       , gcmodel_dev_nonlinear2: Float
                       , gcmodel_dev_fixed0: Float
                       , gcmodel_dev_fixed1: Float
                       , gcmodel_dev_niter: Int
                       , gcmodel_dev_time: Float
                       , gcmodel_center_ra: Double
                       , gcmodel_center_dec: Double
                       , gcmodel_flux: Double
                       , gcmodel_mag: Float
                       , gcmodel_flux_err: Double
                       , gcmodel_mag_err: Float
                       , gcmodel_flux_inner: Double
                       , gcmodel_mag_inner: Float
                       , gcmodel_fracdev: Float
                       , gcmodel_objective: Float
                       , gcmodel_ellipse_11: Float
                       , gcmodel_ellipse_22: Float
                       , gcmodel_ellipse_12: Float
                       , gcmodel_region_initial_ellipse_11: Float
                       , gcmodel_region_initial_ellipse_22: Float
                       , gcmodel_region_initial_ellipse_12: Float
                       , gcmodel_region_final_ellipse_11: Float
                       , gcmodel_region_final_ellipse_22: Float
                       , gcmodel_region_final_ellipse_12: Float
                       , gcmodel_dev_flux_apcorr: Float
                       , gcmodel_dev_flux_apcorr_err: Float
                       , gcmodel_exp_flux_apcorr: Float
                       , gcmodel_exp_flux_apcorr_err: Float
                       , gcmodel_flux_apcorr: Float
                       , gcmodel_flux_apcorr_err: Float
                       , gcmodel_initial_flux_flags: String
                       , gcmodel_initial_flags_trsmall: String
                       , gcmodel_initial_flags_maxiter: String
                       , gcmodel_initial_flags_numericerror: String
                       , gcmodel_exp_flux_flags: String
                       , gcmodel_exp_flags_trsmall: String
                       , gcmodel_exp_flags_maxiter: String
                       , gcmodel_exp_flags_numericerror: String
                       , gcmodel_dev_flux_flags: String
                       , gcmodel_dev_flags_trsmall: String
                       , gcmodel_dev_flags_maxiter: String
                       , gcmodel_dev_flags_numericerror: String
                       , gcmodel_flux_flags: String
                       , gcmodel_flags_region_maxarea: String
                       , gcmodel_flags_region_maxbadpixelfraction: String
                       , gcmodel_flags_region_usedfootprintarea: String
                       , gcmodel_flags_region_usedpsfarea: String
                       , gcmodel_flags_region_usedinitialellipsemin: String
                       , gcmodel_flags_region_usedinitialellipsemax: String
                       , gcmodel_flags_noshape: String
                       , gcmodel_flags_smallshape: String
                       , gcmodel_flags_nopsf: String
                       , gcmodel_flags_nowcs: String
                       , gcmodel_flags_nocalib: String
                       , gcmodel_flags_badcentroid: String
                       , gcmodel_dev_flux_flags_apcorr: String
                       , gcmodel_exp_flux_flags_apcorr: String
                       , gcmodel_flux_flags_apcorr: String
                       , gdeblend_psf_center_ra: Double
                       , gdeblend_psf_center_dec: Double
                       , gdeblend_psf_flux: Double
                       , gdeblend_psf_mag: Float
                       , gblendedness_old: Float
                       , gblendedness_raw_flux: Float
                       , gblendedness_raw_flux_child: Double
                       , gblendedness_raw_mag_child: Float
                       , gblendedness_raw_flux_parent: Double
                       , gblendedness_raw_mag_parent: Float
                       , gblendedness_abs_flux: Float
                       , gblendedness_abs_flux_child: Double
                       , gblendedness_abs_mag_child: Float
                       , gblendedness_abs_flux_parent: Double
                       , gblendedness_abs_mag_parent: Float
                       , gblendedness_raw_shape_child_11: Float
                       , gblendedness_raw_shape_child_22: Float
                       , gblendedness_raw_shape_child_12: Float
                       , gblendedness_raw_shape_parent_11: Float
                       , gblendedness_raw_shape_parent_22: Float
                       , gblendedness_raw_shape_parent_12: Float
                       , gblendedness_abs_shape_child_11: Float
                       , gblendedness_abs_shape_child_22: Float
                       , gblendedness_abs_shape_child_12: Float
                       , gblendedness_abs_shape_parent_11: Float
                       , gblendedness_abs_shape_parent_22: Float
                       , gblendedness_abs_shape_parent_12: Float
                       , gdeblend_deblended_as_psf: String
                       , gdeblend_too_many_peaks: String
                       , gdeblend_parent_too_big: String
                       , gdeblend_masked: String
                       , gdeblend_skipped: String
                       , gdeblend_ramped_template: String
                       , gdeblend_patched_template: String
                       , gdeblend_has_stray_flux: String
                       , gblendedness_flags: String
                       , gblendedness_flags_nocentroid: String
                       , gblendedness_flags_noshape: String
                       , gcountinputs: Int
                       , gclassification_extendedness: Float
                       , gflags_negative: String
                       , gflags_badcentroid: String
                       , gflags_pixel_edge: String
                       , gflags_pixel_interpolated_any: String
                       , gflags_pixel_interpolated_center: String
                       , gflags_pixel_saturated_any: String
                       , gflags_pixel_saturated_center: String
                       , gflags_pixel_cr_any: String
                       , gflags_pixel_cr_center: String
                       , gflags_pixel_bad: String
                       , gflags_pixel_suspect_any: String
                       , gflags_pixel_suspect_center: String
                       , gflags_pixel_offimage: String
                       , gflags_pixel_bright_object_center: String
                       , gflags_pixel_clipped_any: String
                       , gflags_pixel_bright_object_any: String
                       , gdetect_is_patch_inner: String
                       , gdetect_is_tract_inner: String
                       , gdetect_is_primary: String
                       , gcalib_psf_candidate: String
                       , gcalib_psf_used: String
                       , rflux_naive: Double
                       , rmag_naive: Float
                       , rflux_naive_err: Double
                       , rmag_naive_err: Float
                       , rflux_naive_flags: String
                       , rflux_sinc: Double
                       , rmag_sinc: Float
                       , rflux_sinc_err: Double
                       , rmag_sinc_err: Float
                       , rflux_sinc_flags: String
                       , rflux_psf: Double
                       , rmag_psf: Float
                       , rflux_psf_err: Double
                       , rmag_psf_err: Float
                       , rflux_psf_apcorr: Float
                       , rflux_psf_apcorr_err: Float
                       , rflux_psf_flags: String
                       , rflux_psf_flags_apcorr: String
                       , rflux_kron: Double
                       , rmag_kron: Float
                       , rflux_kron_err: Double
                       , rmag_kron_err: Float
                       , rflux_kron_radius: Float
                       , rflux_kron_radiusforradius: Float
                       , rflux_kron_psfradius: Float
                       , rflux_kron_apcorr: Float
                       , rflux_kron_apcorr_err: Float
                       , rflux_kron_flags: String
                       , rflux_kron_flags_edge: String
                       , rflux_kron_flags_radius: String
                       , rflux_kron_flags_smallradius: String
                       , rflux_kron_flags_usedminimumradius: String
                       , rflux_kron_flags_usedpsfradius: String
                       , rflux_kron_flags_badshape: String
                       , rflux_kron_flags_apcorr: String
                       , rflux_gaussian: Double
                       , rmag_gaussian: Float
                       , rflux_gaussian_err: Double
                       , rmag_gaussian_err: Float
                       , rflux_gaussian_apcorr: Float
                       , rflux_gaussian_apcorr_err: Float
                       , rflux_gaussian_flags: String
                       , rflux_gaussian_flags_apcorr: String
                       , rcmodel_initial_flux: Double
                       , rcmodel_initial_mag: Float
                       , rcmodel_initial_flux_err: Double
                       , rcmodel_initial_mag_err: Float
                       , rcmodel_initial_flux_inner: Double
                       , rcmodel_initial_mag_inner: Float
                       , rcmodel_initial_ellipse_11: Float
                       , rcmodel_initial_ellipse_22: Float
                       , rcmodel_initial_ellipse_12: Float
                       , rcmodel_initial_objective: Float
                       , rcmodel_initial_nonlinear0: Float
                       , rcmodel_initial_nonlinear1: Float
                       , rcmodel_initial_nonlinear2: Float
                       , rcmodel_initial_fixed0: Float
                       , rcmodel_initial_fixed1: Float
                       , rcmodel_initial_niter: Int
                       , rcmodel_initial_time: Float
                       , rcmodel_exp_flux: Double
                       , rcmodel_exp_mag: Float
                       , rcmodel_exp_flux_err: Double
                       , rcmodel_exp_mag_err: Float
                       , rcmodel_exp_flux_inner: Double
                       , rcmodel_exp_mag_inner: Float
                       , rcmodel_exp_ellipse_11: Float
                       , rcmodel_exp_ellipse_22: Float
                       , rcmodel_exp_ellipse_12: Float
                       , rcmodel_exp_objective: Float
                       , rcmodel_exp_nonlinear0: Float
                       , rcmodel_exp_nonlinear1: Float
                       , rcmodel_exp_nonlinear2: Float
                       , rcmodel_exp_fixed0: Float
                       , rcmodel_exp_fixed1: Float
                       , rcmodel_exp_niter: Int
                       , rcmodel_exp_time: Float
                       , rcmodel_dev_flux: Double
                       , rcmodel_dev_mag: Float
                       , rcmodel_dev_flux_err: Double
                       , rcmodel_dev_mag_err: Float
                       , rcmodel_dev_flux_inner: Double
                       , rcmodel_dev_mag_inner: Float
                       , rcmodel_dev_ellipse_11: Float
                       , rcmodel_dev_ellipse_22: Float
                       , rcmodel_dev_ellipse_12: Float
                       , rcmodel_dev_objective: Float
                       , rcmodel_dev_nonlinear0: Float
                       , rcmodel_dev_nonlinear1: Float
                       , rcmodel_dev_nonlinear2: Float
                       , rcmodel_dev_fixed0: Float
                       , rcmodel_dev_fixed1: Float
                       , rcmodel_dev_niter: Int
                       , rcmodel_dev_time: Float
                       , rcmodel_center_ra: Double
                       , rcmodel_center_dec: Double
                       , rcmodel_flux: Double
                       , rcmodel_mag: Float
                       , rcmodel_flux_err: Double
                       , rcmodel_mag_err: Float
                       , rcmodel_flux_inner: Double
                       , rcmodel_mag_inner: Float
                       , rcmodel_fracdev: Float
                       , rcmodel_objective: Float
                       , rcmodel_ellipse_11: Float
                       , rcmodel_ellipse_22: Float
                       , rcmodel_ellipse_12: Float
                       , rcmodel_region_initial_ellipse_11: Float
                       , rcmodel_region_initial_ellipse_22: Float
                       , rcmodel_region_initial_ellipse_12: Float
                       , rcmodel_region_final_ellipse_11: Float
                       , rcmodel_region_final_ellipse_22: Float
                       , rcmodel_region_final_ellipse_12: Float
                       , rcmodel_dev_flux_apcorr: Float
                       , rcmodel_dev_flux_apcorr_err: Float
                       , rcmodel_exp_flux_apcorr: Float
                       , rcmodel_exp_flux_apcorr_err: Float
                       , rcmodel_flux_apcorr: Float
                       , rcmodel_flux_apcorr_err: Float
                       , rcmodel_initial_flux_flags: String
                       , rcmodel_initial_flags_trsmall: String
                       , rcmodel_initial_flags_maxiter: String
                       , rcmodel_initial_flags_numericerror: String
                       , rcmodel_exp_flux_flags: String
                       , rcmodel_exp_flags_trsmall: String
                       , rcmodel_exp_flags_maxiter: String
                       , rcmodel_exp_flags_numericerror: String
                       , rcmodel_dev_flux_flags: String
                       , rcmodel_dev_flags_trsmall: String
                       , rcmodel_dev_flags_maxiter: String
                       , rcmodel_dev_flags_numericerror: String
                       , rcmodel_flux_flags: String
                       , rcmodel_flags_region_maxarea: String
                       , rcmodel_flags_region_maxbadpixelfraction: String
                       , rcmodel_flags_region_usedfootprintarea: String
                       , rcmodel_flags_region_usedpsfarea: String
                       , rcmodel_flags_region_usedinitialellipsemin: String
                       , rcmodel_flags_region_usedinitialellipsemax: String
                       , rcmodel_flags_noshape: String
                       , rcmodel_flags_smallshape: String
                       , rcmodel_flags_nopsf: String
                       , rcmodel_flags_nowcs: String
                       , rcmodel_flags_nocalib: String
                       , rcmodel_flags_badcentroid: String
                       , rcmodel_dev_flux_flags_apcorr: String
                       , rcmodel_exp_flux_flags_apcorr: String
                       , rcmodel_flux_flags_apcorr: String
                       , rdeblend_psf_center_ra: Double
                       , rdeblend_psf_center_dec: Double
                       , rdeblend_psf_flux: Double
                       , rdeblend_psf_mag: Float
                       , rblendedness_old: Float
                       , rblendedness_raw_flux: Float
                       , rblendedness_raw_flux_child: Double
                       , rblendedness_raw_mag_child: Float
                       , rblendedness_raw_flux_parent: Double
                       , rblendedness_raw_mag_parent: Float
                       , rblendedness_abs_flux: Float
                       , rblendedness_abs_flux_child: Double
                       , rblendedness_abs_mag_child: Float
                       , rblendedness_abs_flux_parent: Double
                       , rblendedness_abs_mag_parent: Float
                       , rblendedness_raw_shape_child_11: Float
                       , rblendedness_raw_shape_child_22: Float
                       , rblendedness_raw_shape_child_12: Float
                       , rblendedness_raw_shape_parent_11: Float
                       , rblendedness_raw_shape_parent_22: Float
                       , rblendedness_raw_shape_parent_12: Float
                       , rblendedness_abs_shape_child_11: Float
                       , rblendedness_abs_shape_child_22: Float
                       , rblendedness_abs_shape_child_12: Float
                       , rblendedness_abs_shape_parent_11: Float
                       , rblendedness_abs_shape_parent_22: Float
                       , rblendedness_abs_shape_parent_12: Float
                       , rdeblend_deblended_as_psf: String
                       , rdeblend_too_many_peaks: String
                       , rdeblend_parent_too_big: String
                       , rdeblend_masked: String
                       , rdeblend_skipped: String
                       , rdeblend_ramped_template: String
                       , rdeblend_patched_template: String
                       , rdeblend_has_stray_flux: String
                       , rblendedness_flags: String
                       , rblendedness_flags_nocentroid: String
                       , rblendedness_flags_noshape: String
                       , rcountinputs: Int
                       , rclassification_extendedness: Float
                       , rflags_negative: String
                       , rflags_badcentroid: String
                       , rflags_pixel_edge: String
                       , rflags_pixel_interpolated_any: String
                       , rflags_pixel_interpolated_center: String
                       , rflags_pixel_saturated_any: String
                       , rflags_pixel_saturated_center: String
                       , rflags_pixel_cr_any: String
                       , rflags_pixel_cr_center: String
                       , rflags_pixel_bad: String
                       , rflags_pixel_suspect_any: String
                       , rflags_pixel_suspect_center: String
                       , rflags_pixel_offimage: String
                       , rflags_pixel_bright_object_center: String
                       , rflags_pixel_clipped_any: String
                       , rflags_pixel_bright_object_any: String
                       , rdetect_is_patch_inner: String
                       , rdetect_is_tract_inner: String
                       , rdetect_is_primary: String
                       , rcalib_psf_candidate: String
                       , rcalib_psf_used: String
                       , iflux_naive: Double
                       , imag_naive: Float
                       , iflux_naive_err: Double
                       , imag_naive_err: Float
                       , iflux_naive_flags: String
                       , iflux_sinc: Double
                       , imag_sinc: Float
                       , iflux_sinc_err: Double
                       , imag_sinc_err: Float
                       , iflux_sinc_flags: String
                       , iflux_psf: Double
                       , imag_psf: Float
                       , iflux_psf_err: Double
                       , imag_psf_err: Float
                       , iflux_psf_apcorr: Float
                       , iflux_psf_apcorr_err: Float
                       , iflux_psf_flags: String
                       , iflux_psf_flags_apcorr: String
                       , iflux_kron: Double
                       , imag_kron: Float
                       , iflux_kron_err: Double
                       , imag_kron_err: Float
                       , iflux_kron_radius: Float
                       , iflux_kron_radiusforradius: Float
                       , iflux_kron_psfradius: Float
                       , iflux_kron_apcorr: Float
                       , iflux_kron_apcorr_err: Float
                       , iflux_kron_flags: String
                       , iflux_kron_flags_edge: String
                       , iflux_kron_flags_radius: String
                       , iflux_kron_flags_smallradius: String
                       , iflux_kron_flags_usedminimumradius: String
                       , iflux_kron_flags_usedpsfradius: String
                       , iflux_kron_flags_badshape: String
                       , iflux_kron_flags_apcorr: String
                       , iflux_gaussian: Double
                       , imag_gaussian: Float
                       , iflux_gaussian_err: Double
                       , imag_gaussian_err: Float
                       , iflux_gaussian_apcorr: Float
                       , iflux_gaussian_apcorr_err: Float
                       , iflux_gaussian_flags: String
                       , iflux_gaussian_flags_apcorr: String
                       , icmodel_initial_flux: Double
                       , icmodel_initial_mag: Float
                       , icmodel_initial_flux_err: Double
                       , icmodel_initial_mag_err: Float
                       , icmodel_initial_flux_inner: Double
                       , icmodel_initial_mag_inner: Float
                       , icmodel_initial_ellipse_11: Float
                       , icmodel_initial_ellipse_22: Float
                       , icmodel_initial_ellipse_12: Float
                       , icmodel_initial_objective: Float
                       , icmodel_initial_nonlinear0: Float
                       , icmodel_initial_nonlinear1: Float
                       , icmodel_initial_nonlinear2: Float
                       , icmodel_initial_fixed0: Float
                       , icmodel_initial_fixed1: Float
                       , icmodel_initial_niter: Int
                       , icmodel_initial_time: Float
                       , icmodel_exp_flux: Double
                       , icmodel_exp_mag: Float
                       , icmodel_exp_flux_err: Double
                       , icmodel_exp_mag_err: Float
                       , icmodel_exp_flux_inner: Double
                       , icmodel_exp_mag_inner: Float
                       , icmodel_exp_ellipse_11: Float
                       , icmodel_exp_ellipse_22: Float
                       , icmodel_exp_ellipse_12: Float
                       , icmodel_exp_objective: Float
                       , icmodel_exp_nonlinear0: Float
                       , icmodel_exp_nonlinear1: Float
                       , icmodel_exp_nonlinear2: Float
                       , icmodel_exp_fixed0: Float
                       , icmodel_exp_fixed1: Float
                       , icmodel_exp_niter: Int
                       , icmodel_exp_time: Float
                       , icmodel_dev_flux: Double
                       , icmodel_dev_mag: Float
                       , icmodel_dev_flux_err: Double
                       , icmodel_dev_mag_err: Float
                       , icmodel_dev_flux_inner: Double
                       , icmodel_dev_mag_inner: Float
                       , icmodel_dev_ellipse_11: Float
                       , icmodel_dev_ellipse_22: Float
                       , icmodel_dev_ellipse_12: Float
                       , icmodel_dev_objective: Float
                       , icmodel_dev_nonlinear0: Float
                       , icmodel_dev_nonlinear1: Float
                       , icmodel_dev_nonlinear2: Float
                       , icmodel_dev_fixed0: Float
                       , icmodel_dev_fixed1: Float
                       , icmodel_dev_niter: Int
                       , icmodel_dev_time: Float
                       , icmodel_center_ra: Double
                       , icmodel_center_dec: Double
                       , icmodel_flux: Double
                       , icmodel_mag: Float
                       , icmodel_flux_err: Double
                       , icmodel_mag_err: Float
                       , icmodel_flux_inner: Double
                       , icmodel_mag_inner: Float
                       , icmodel_fracdev: Float
                       , icmodel_objective: Float
                       , icmodel_ellipse_11: Float
                       , icmodel_ellipse_22: Float
                       , icmodel_ellipse_12: Float
                       , icmodel_region_initial_ellipse_11: Float
                       , icmodel_region_initial_ellipse_22: Float
                       , icmodel_region_initial_ellipse_12: Float
                       , icmodel_region_final_ellipse_11: Float
                       , icmodel_region_final_ellipse_22: Float
                       , icmodel_region_final_ellipse_12: Float
                       , icmodel_dev_flux_apcorr: Float
                       , icmodel_dev_flux_apcorr_err: Float
                       , icmodel_exp_flux_apcorr: Float
                       , icmodel_exp_flux_apcorr_err: Float
                       , icmodel_flux_apcorr: Float
                       , icmodel_flux_apcorr_err: Float
                       , icmodel_initial_flux_flags: String
                       , icmodel_initial_flags_trsmall: String
                       , icmodel_initial_flags_maxiter: String
                       , icmodel_initial_flags_numericerror: String
                       , icmodel_exp_flux_flags: String
                       , icmodel_exp_flags_trsmall: String
                       , icmodel_exp_flags_maxiter: String
                       , icmodel_exp_flags_numericerror: String
                       , icmodel_dev_flux_flags: String
                       , icmodel_dev_flags_trsmall: String
                       , icmodel_dev_flags_maxiter: String
                       , icmodel_dev_flags_numericerror: String
                       , icmodel_flux_flags: String
                       , icmodel_flags_region_maxarea: String
                       , icmodel_flags_region_maxbadpixelfraction: String
                       , icmodel_flags_region_usedfootprintarea: String
                       , icmodel_flags_region_usedpsfarea: String
                       , icmodel_flags_region_usedinitialellipsemin: String
                       , icmodel_flags_region_usedinitialellipsemax: String
                       , icmodel_flags_noshape: String
                       , icmodel_flags_smallshape: String
                       , icmodel_flags_nopsf: String
                       , icmodel_flags_nowcs: String
                       , icmodel_flags_nocalib: String
                       , icmodel_flags_badcentroid: String
                       , icmodel_dev_flux_flags_apcorr: String
                       , icmodel_exp_flux_flags_apcorr: String
                       , icmodel_flux_flags_apcorr: String
                       , ideblend_psf_center_ra: Double
                       , ideblend_psf_center_dec: Double
                       , ideblend_psf_flux: Double
                       , ideblend_psf_mag: Float
                       , iblendedness_old: Float
                       , iblendedness_raw_flux: Float
                       , iblendedness_raw_flux_child: Double
                       , iblendedness_raw_mag_child: Float
                       , iblendedness_raw_flux_parent: Double
                       , iblendedness_raw_mag_parent: Float
                       , iblendedness_abs_flux: Float
                       , iblendedness_abs_flux_child: Double
                       , iblendedness_abs_mag_child: Float
                       , iblendedness_abs_flux_parent: Double
                       , iblendedness_abs_mag_parent: Float
                       , iblendedness_raw_shape_child_11: Float
                       , iblendedness_raw_shape_child_22: Float
                       , iblendedness_raw_shape_child_12: Float
                       , iblendedness_raw_shape_parent_11: Float
                       , iblendedness_raw_shape_parent_22: Float
                       , iblendedness_raw_shape_parent_12: Float
                       , iblendedness_abs_shape_child_11: Float
                       , iblendedness_abs_shape_child_22: Float
                       , iblendedness_abs_shape_child_12: Float
                       , iblendedness_abs_shape_parent_11: Float
                       , iblendedness_abs_shape_parent_22: Float
                       , iblendedness_abs_shape_parent_12: Float
                       , ideblend_deblended_as_psf: String
                       , ideblend_too_many_peaks: String
                       , ideblend_parent_too_big: String
                       , ideblend_masked: String
                       , ideblend_skipped: String
                       , ideblend_ramped_template: String
                       , ideblend_patched_template: String
                       , ideblend_has_stray_flux: String
                       , iblendedness_flags: String
                       , iblendedness_flags_nocentroid: String
                       , iblendedness_flags_noshape: String
                       , icountinputs: Int
                       , iclassification_extendedness: Float
                       , iflags_negative: String
                       , iflags_badcentroid: String
                       , iflags_pixel_edge: String
                       , iflags_pixel_interpolated_any: String
                       , iflags_pixel_interpolated_center: String
                       , iflags_pixel_saturated_any: String
                       , iflags_pixel_saturated_center: String
                       , iflags_pixel_cr_any: String
                       , iflags_pixel_cr_center: String
                       , iflags_pixel_bad: String
                       , iflags_pixel_suspect_any: String
                       , iflags_pixel_suspect_center: String
                       , iflags_pixel_offimage: String
                       , iflags_pixel_bright_object_center: String
                       , iflags_pixel_clipped_any: String
                       , iflags_pixel_bright_object_any: String
                       , idetect_is_patch_inner: String
                       , idetect_is_tract_inner: String
                       , idetect_is_primary: String
                       , icalib_psf_candidate: String
                       , icalib_psf_used: String
                       , zflux_naive: Double
                       , zmag_naive: Float
                       , zflux_naive_err: Double
                       , zmag_naive_err: Float
                       , zflux_naive_flags: String
                       , zflux_sinc: Double
                       , zmag_sinc: Float
                       , zflux_sinc_err: Double
                       , zmag_sinc_err: Float
                       , zflux_sinc_flags: String
                       , zflux_psf: Double
                       , zmag_psf: Float
                       , zflux_psf_err: Double
                       , zmag_psf_err: Float
                       , zflux_psf_apcorr: Float
                       , zflux_psf_apcorr_err: Float
                       , zflux_psf_flags: String
                       , zflux_psf_flags_apcorr: String
                       , zflux_kron: Double
                       , zmag_kron: Float
                       , zflux_kron_err: Double
                       , zmag_kron_err: Float
                       , zflux_kron_radius: Float
                       , zflux_kron_radiusforradius: Float
                       , zflux_kron_psfradius: Float
                       , zflux_kron_apcorr: Float
                       , zflux_kron_apcorr_err: Float
                       , zflux_kron_flags: String
                       , zflux_kron_flags_edge: String
                       , zflux_kron_flags_radius: String
                       , zflux_kron_flags_smallradius: String
                       , zflux_kron_flags_usedminimumradius: String
                       , zflux_kron_flags_usedpsfradius: String
                       , zflux_kron_flags_badshape: String
                       , zflux_kron_flags_apcorr: String
                       , zflux_gaussian: Double
                       , zmag_gaussian: Float
                       , zflux_gaussian_err: Double
                       , zmag_gaussian_err: Float
                       , zflux_gaussian_apcorr: Float
                       , zflux_gaussian_apcorr_err: Float
                       , zflux_gaussian_flags: String
                       , zflux_gaussian_flags_apcorr: String
                       , zcmodel_initial_flux: Double
                       , zcmodel_initial_mag: Float
                       , zcmodel_initial_flux_err: Double
                       , zcmodel_initial_mag_err: Float
                       , zcmodel_initial_flux_inner: Double
                       , zcmodel_initial_mag_inner: Float
                       , zcmodel_initial_ellipse_11: Float
                       , zcmodel_initial_ellipse_22: Float
                       , zcmodel_initial_ellipse_12: Float
                       , zcmodel_initial_objective: Float
                       , zcmodel_initial_nonlinear0: Float
                       , zcmodel_initial_nonlinear1: Float
                       , zcmodel_initial_nonlinear2: Float
                       , zcmodel_initial_fixed0: Float
                       , zcmodel_initial_fixed1: Float
                       , zcmodel_initial_niter: Int
                       , zcmodel_initial_time: Float
                       , zcmodel_exp_flux: Double
                       , zcmodel_exp_mag: Float
                       , zcmodel_exp_flux_err: Double
                       , zcmodel_exp_mag_err: Float
                       , zcmodel_exp_flux_inner: Double
                       , zcmodel_exp_mag_inner: Float
                       , zcmodel_exp_ellipse_11: Float
                       , zcmodel_exp_ellipse_22: Float
                       , zcmodel_exp_ellipse_12: Float
                       , zcmodel_exp_objective: Float
                       , zcmodel_exp_nonlinear0: Float
                       , zcmodel_exp_nonlinear1: Float
                       , zcmodel_exp_nonlinear2: Float
                       , zcmodel_exp_fixed0: Float
                       , zcmodel_exp_fixed1: Float
                       , zcmodel_exp_niter: Int
                       , zcmodel_exp_time: Float
                       , zcmodel_dev_flux: Double
                       , zcmodel_dev_mag: Float
                       , zcmodel_dev_flux_err: Double
                       , zcmodel_dev_mag_err: Float
                       , zcmodel_dev_flux_inner: Double
                       , zcmodel_dev_mag_inner: Float
                       , zcmodel_dev_ellipse_11: Float
                       , zcmodel_dev_ellipse_22: Float
                       , zcmodel_dev_ellipse_12: Float
                       , zcmodel_dev_objective: Float
                       , zcmodel_dev_nonlinear0: Float
                       , zcmodel_dev_nonlinear1: Float
                       , zcmodel_dev_nonlinear2: Float
                       , zcmodel_dev_fixed0: Float
                       , zcmodel_dev_fixed1: Float
                       , zcmodel_dev_niter: Int
                       , zcmodel_dev_time: Float
                       , zcmodel_center_ra: Double
                       , zcmodel_center_dec: Double
                       , zcmodel_flux: Double
                       , zcmodel_mag: Float
                       , zcmodel_flux_err: Double
                       , zcmodel_mag_err: Float
                       , zcmodel_flux_inner: Double
                       , zcmodel_mag_inner: Float
                       , zcmodel_fracdev: Float
                       , zcmodel_objective: Float
                       , zcmodel_ellipse_11: Float
                       , zcmodel_ellipse_22: Float
                       , zcmodel_ellipse_12: Float
                       , zcmodel_region_initial_ellipse_11: Float
                       , zcmodel_region_initial_ellipse_22: Float
                       , zcmodel_region_initial_ellipse_12: Float
                       , zcmodel_region_final_ellipse_11: Float
                       , zcmodel_region_final_ellipse_22: Float
                       , zcmodel_region_final_ellipse_12: Float
                       , zcmodel_dev_flux_apcorr: Float
                       , zcmodel_dev_flux_apcorr_err: Float
                       , zcmodel_exp_flux_apcorr: Float
                       , zcmodel_exp_flux_apcorr_err: Float
                       , zcmodel_flux_apcorr: Float
                       , zcmodel_flux_apcorr_err: Float
                       , zcmodel_initial_flux_flags: String
                       , zcmodel_initial_flags_trsmall: String
                       , zcmodel_initial_flags_maxiter: String
                       , zcmodel_initial_flags_numericerror: String
                       , zcmodel_exp_flux_flags: String
                       , zcmodel_exp_flags_trsmall: String
                       , zcmodel_exp_flags_maxiter: String
                       , zcmodel_exp_flags_numericerror: String
                       , zcmodel_dev_flux_flags: String
                       , zcmodel_dev_flags_trsmall: String
                       , zcmodel_dev_flags_maxiter: String
                       , zcmodel_dev_flags_numericerror: String
                       , zcmodel_flux_flags: String
                       , zcmodel_flags_region_maxarea: String
                       , zcmodel_flags_region_maxbadpixelfraction: String
                       , zcmodel_flags_region_usedfootprintarea: String
                       , zcmodel_flags_region_usedpsfarea: String
                       , zcmodel_flags_region_usedinitialellipsemin: String
                       , zcmodel_flags_region_usedinitialellipsemax: String
                       , zcmodel_flags_noshape: String
                       , zcmodel_flags_smallshape: String
                       , zcmodel_flags_nopsf: String
                       , zcmodel_flags_nowcs: String
                       , zcmodel_flags_nocalib: String
                       , zcmodel_flags_badcentroid: String
                       , zcmodel_dev_flux_flags_apcorr: String
                       , zcmodel_exp_flux_flags_apcorr: String
                       , zcmodel_flux_flags_apcorr: String
                       , zdeblend_psf_center_ra: Double
                       , zdeblend_psf_center_dec: Double
                       , zdeblend_psf_flux: Double
                       , zdeblend_psf_mag: Float
                       , zblendedness_old: Float
                       , zblendedness_raw_flux: Float
                       , zblendedness_raw_flux_child: Double
                       , zblendedness_raw_mag_child: Float
                       , zblendedness_raw_flux_parent: Double
                       , zblendedness_raw_mag_parent: Float
                       , zblendedness_abs_flux: Float
                       , zblendedness_abs_flux_child: Double
                       , zblendedness_abs_mag_child: Float
                       , zblendedness_abs_flux_parent: Double
                       , zblendedness_abs_mag_parent: Float
                       , zblendedness_raw_shape_child_11: Float
                       , zblendedness_raw_shape_child_22: Float
                       , zblendedness_raw_shape_child_12: Float
                       , zblendedness_raw_shape_parent_11: Float
                       , zblendedness_raw_shape_parent_22: Float
                       , zblendedness_raw_shape_parent_12: Float
                       , zblendedness_abs_shape_child_11: Float
                       , zblendedness_abs_shape_child_22: Float
                       , zblendedness_abs_shape_child_12: Float
                       , zblendedness_abs_shape_parent_11: Float
                       , zblendedness_abs_shape_parent_22: Float
                       , zblendedness_abs_shape_parent_12: Float
                       , zdeblend_deblended_as_psf: String
                       , zdeblend_too_many_peaks: String
                       , zdeblend_parent_too_big: String
                       , zdeblend_masked: String
                       , zdeblend_skipped: String
                       , zdeblend_ramped_template: String
                       , zdeblend_patched_template: String
                       , zdeblend_has_stray_flux: String
                       , zblendedness_flags: String
                       , zblendedness_flags_nocentroid: String
                       , zblendedness_flags_noshape: String
                       , zcountinputs: Int
                       , zclassification_extendedness: Float
                       , zflags_negative: String
                       , zflags_badcentroid: String
                       , zflags_pixel_edge: String
                       , zflags_pixel_interpolated_any: String
                       , zflags_pixel_interpolated_center: String
                       , zflags_pixel_saturated_any: String
                       , zflags_pixel_saturated_center: String
                       , zflags_pixel_cr_any: String
                       , zflags_pixel_cr_center: String
                       , zflags_pixel_bad: String
                       , zflags_pixel_suspect_any: String
                       , zflags_pixel_suspect_center: String
                       , zflags_pixel_offimage: String
                       , zflags_pixel_bright_object_center: String
                       , zflags_pixel_clipped_any: String
                       , zflags_pixel_bright_object_any: String
                       , zdetect_is_patch_inner: String
                       , zdetect_is_tract_inner: String
                       , zdetect_is_primary: String
                       , zcalib_psf_candidate: String
                       , zcalib_psf_used: String
                       , yflux_naive: Double
                       , ymag_naive: Float
                       , yflux_naive_err: Double
                       , ymag_naive_err: Float
                       , yflux_naive_flags: String
                       , yflux_sinc: Double
                       , ymag_sinc: Float
                       , yflux_sinc_err: Double
                       , ymag_sinc_err: Float
                       , yflux_sinc_flags: String
                       , yflux_psf: Double
                       , ymag_psf: Float
                       , yflux_psf_err: Double
                       , ymag_psf_err: Float
                       , yflux_psf_apcorr: Float
                       , yflux_psf_apcorr_err: Float
                       , yflux_psf_flags: String
                       , yflux_psf_flags_apcorr: String
                       , yflux_kron: Double
                       , ymag_kron: Float
                       , yflux_kron_err: Double
                       , ymag_kron_err: Float
                       , yflux_kron_radius: Float
                       , yflux_kron_radiusforradius: Float
                       , yflux_kron_psfradius: Float
                       , yflux_kron_apcorr: Float
                       , yflux_kron_apcorr_err: Float
                       , yflux_kron_flags: String
                       , yflux_kron_flags_edge: String
                       , yflux_kron_flags_radius: String
                       , yflux_kron_flags_smallradius: String
                       , yflux_kron_flags_usedminimumradius: String
                       , yflux_kron_flags_usedpsfradius: String
                       , yflux_kron_flags_badshape: String
                       , yflux_kron_flags_apcorr: String
                       , yflux_gaussian: Double
                       , ymag_gaussian: Float
                       , yflux_gaussian_err: Double
                       , ymag_gaussian_err: Float
                       , yflux_gaussian_apcorr: Float
                       , yflux_gaussian_apcorr_err: Float
                       , yflux_gaussian_flags: String
                       , yflux_gaussian_flags_apcorr: String
                       , ycmodel_initial_flux: Double
                       , ycmodel_initial_mag: Float
                       , ycmodel_initial_flux_err: Double
                       , ycmodel_initial_mag_err: Float
                       , ycmodel_initial_flux_inner: Double
                       , ycmodel_initial_mag_inner: Float
                       , ycmodel_initial_ellipse_11: Float
                       , ycmodel_initial_ellipse_22: Float
                       , ycmodel_initial_ellipse_12: Float
                       , ycmodel_initial_objective: Float
                       , ycmodel_initial_nonlinear0: Float
                       , ycmodel_initial_nonlinear1: Float
                       , ycmodel_initial_nonlinear2: Float
                       , ycmodel_initial_fixed0: Float
                       , ycmodel_initial_fixed1: Float
                       , ycmodel_initial_niter: Int
                       , ycmodel_initial_time: Float
                       , ycmodel_exp_flux: Double
                       , ycmodel_exp_mag: Float
                       , ycmodel_exp_flux_err: Double
                       , ycmodel_exp_mag_err: Float
                       , ycmodel_exp_flux_inner: Double
                       , ycmodel_exp_mag_inner: Float
                       , ycmodel_exp_ellipse_11: Float
                       , ycmodel_exp_ellipse_22: Float
                       , ycmodel_exp_ellipse_12: Float
                       , ycmodel_exp_objective: Float
                       , ycmodel_exp_nonlinear0: Float
                       , ycmodel_exp_nonlinear1: Float
                       , ycmodel_exp_nonlinear2: Float
                       , ycmodel_exp_fixed0: Float
                       , ycmodel_exp_fixed1: Float
                       , ycmodel_exp_niter: Int
                       , ycmodel_exp_time: Float
                       , ycmodel_dev_flux: Double
                       , ycmodel_dev_mag: Float
                       , ycmodel_dev_flux_err: Double
                       , ycmodel_dev_mag_err: Float
                       , ycmodel_dev_flux_inner: Double
                       , ycmodel_dev_mag_inner: Float
                       , ycmodel_dev_ellipse_11: Float
                       , ycmodel_dev_ellipse_22: Float
                       , ycmodel_dev_ellipse_12: Float
                       , ycmodel_dev_objective: Float
                       , ycmodel_dev_nonlinear0: Float
                       , ycmodel_dev_nonlinear1: Float
                       , ycmodel_dev_nonlinear2: Float
                       , ycmodel_dev_fixed0: Float
                       , ycmodel_dev_fixed1: Float
                       , ycmodel_dev_niter: Int
                       , ycmodel_dev_time: Float
                       , ycmodel_center_ra: Double
                       , ycmodel_center_dec: Double
                       , ycmodel_flux: Double
                       , ycmodel_mag: Float
                       , ycmodel_flux_err: Double
                       , ycmodel_mag_err: Float
                       , ycmodel_flux_inner: Double
                       , ycmodel_mag_inner: Float
                       , ycmodel_fracdev: Float
                       , ycmodel_objective: Float
                       , ycmodel_ellipse_11: Float
                       , ycmodel_ellipse_22: Float
                       , ycmodel_ellipse_12: Float
                       , ycmodel_region_initial_ellipse_11: Float
                       , ycmodel_region_initial_ellipse_22: Float
                       , ycmodel_region_initial_ellipse_12: Float
                       , ycmodel_region_final_ellipse_11: Float
                       , ycmodel_region_final_ellipse_22: Float
                       , ycmodel_region_final_ellipse_12: Float
                       , ycmodel_dev_flux_apcorr: Float
                       , ycmodel_dev_flux_apcorr_err: Float
                       , ycmodel_exp_flux_apcorr: Float
                       , ycmodel_exp_flux_apcorr_err: Float
                       , ycmodel_flux_apcorr: Float
                       , ycmodel_flux_apcorr_err: Float
                       , ycmodel_initial_flux_flags: String
                       , ycmodel_initial_flags_trsmall: String
                       , ycmodel_initial_flags_maxiter: String
                       , ycmodel_initial_flags_numericerror: String
                       , ycmodel_exp_flux_flags: String
                       , ycmodel_exp_flags_trsmall: String
                       , ycmodel_exp_flags_maxiter: String
                       , ycmodel_exp_flags_numericerror: String
                       , ycmodel_dev_flux_flags: String
                       , ycmodel_dev_flags_trsmall: String
                       , ycmodel_dev_flags_maxiter: String
                       , ycmodel_dev_flags_numericerror: String
                       , ycmodel_flux_flags: String
                       , ycmodel_flags_region_maxarea: String
                       , ycmodel_flags_region_maxbadpixelfraction: String
                       , ycmodel_flags_region_usedfootprintarea: String
                       , ycmodel_flags_region_usedpsfarea: String
                       , ycmodel_flags_region_usedinitialellipsemin: String
                       , ycmodel_flags_region_usedinitialellipsemax: String
                       , ycmodel_flags_noshape: String
                       , ycmodel_flags_smallshape: String
                       , ycmodel_flags_nopsf: String
                       , ycmodel_flags_nowcs: String
                       , ycmodel_flags_nocalib: String
                       , ycmodel_flags_badcentroid: String
                       , ycmodel_dev_flux_flags_apcorr: String
                       , ycmodel_exp_flux_flags_apcorr: String
                       , ycmodel_flux_flags_apcorr: String
                       , ydeblend_psf_center_ra: Double
                       , ydeblend_psf_center_dec: Double
                       , ydeblend_psf_flux: Double
                       , ydeblend_psf_mag: Float
                       , yblendedness_old: Float
                       , yblendedness_raw_flux: Float
                       , yblendedness_raw_flux_child: Double
                       , yblendedness_raw_mag_child: Float
                       , yblendedness_raw_flux_parent: Double
                       , yblendedness_raw_mag_parent: Float
                       , yblendedness_abs_flux: Float
                       , yblendedness_abs_flux_child: Double
                       , yblendedness_abs_mag_child: Float
                       , yblendedness_abs_flux_parent: Double
                       , yblendedness_abs_mag_parent: Float
                       , yblendedness_raw_shape_child_11: Float
                       , yblendedness_raw_shape_child_22: Float
                       , yblendedness_raw_shape_child_12: Float
                       , yblendedness_raw_shape_parent_11: Float
                       , yblendedness_raw_shape_parent_22: Float
                       , yblendedness_raw_shape_parent_12: Float
                       , yblendedness_abs_shape_child_11: Float
                       , yblendedness_abs_shape_child_22: Float
                       , yblendedness_abs_shape_child_12: Float
                       , yblendedness_abs_shape_parent_11: Float
                       , yblendedness_abs_shape_parent_22: Float
                       , yblendedness_abs_shape_parent_12: Float
                       , ydeblend_deblended_as_psf: String
                       , ydeblend_too_many_peaks: String
                       , ydeblend_parent_too_big: String
                       , ydeblend_masked: String
                       , ydeblend_skipped: String
                       , ydeblend_ramped_template: String
                       , ydeblend_patched_template: String
                       , ydeblend_has_stray_flux: String
                       , yblendedness_flags: String
                       , yblendedness_flags_nocentroid: String
                       , yblendedness_flags_noshape: String
                       , ycountinputs: Int
                       , yclassification_extendedness: Float
                       , yflags_negative: String
                       , yflags_badcentroid: String
                       , yflags_pixel_edge: String
                       , yflags_pixel_interpolated_any: String
                       , yflags_pixel_interpolated_center: String
                       , yflags_pixel_saturated_any: String
                       , yflags_pixel_saturated_center: String
                       , yflags_pixel_cr_any: String
                       , yflags_pixel_cr_center: String
                       , yflags_pixel_bad: String
                       , yflags_pixel_suspect_any: String
                       , yflags_pixel_suspect_center: String
                       , yflags_pixel_offimage: String
                       , yflags_pixel_bright_object_center: String
                       , yflags_pixel_clipped_any: String
                       , yflags_pixel_bright_object_any: String
                       , ydetect_is_patch_inner: String
                       , ydetect_is_tract_inner: String
                       , ydetect_is_primary: String
                       , ycalib_psf_candidate: String
                       , ycalib_psf_used: String
                     )

  def read_meas(sc: SparkContext) = {
    sc.textFile("hdfs:///user/matsumoto/sample_pdr1_wide.meas").
      map { lines =>
        val elms = lines.split(',')
        val object_id = elms(0).toLong
        val gra = elms(1).toDouble
        val gdec = elms(2).toDouble
        val gcoord = elms(3) + elms(4) + elms(5)
        val rra = elms(6).toDouble
        val rdec = elms(7).toDouble
        val rcoord = elms(8) + elms(9) + elms(10)
        val ira = elms(11).toDouble
        val idec = elms(12).toDouble
        val icoord = elms(13) + elms(14) + elms(15)
        val zra = elms(16).toDouble
        val zdec = elms(17).toDouble
        val zcoord = elms(18) + elms(19) + elms(20)
        val yra = elms(21).toDouble
        val ydec = elms(22).toDouble
        val ycoord = elms(23) + elms(24) + elms(25)
        val skymap_id = elms(26).toInt
        val tract = elms(27).toInt
        val patch = elms(28).toInt
        val patch_s = elms(29)
        val parent_id = elms(30).toLong
        val deblend_nchild = elms(31).toInt
        val merge_footprint_i2 = elms(32)
        val merge_footprint_i = elms(33)
        val merge_footprint_r = elms(34)
        val merge_footprint_z = elms(35)
        val merge_footprint_y = elms(36)
        val merge_footprint_g = elms(37)
        val merge_footprint_n921 = elms(38)
        val merge_footprint_n816 = elms(39)
        val merge_footprint_n1010 = elms(40)
        val merge_footprint_n387 = elms(41)
        val merge_footprint_n515 = elms(42)
        val merge_footprint_sky = elms(43)
        val merge_peak_i2 = elms(44)
        val merge_peak_i = elms(45)
        val merge_peak_r = elms(46)
        val merge_peak_z = elms(47)
        val merge_peak_y = elms(48)
        val merge_peak_g = elms(49)
        val merge_peak_n921 = elms(50)
        val merge_peak_n816 = elms(51)
        val merge_peak_n1010 = elms(52)
        val merge_peak_n387 = elms(53)
        val merge_peak_n515 = elms(54)
        val merge_peak_sky = elms(55)
        val gflux_naive = elms(56).toDouble
        val gmag_naive = elms(57).toFloat
        val gflux_naive_err = elms(58).toDouble
        val gmag_naive_err = elms(59).toFloat
        val gflux_naive_flags = elms(60)
        val gflux_sinc = elms(61).toDouble
        val gmag_sinc = elms(62).toFloat
        val gflux_sinc_err = elms(63).toDouble
        val gmag_sinc_err = elms(64).toFloat
        val gflux_sinc_flags = elms(65)
        val gflux_psf = elms(66).toDouble
        val gmag_psf = elms(67).toFloat
        val gflux_psf_err = elms(68).toDouble
        val gmag_psf_err = elms(69).toFloat
        val gflux_psf_apcorr = elms(70).toFloat
        val gflux_psf_apcorr_err = elms(71).toFloat
        val gflux_psf_flags = elms(72)
        val gflux_psf_flags_apcorr = elms(73)
        val gflux_kron = elms(74).toDouble
        val gmag_kron = elms(75).toFloat
        val gflux_kron_err = elms(76).toDouble
        val gmag_kron_err = elms(77).toFloat
        val gflux_kron_radius = elms(78).toFloat
        val gflux_kron_radiusforradius = elms(79).toFloat
        val gflux_kron_psfradius = elms(80).toFloat
        val gflux_kron_apcorr = elms(81).toFloat
        val gflux_kron_apcorr_err = elms(82).toFloat
        val gflux_kron_flags = elms(83)
        val gflux_kron_flags_edge = elms(84)
        val gflux_kron_flags_radius = elms(85)
        val gflux_kron_flags_smallradius = elms(86)
        val gflux_kron_flags_usedminimumradius = elms(87)
        val gflux_kron_flags_usedpsfradius = elms(88)
        val gflux_kron_flags_badshape = elms(89)
        val gflux_kron_flags_apcorr = elms(90)
        val gflux_gaussian = elms(91).toDouble
        val gmag_gaussian = elms(92).toFloat
        val gflux_gaussian_err = elms(93).toDouble
        val gmag_gaussian_err = elms(94).toFloat
        val gflux_gaussian_apcorr = elms(95).toFloat
        val gflux_gaussian_apcorr_err = elms(96).toFloat
        val gflux_gaussian_flags = elms(97)
        val gflux_gaussian_flags_apcorr = elms(98)
        val gcmodel_initial_flux = elms(99).toDouble
        val gcmodel_initial_mag = elms(100).toFloat
        val gcmodel_initial_flux_err = elms(101).toDouble
        val gcmodel_initial_mag_err = elms(102).toFloat
        val gcmodel_initial_flux_inner = elms(103).toDouble
        val gcmodel_initial_mag_inner = elms(104).toFloat
        val gcmodel_initial_ellipse_11 = elms(105).toFloat
        val gcmodel_initial_ellipse_22 = elms(106).toFloat
        val gcmodel_initial_ellipse_12 = elms(107).toFloat
        val gcmodel_initial_objective = elms(108).toFloat
        val gcmodel_initial_nonlinear0 = elms(109).toFloat
        val gcmodel_initial_nonlinear1 = elms(110).toFloat
        val gcmodel_initial_nonlinear2 = elms(111).toFloat
        val gcmodel_initial_fixed0 = elms(112).toFloat
        val gcmodel_initial_fixed1 = elms(113).toFloat
        val gcmodel_initial_niter = elms(114).toInt
        val gcmodel_initial_time = elms(115).toFloat
        val gcmodel_exp_flux = elms(116).toDouble
        val gcmodel_exp_mag = elms(117).toFloat
        val gcmodel_exp_flux_err = elms(118).toDouble
        val gcmodel_exp_mag_err = elms(119).toFloat
        val gcmodel_exp_flux_inner = elms(120).toDouble
        val gcmodel_exp_mag_inner = elms(121).toFloat
        val gcmodel_exp_ellipse_11 = elms(122).toFloat
        val gcmodel_exp_ellipse_22 = elms(123).toFloat
        val gcmodel_exp_ellipse_12 = elms(124).toFloat
        val gcmodel_exp_objective = elms(125).toFloat
        val gcmodel_exp_nonlinear0 = elms(126).toFloat
        val gcmodel_exp_nonlinear1 = elms(127).toFloat
        val gcmodel_exp_nonlinear2 = elms(128).toFloat
        val gcmodel_exp_fixed0 = elms(129).toFloat
        val gcmodel_exp_fixed1 = elms(130).toFloat
        val gcmodel_exp_niter = elms(131).toInt
        val gcmodel_exp_time = elms(132).toFloat
        val gcmodel_dev_flux = elms(133).toDouble
        val gcmodel_dev_mag = elms(134).toFloat
        val gcmodel_dev_flux_err = elms(135).toDouble
        val gcmodel_dev_mag_err = elms(136).toFloat
        val gcmodel_dev_flux_inner = elms(137).toDouble
        val gcmodel_dev_mag_inner = elms(138).toFloat
        val gcmodel_dev_ellipse_11 = elms(139).toFloat
        val gcmodel_dev_ellipse_22 = elms(140).toFloat
        val gcmodel_dev_ellipse_12 = elms(141).toFloat
        val gcmodel_dev_objective = elms(142).toFloat
        val gcmodel_dev_nonlinear0 = elms(143).toFloat
        val gcmodel_dev_nonlinear1 = elms(144).toFloat
        val gcmodel_dev_nonlinear2 = elms(145).toFloat
        val gcmodel_dev_fixed0 = elms(146).toFloat
        val gcmodel_dev_fixed1 = elms(147).toFloat
        val gcmodel_dev_niter = elms(148).toInt
        val gcmodel_dev_time = elms(149).toFloat
        val gcmodel_center_ra = elms(150).toDouble
        val gcmodel_center_dec = elms(151).toDouble
        val gcmodel_flux = elms(152).toDouble
        val gcmodel_mag = elms(153).toFloat
        val gcmodel_flux_err = elms(154).toDouble
        val gcmodel_mag_err = elms(155).toFloat
        val gcmodel_flux_inner = elms(156).toDouble
        val gcmodel_mag_inner = elms(157).toFloat
        val gcmodel_fracdev = elms(158).toFloat
        val gcmodel_objective = elms(159).toFloat
        val gcmodel_ellipse_11 = elms(160).toFloat
        val gcmodel_ellipse_22 = elms(161).toFloat
        val gcmodel_ellipse_12 = elms(162).toFloat
        val gcmodel_region_initial_ellipse_11 = elms(163).toFloat
        val gcmodel_region_initial_ellipse_22 = elms(164).toFloat
        val gcmodel_region_initial_ellipse_12 = elms(165).toFloat
        val gcmodel_region_final_ellipse_11 = elms(166).toFloat
        val gcmodel_region_final_ellipse_22 = elms(167).toFloat
        val gcmodel_region_final_ellipse_12 = elms(168).toFloat
        val gcmodel_dev_flux_apcorr = elms(169).toFloat
        val gcmodel_dev_flux_apcorr_err = elms(170).toFloat
        val gcmodel_exp_flux_apcorr = elms(171).toFloat
        val gcmodel_exp_flux_apcorr_err = elms(172).toFloat
        val gcmodel_flux_apcorr = elms(173).toFloat
        val gcmodel_flux_apcorr_err = elms(174).toFloat
        val gcmodel_initial_flux_flags = elms(175)
        val gcmodel_initial_flags_trsmall = elms(176)
        val gcmodel_initial_flags_maxiter = elms(177)
        val gcmodel_initial_flags_numericerror = elms(178)
        val gcmodel_exp_flux_flags = elms(179)
        val gcmodel_exp_flags_trsmall = elms(180)
        val gcmodel_exp_flags_maxiter = elms(181)
        val gcmodel_exp_flags_numericerror = elms(182)
        val gcmodel_dev_flux_flags = elms(183)
        val gcmodel_dev_flags_trsmall = elms(184)
        val gcmodel_dev_flags_maxiter = elms(185)
        val gcmodel_dev_flags_numericerror = elms(186)
        val gcmodel_flux_flags = elms(187)
        val gcmodel_flags_region_maxarea = elms(188)
        val gcmodel_flags_region_maxbadpixelfraction = elms(189)
        val gcmodel_flags_region_usedfootprintarea = elms(190)
        val gcmodel_flags_region_usedpsfarea = elms(191)
        val gcmodel_flags_region_usedinitialellipsemin = elms(192)
        val gcmodel_flags_region_usedinitialellipsemax = elms(193)
        val gcmodel_flags_noshape = elms(194)
        val gcmodel_flags_smallshape = elms(195)
        val gcmodel_flags_nopsf = elms(196)
        val gcmodel_flags_nowcs = elms(197)
        val gcmodel_flags_nocalib = elms(198)
        val gcmodel_flags_badcentroid = elms(199)
        val gcmodel_dev_flux_flags_apcorr = elms(200)
        val gcmodel_exp_flux_flags_apcorr = elms(201)
        val gcmodel_flux_flags_apcorr = elms(202)
        val gdeblend_psf_center_ra = elms(203).toDouble
        val gdeblend_psf_center_dec = elms(204).toDouble
        val gdeblend_psf_flux = elms(205).toDouble
        val gdeblend_psf_mag = elms(206).toFloat
        val gblendedness_old = elms(207).toFloat
        val gblendedness_raw_flux = elms(208).toFloat
        val gblendedness_raw_flux_child = elms(209).toDouble
        val gblendedness_raw_mag_child = elms(210).toFloat
        val gblendedness_raw_flux_parent = elms(211).toDouble
        val gblendedness_raw_mag_parent = elms(212).toFloat
        val gblendedness_abs_flux = elms(213).toFloat
        val gblendedness_abs_flux_child = elms(214).toDouble
        val gblendedness_abs_mag_child = elms(215).toFloat
        val gblendedness_abs_flux_parent = elms(216).toDouble
        val gblendedness_abs_mag_parent = elms(217).toFloat
        val gblendedness_raw_shape_child_11 = elms(218).toFloat
        val gblendedness_raw_shape_child_22 = elms(219).toFloat
        val gblendedness_raw_shape_child_12 = elms(220).toFloat
        val gblendedness_raw_shape_parent_11 = elms(221).toFloat
        val gblendedness_raw_shape_parent_22 = elms(222).toFloat
        val gblendedness_raw_shape_parent_12 = elms(223).toFloat
        val gblendedness_abs_shape_child_11 = elms(224).toFloat
        val gblendedness_abs_shape_child_22 = elms(225).toFloat
        val gblendedness_abs_shape_child_12 = elms(226).toFloat
        val gblendedness_abs_shape_parent_11 = elms(227).toFloat
        val gblendedness_abs_shape_parent_22 = elms(228).toFloat
        val gblendedness_abs_shape_parent_12 = elms(229).toFloat
        val gdeblend_deblended_as_psf = elms(230)
        val gdeblend_too_many_peaks = elms(231)
        val gdeblend_parent_too_big = elms(232)
        val gdeblend_masked = elms(233)
        val gdeblend_skipped = elms(234)
        val gdeblend_ramped_template = elms(235)
        val gdeblend_patched_template = elms(236)
        val gdeblend_has_stray_flux = elms(237)
        val gblendedness_flags = elms(238)
        val gblendedness_flags_nocentroid = elms(239)
        val gblendedness_flags_noshape = elms(240)
        val gcountinputs = elms(241).toInt
        val gclassification_extendedness = elms(242).toFloat
        val gflags_negative = elms(243)
        val gflags_badcentroid = elms(244)
        val gflags_pixel_edge = elms(245)
        val gflags_pixel_interpolated_any = elms(246)
        val gflags_pixel_interpolated_center = elms(247)
        val gflags_pixel_saturated_any = elms(248)
        val gflags_pixel_saturated_center = elms(249)
        val gflags_pixel_cr_any = elms(250)
        val gflags_pixel_cr_center = elms(251)
        val gflags_pixel_bad = elms(252)
        val gflags_pixel_suspect_any = elms(253)
        val gflags_pixel_suspect_center = elms(254)
        val gflags_pixel_offimage = elms(255)
        val gflags_pixel_bright_object_center = elms(256)
        val gflags_pixel_clipped_any = elms(257)
        val gflags_pixel_bright_object_any = elms(258)
        val gdetect_is_patch_inner = elms(259)
        val gdetect_is_tract_inner = elms(260)
        val gdetect_is_primary = elms(261)
        val gcalib_psf_candidate = elms(262)
        val gcalib_psf_used = elms(263)
        val rflux_naive = elms(264).toDouble
        val rmag_naive = elms(265).toFloat
        val rflux_naive_err = elms(266).toDouble
        val rmag_naive_err = elms(267).toFloat
        val rflux_naive_flags = elms(268)
        val rflux_sinc = elms(269).toDouble
        val rmag_sinc = elms(270).toFloat
        val rflux_sinc_err = elms(271).toDouble
        val rmag_sinc_err = elms(272).toFloat
        val rflux_sinc_flags = elms(273)
        val rflux_psf = elms(274).toDouble
        val rmag_psf = elms(275).toFloat
        val rflux_psf_err = elms(276).toDouble
        val rmag_psf_err = elms(277).toFloat
        val rflux_psf_apcorr = elms(278).toFloat
        val rflux_psf_apcorr_err = elms(279).toFloat
        val rflux_psf_flags = elms(280)
        val rflux_psf_flags_apcorr = elms(281)
        val rflux_kron = elms(282).toDouble
        val rmag_kron = elms(283).toFloat
        val rflux_kron_err = elms(284).toDouble
        val rmag_kron_err = elms(285).toFloat
        val rflux_kron_radius = elms(286).toFloat
        val rflux_kron_radiusforradius = elms(287).toFloat
        val rflux_kron_psfradius = elms(288).toFloat
        val rflux_kron_apcorr = elms(289).toFloat
        val rflux_kron_apcorr_err = elms(290).toFloat
        val rflux_kron_flags = elms(291)
        val rflux_kron_flags_edge = elms(292)
        val rflux_kron_flags_radius = elms(293)
        val rflux_kron_flags_smallradius = elms(294)
        val rflux_kron_flags_usedminimumradius = elms(295)
        val rflux_kron_flags_usedpsfradius = elms(296)
        val rflux_kron_flags_badshape = elms(297)
        val rflux_kron_flags_apcorr = elms(298)
        val rflux_gaussian = elms(299).toDouble
        val rmag_gaussian = elms(300).toFloat
        val rflux_gaussian_err = elms(301).toDouble
        val rmag_gaussian_err = elms(302).toFloat
        val rflux_gaussian_apcorr = elms(303).toFloat
        val rflux_gaussian_apcorr_err = elms(304).toFloat
        val rflux_gaussian_flags = elms(305)
        val rflux_gaussian_flags_apcorr = elms(306)
        val rcmodel_initial_flux = elms(307).toDouble
        val rcmodel_initial_mag = elms(308).toFloat
        val rcmodel_initial_flux_err = elms(309).toDouble
        val rcmodel_initial_mag_err = elms(310).toFloat
        val rcmodel_initial_flux_inner = elms(311).toDouble
        val rcmodel_initial_mag_inner = elms(312).toFloat
        val rcmodel_initial_ellipse_11 = elms(313).toFloat
        val rcmodel_initial_ellipse_22 = elms(314).toFloat
        val rcmodel_initial_ellipse_12 = elms(315).toFloat
        val rcmodel_initial_objective = elms(316).toFloat
        val rcmodel_initial_nonlinear0 = elms(317).toFloat
        val rcmodel_initial_nonlinear1 = elms(318).toFloat
        val rcmodel_initial_nonlinear2 = elms(319).toFloat
        val rcmodel_initial_fixed0 = elms(320).toFloat
        val rcmodel_initial_fixed1 = elms(321).toFloat
        val rcmodel_initial_niter = elms(322).toInt
        val rcmodel_initial_time = elms(323).toFloat
        val rcmodel_exp_flux = elms(324).toDouble
        val rcmodel_exp_mag = elms(325).toFloat
        val rcmodel_exp_flux_err = elms(326).toDouble
        val rcmodel_exp_mag_err = elms(327).toFloat
        val rcmodel_exp_flux_inner = elms(328).toDouble
        val rcmodel_exp_mag_inner = elms(329).toFloat
        val rcmodel_exp_ellipse_11 = elms(330).toFloat
        val rcmodel_exp_ellipse_22 = elms(331).toFloat
        val rcmodel_exp_ellipse_12 = elms(332).toFloat
        val rcmodel_exp_objective = elms(333).toFloat
        val rcmodel_exp_nonlinear0 = elms(334).toFloat
        val rcmodel_exp_nonlinear1 = elms(335).toFloat
        val rcmodel_exp_nonlinear2 = elms(336).toFloat
        val rcmodel_exp_fixed0 = elms(337).toFloat
        val rcmodel_exp_fixed1 = elms(338).toFloat
        val rcmodel_exp_niter = elms(339).toInt
        val rcmodel_exp_time = elms(340).toFloat
        val rcmodel_dev_flux = elms(341).toDouble
        val rcmodel_dev_mag = elms(342).toFloat
        val rcmodel_dev_flux_err = elms(343).toDouble
        val rcmodel_dev_mag_err = elms(344).toFloat
        val rcmodel_dev_flux_inner = elms(345).toDouble
        val rcmodel_dev_mag_inner = elms(346).toFloat
        val rcmodel_dev_ellipse_11 = elms(347).toFloat
        val rcmodel_dev_ellipse_22 = elms(348).toFloat
        val rcmodel_dev_ellipse_12 = elms(349).toFloat
        val rcmodel_dev_objective = elms(350).toFloat
        val rcmodel_dev_nonlinear0 = elms(351).toFloat
        val rcmodel_dev_nonlinear1 = elms(352).toFloat
        val rcmodel_dev_nonlinear2 = elms(353).toFloat
        val rcmodel_dev_fixed0 = elms(354).toFloat
        val rcmodel_dev_fixed1 = elms(355).toFloat
        val rcmodel_dev_niter = elms(356).toInt
        val rcmodel_dev_time = elms(357).toFloat
        val rcmodel_center_ra = elms(358).toDouble
        val rcmodel_center_dec = elms(359).toDouble
        val rcmodel_flux = elms(360).toDouble
        val rcmodel_mag = elms(361).toFloat
        val rcmodel_flux_err = elms(362).toDouble
        val rcmodel_mag_err = elms(363).toFloat
        val rcmodel_flux_inner = elms(364).toDouble
        val rcmodel_mag_inner = elms(365).toFloat
        val rcmodel_fracdev = elms(366).toFloat
        val rcmodel_objective = elms(367).toFloat
        val rcmodel_ellipse_11 = elms(368).toFloat
        val rcmodel_ellipse_22 = elms(369).toFloat
        val rcmodel_ellipse_12 = elms(370).toFloat
        val rcmodel_region_initial_ellipse_11 = elms(371).toFloat
        val rcmodel_region_initial_ellipse_22 = elms(372).toFloat
        val rcmodel_region_initial_ellipse_12 = elms(373).toFloat
        val rcmodel_region_final_ellipse_11 = elms(374).toFloat
        val rcmodel_region_final_ellipse_22 = elms(375).toFloat
        val rcmodel_region_final_ellipse_12 = elms(376).toFloat
        val rcmodel_dev_flux_apcorr = elms(377).toFloat
        val rcmodel_dev_flux_apcorr_err = elms(378).toFloat
        val rcmodel_exp_flux_apcorr = elms(379).toFloat
        val rcmodel_exp_flux_apcorr_err = elms(380).toFloat
        val rcmodel_flux_apcorr = elms(381).toFloat
        val rcmodel_flux_apcorr_err = elms(382).toFloat
        val rcmodel_initial_flux_flags = elms(383)
        val rcmodel_initial_flags_trsmall = elms(384)
        val rcmodel_initial_flags_maxiter = elms(385)
        val rcmodel_initial_flags_numericerror = elms(386)
        val rcmodel_exp_flux_flags = elms(387)
        val rcmodel_exp_flags_trsmall = elms(388)
        val rcmodel_exp_flags_maxiter = elms(389)
        val rcmodel_exp_flags_numericerror = elms(390)
        val rcmodel_dev_flux_flags = elms(391)
        val rcmodel_dev_flags_trsmall = elms(392)
        val rcmodel_dev_flags_maxiter = elms(393)
        val rcmodel_dev_flags_numericerror = elms(394)
        val rcmodel_flux_flags = elms(395)
        val rcmodel_flags_region_maxarea = elms(396)
        val rcmodel_flags_region_maxbadpixelfraction = elms(397)
        val rcmodel_flags_region_usedfootprintarea = elms(398)
        val rcmodel_flags_region_usedpsfarea = elms(399)
        val rcmodel_flags_region_usedinitialellipsemin = elms(400)
        val rcmodel_flags_region_usedinitialellipsemax = elms(401)
        val rcmodel_flags_noshape = elms(402)
        val rcmodel_flags_smallshape = elms(403)
        val rcmodel_flags_nopsf = elms(404)
        val rcmodel_flags_nowcs = elms(405)
        val rcmodel_flags_nocalib = elms(406)
        val rcmodel_flags_badcentroid = elms(407)
        val rcmodel_dev_flux_flags_apcorr = elms(408)
        val rcmodel_exp_flux_flags_apcorr = elms(409)
        val rcmodel_flux_flags_apcorr = elms(410)
        val rdeblend_psf_center_ra = elms(411).toDouble
        val rdeblend_psf_center_dec = elms(412).toDouble
        val rdeblend_psf_flux = elms(413).toDouble
        val rdeblend_psf_mag = elms(414).toFloat
        val rblendedness_old = elms(415).toFloat
        val rblendedness_raw_flux = elms(416).toFloat
        val rblendedness_raw_flux_child = elms(417).toDouble
        val rblendedness_raw_mag_child = elms(418).toFloat
        val rblendedness_raw_flux_parent = elms(419).toDouble
        val rblendedness_raw_mag_parent = elms(420).toFloat
        val rblendedness_abs_flux = elms(421).toFloat
        val rblendedness_abs_flux_child = elms(422).toDouble
        val rblendedness_abs_mag_child = elms(423).toFloat
        val rblendedness_abs_flux_parent = elms(424).toDouble
        val rblendedness_abs_mag_parent = elms(425).toFloat
        val rblendedness_raw_shape_child_11 = elms(426).toFloat
        val rblendedness_raw_shape_child_22 = elms(427).toFloat
        val rblendedness_raw_shape_child_12 = elms(428).toFloat
        val rblendedness_raw_shape_parent_11 = elms(429).toFloat
        val rblendedness_raw_shape_parent_22 = elms(430).toFloat
        val rblendedness_raw_shape_parent_12 = elms(431).toFloat
        val rblendedness_abs_shape_child_11 = elms(432).toFloat
        val rblendedness_abs_shape_child_22 = elms(433).toFloat
        val rblendedness_abs_shape_child_12 = elms(434).toFloat
        val rblendedness_abs_shape_parent_11 = elms(435).toFloat
        val rblendedness_abs_shape_parent_22 = elms(436).toFloat
        val rblendedness_abs_shape_parent_12 = elms(437).toFloat
        val rdeblend_deblended_as_psf = elms(438)
        val rdeblend_too_many_peaks = elms(439)
        val rdeblend_parent_too_big = elms(440)
        val rdeblend_masked = elms(441)
        val rdeblend_skipped = elms(442)
        val rdeblend_ramped_template = elms(443)
        val rdeblend_patched_template = elms(444)
        val rdeblend_has_stray_flux = elms(445)
        val rblendedness_flags = elms(446)
        val rblendedness_flags_nocentroid = elms(447)
        val rblendedness_flags_noshape = elms(448)
        val rcountinputs = elms(449).toInt
        val rclassification_extendedness = elms(450).toFloat
        val rflags_negative = elms(451)
        val rflags_badcentroid = elms(452)
        val rflags_pixel_edge = elms(453)
        val rflags_pixel_interpolated_any = elms(454)
        val rflags_pixel_interpolated_center = elms(455)
        val rflags_pixel_saturated_any = elms(456)
        val rflags_pixel_saturated_center = elms(457)
        val rflags_pixel_cr_any = elms(458)
        val rflags_pixel_cr_center = elms(459)
        val rflags_pixel_bad = elms(460)
        val rflags_pixel_suspect_any = elms(461)
        val rflags_pixel_suspect_center = elms(462)
        val rflags_pixel_offimage = elms(463)
        val rflags_pixel_bright_object_center = elms(464)
        val rflags_pixel_clipped_any = elms(465)
        val rflags_pixel_bright_object_any = elms(466)
        val rdetect_is_patch_inner = elms(467)
        val rdetect_is_tract_inner = elms(468)
        val rdetect_is_primary = elms(469)
        val rcalib_psf_candidate = elms(470)
        val rcalib_psf_used = elms(471)
        val iflux_naive = elms(472).toDouble
        val imag_naive = elms(473).toFloat
        val iflux_naive_err = elms(474).toDouble
        val imag_naive_err = elms(475).toFloat
        val iflux_naive_flags = elms(476)
        val iflux_sinc = elms(477).toDouble
        val imag_sinc = elms(478).toFloat
        val iflux_sinc_err = elms(479).toDouble
        val imag_sinc_err = elms(480).toFloat
        val iflux_sinc_flags = elms(481)
        val iflux_psf = elms(482).toDouble
        val imag_psf = elms(483).toFloat
        val iflux_psf_err = elms(484).toDouble
        val imag_psf_err = elms(485).toFloat
        val iflux_psf_apcorr = elms(486).toFloat
        val iflux_psf_apcorr_err = elms(487).toFloat
        val iflux_psf_flags = elms(488)
        val iflux_psf_flags_apcorr = elms(489)
        val iflux_kron = elms(490).toDouble
        val imag_kron = elms(491).toFloat
        val iflux_kron_err = elms(492).toDouble
        val imag_kron_err = elms(493).toFloat
        val iflux_kron_radius = elms(494).toFloat
        val iflux_kron_radiusforradius = elms(495).toFloat
        val iflux_kron_psfradius = elms(496).toFloat
        val iflux_kron_apcorr = elms(497).toFloat
        val iflux_kron_apcorr_err = elms(498).toFloat
        val iflux_kron_flags = elms(499)
        val iflux_kron_flags_edge = elms(500)
        val iflux_kron_flags_radius = elms(501)
        val iflux_kron_flags_smallradius = elms(502)
        val iflux_kron_flags_usedminimumradius = elms(503)
        val iflux_kron_flags_usedpsfradius = elms(504)
        val iflux_kron_flags_badshape = elms(505)
        val iflux_kron_flags_apcorr = elms(506)
        val iflux_gaussian = elms(507).toDouble
        val imag_gaussian = elms(508).toFloat
        val iflux_gaussian_err = elms(509).toDouble
        val imag_gaussian_err = elms(510).toFloat
        val iflux_gaussian_apcorr = elms(511).toFloat
        val iflux_gaussian_apcorr_err = elms(512).toFloat
        val iflux_gaussian_flags = elms(513)
        val iflux_gaussian_flags_apcorr = elms(514)
        val icmodel_initial_flux = elms(515).toDouble
        val icmodel_initial_mag = elms(516).toFloat
        val icmodel_initial_flux_err = elms(517).toDouble
        val icmodel_initial_mag_err = elms(518).toFloat
        val icmodel_initial_flux_inner = elms(519).toDouble
        val icmodel_initial_mag_inner = elms(520).toFloat
        val icmodel_initial_ellipse_11 = elms(521).toFloat
        val icmodel_initial_ellipse_22 = elms(522).toFloat
        val icmodel_initial_ellipse_12 = elms(523).toFloat
        val icmodel_initial_objective = elms(524).toFloat
        val icmodel_initial_nonlinear0 = elms(525).toFloat
        val icmodel_initial_nonlinear1 = elms(526).toFloat
        val icmodel_initial_nonlinear2 = elms(527).toFloat
        val icmodel_initial_fixed0 = elms(528).toFloat
        val icmodel_initial_fixed1 = elms(529).toFloat
        val icmodel_initial_niter = elms(530).toInt
        val icmodel_initial_time = elms(531).toFloat
        val icmodel_exp_flux = elms(532).toDouble
        val icmodel_exp_mag = elms(533).toFloat
        val icmodel_exp_flux_err = elms(534).toDouble
        val icmodel_exp_mag_err = elms(535).toFloat
        val icmodel_exp_flux_inner = elms(536).toDouble
        val icmodel_exp_mag_inner = elms(537).toFloat
        val icmodel_exp_ellipse_11 = elms(538).toFloat
        val icmodel_exp_ellipse_22 = elms(539).toFloat
        val icmodel_exp_ellipse_12 = elms(540).toFloat
        val icmodel_exp_objective = elms(541).toFloat
        val icmodel_exp_nonlinear0 = elms(542).toFloat
        val icmodel_exp_nonlinear1 = elms(543).toFloat
        val icmodel_exp_nonlinear2 = elms(544).toFloat
        val icmodel_exp_fixed0 = elms(545).toFloat
        val icmodel_exp_fixed1 = elms(546).toFloat
        val icmodel_exp_niter = elms(547).toInt
        val icmodel_exp_time = elms(548).toFloat
        val icmodel_dev_flux = elms(549).toDouble
        val icmodel_dev_mag = elms(550).toFloat
        val icmodel_dev_flux_err = elms(551).toDouble
        val icmodel_dev_mag_err = elms(552).toFloat
        val icmodel_dev_flux_inner = elms(553).toDouble
        val icmodel_dev_mag_inner = elms(554).toFloat
        val icmodel_dev_ellipse_11 = elms(555).toFloat
        val icmodel_dev_ellipse_22 = elms(556).toFloat
        val icmodel_dev_ellipse_12 = elms(557).toFloat
        val icmodel_dev_objective = elms(558).toFloat
        val icmodel_dev_nonlinear0 = elms(559).toFloat
        val icmodel_dev_nonlinear1 = elms(560).toFloat
        val icmodel_dev_nonlinear2 = elms(561).toFloat
        val icmodel_dev_fixed0 = elms(562).toFloat
        val icmodel_dev_fixed1 = elms(563).toFloat
        val icmodel_dev_niter = elms(564).toInt
        val icmodel_dev_time = elms(565).toFloat
        val icmodel_center_ra = elms(566).toDouble
        val icmodel_center_dec = elms(567).toDouble
        val icmodel_flux = elms(568).toDouble
        val icmodel_mag = elms(569).toFloat
        val icmodel_flux_err = elms(570).toDouble
        val icmodel_mag_err = elms(571).toFloat
        val icmodel_flux_inner = elms(572).toDouble
        val icmodel_mag_inner = elms(573).toFloat
        val icmodel_fracdev = elms(574).toFloat
        val icmodel_objective = elms(575).toFloat
        val icmodel_ellipse_11 = elms(576).toFloat
        val icmodel_ellipse_22 = elms(577).toFloat
        val icmodel_ellipse_12 = elms(578).toFloat
        val icmodel_region_initial_ellipse_11 = elms(579).toFloat
        val icmodel_region_initial_ellipse_22 = elms(580).toFloat
        val icmodel_region_initial_ellipse_12 = elms(581).toFloat
        val icmodel_region_final_ellipse_11 = elms(582).toFloat
        val icmodel_region_final_ellipse_22 = elms(583).toFloat
        val icmodel_region_final_ellipse_12 = elms(584).toFloat
        val icmodel_dev_flux_apcorr = elms(585).toFloat
        val icmodel_dev_flux_apcorr_err = elms(586).toFloat
        val icmodel_exp_flux_apcorr = elms(587).toFloat
        val icmodel_exp_flux_apcorr_err = elms(588).toFloat
        val icmodel_flux_apcorr = elms(589).toFloat
        val icmodel_flux_apcorr_err = elms(590).toFloat
        val icmodel_initial_flux_flags = elms(591)
        val icmodel_initial_flags_trsmall = elms(592)
        val icmodel_initial_flags_maxiter = elms(593)
        val icmodel_initial_flags_numericerror = elms(594)
        val icmodel_exp_flux_flags = elms(595)
        val icmodel_exp_flags_trsmall = elms(596)
        val icmodel_exp_flags_maxiter = elms(597)
        val icmodel_exp_flags_numericerror = elms(598)
        val icmodel_dev_flux_flags = elms(599)
        val icmodel_dev_flags_trsmall = elms(600)
        val icmodel_dev_flags_maxiter = elms(601)
        val icmodel_dev_flags_numericerror = elms(602)
        val icmodel_flux_flags = elms(603)
        val icmodel_flags_region_maxarea = elms(604)
        val icmodel_flags_region_maxbadpixelfraction = elms(605)
        val icmodel_flags_region_usedfootprintarea = elms(606)
        val icmodel_flags_region_usedpsfarea = elms(607)
        val icmodel_flags_region_usedinitialellipsemin = elms(608)
        val icmodel_flags_region_usedinitialellipsemax = elms(609)
        val icmodel_flags_noshape = elms(610)
        val icmodel_flags_smallshape = elms(611)
        val icmodel_flags_nopsf = elms(612)
        val icmodel_flags_nowcs = elms(613)
        val icmodel_flags_nocalib = elms(614)
        val icmodel_flags_badcentroid = elms(615)
        val icmodel_dev_flux_flags_apcorr = elms(616)
        val icmodel_exp_flux_flags_apcorr = elms(617)
        val icmodel_flux_flags_apcorr = elms(618)
        val ideblend_psf_center_ra = elms(619).toDouble
        val ideblend_psf_center_dec = elms(620).toDouble
        val ideblend_psf_flux = elms(621).toDouble
        val ideblend_psf_mag = elms(622).toFloat
        val iblendedness_old = elms(623).toFloat
        val iblendedness_raw_flux = elms(624).toFloat
        val iblendedness_raw_flux_child = elms(625).toDouble
        val iblendedness_raw_mag_child = elms(626).toFloat
        val iblendedness_raw_flux_parent = elms(627).toDouble
        val iblendedness_raw_mag_parent = elms(628).toFloat
        val iblendedness_abs_flux = elms(629).toFloat
        val iblendedness_abs_flux_child = elms(630).toDouble
        val iblendedness_abs_mag_child = elms(631).toFloat
        val iblendedness_abs_flux_parent = elms(632).toDouble
        val iblendedness_abs_mag_parent = elms(633).toFloat
        val iblendedness_raw_shape_child_11 = elms(634).toFloat
        val iblendedness_raw_shape_child_22 = elms(635).toFloat
        val iblendedness_raw_shape_child_12 = elms(636).toFloat
        val iblendedness_raw_shape_parent_11 = elms(637).toFloat
        val iblendedness_raw_shape_parent_22 = elms(638).toFloat
        val iblendedness_raw_shape_parent_12 = elms(639).toFloat
        val iblendedness_abs_shape_child_11 = elms(640).toFloat
        val iblendedness_abs_shape_child_22 = elms(641).toFloat
        val iblendedness_abs_shape_child_12 = elms(642).toFloat
        val iblendedness_abs_shape_parent_11 = elms(643).toFloat
        val iblendedness_abs_shape_parent_22 = elms(644).toFloat
        val iblendedness_abs_shape_parent_12 = elms(645).toFloat
        val ideblend_deblended_as_psf = elms(646)
        val ideblend_too_many_peaks = elms(647)
        val ideblend_parent_too_big = elms(648)
        val ideblend_masked = elms(649)
        val ideblend_skipped = elms(650)
        val ideblend_ramped_template = elms(651)
        val ideblend_patched_template = elms(652)
        val ideblend_has_stray_flux = elms(653)
        val iblendedness_flags = elms(654)
        val iblendedness_flags_nocentroid = elms(655)
        val iblendedness_flags_noshape = elms(656)
        val icountinputs = elms(657).toInt
        val iclassification_extendedness = elms(658).toFloat
        val iflags_negative = elms(659)
        val iflags_badcentroid = elms(660)
        val iflags_pixel_edge = elms(661)
        val iflags_pixel_interpolated_any = elms(662)
        val iflags_pixel_interpolated_center = elms(663)
        val iflags_pixel_saturated_any = elms(664)
        val iflags_pixel_saturated_center = elms(665)
        val iflags_pixel_cr_any = elms(666)
        val iflags_pixel_cr_center = elms(667)
        val iflags_pixel_bad = elms(668)
        val iflags_pixel_suspect_any = elms(669)
        val iflags_pixel_suspect_center = elms(670)
        val iflags_pixel_offimage = elms(671)
        val iflags_pixel_bright_object_center = elms(672)
        val iflags_pixel_clipped_any = elms(673)
        val iflags_pixel_bright_object_any = elms(674)
        val idetect_is_patch_inner = elms(675)
        val idetect_is_tract_inner = elms(676)
        val idetect_is_primary = elms(677)
        val icalib_psf_candidate = elms(678)
        val icalib_psf_used = elms(679)
        val zflux_naive = elms(680).toDouble
        val zmag_naive = elms(681).toFloat
        val zflux_naive_err = elms(682).toDouble
        val zmag_naive_err = elms(683).toFloat
        val zflux_naive_flags = elms(684)
        val zflux_sinc = elms(685).toDouble
        val zmag_sinc = elms(686).toFloat
        val zflux_sinc_err = elms(687).toDouble
        val zmag_sinc_err = elms(688).toFloat
        val zflux_sinc_flags = elms(689)
        val zflux_psf = elms(690).toDouble
        val zmag_psf = elms(691).toFloat
        val zflux_psf_err = elms(692).toDouble
        val zmag_psf_err = elms(693).toFloat
        val zflux_psf_apcorr = elms(694).toFloat
        val zflux_psf_apcorr_err = elms(695).toFloat
        val zflux_psf_flags = elms(696)
        val zflux_psf_flags_apcorr = elms(697)
        val zflux_kron = elms(698).toDouble
        val zmag_kron = elms(699).toFloat
        val zflux_kron_err = elms(700).toDouble
        val zmag_kron_err = elms(701).toFloat
        val zflux_kron_radius = elms(702).toFloat
        val zflux_kron_radiusforradius = elms(703).toFloat
        val zflux_kron_psfradius = elms(704).toFloat
        val zflux_kron_apcorr = elms(705).toFloat
        val zflux_kron_apcorr_err = elms(706).toFloat
        val zflux_kron_flags = elms(707)
        val zflux_kron_flags_edge = elms(708)
        val zflux_kron_flags_radius = elms(709)
        val zflux_kron_flags_smallradius = elms(710)
        val zflux_kron_flags_usedminimumradius = elms(711)
        val zflux_kron_flags_usedpsfradius = elms(712)
        val zflux_kron_flags_badshape = elms(713)
        val zflux_kron_flags_apcorr = elms(714)
        val zflux_gaussian = elms(715).toDouble
        val zmag_gaussian = elms(716).toFloat
        val zflux_gaussian_err = elms(717).toDouble
        val zmag_gaussian_err = elms(718).toFloat
        val zflux_gaussian_apcorr = elms(719).toFloat
        val zflux_gaussian_apcorr_err = elms(720).toFloat
        val zflux_gaussian_flags = elms(721)
        val zflux_gaussian_flags_apcorr = elms(722)
        val zcmodel_initial_flux = elms(723).toDouble
        val zcmodel_initial_mag = elms(724).toFloat
        val zcmodel_initial_flux_err = elms(725).toDouble
        val zcmodel_initial_mag_err = elms(726).toFloat
        val zcmodel_initial_flux_inner = elms(727).toDouble
        val zcmodel_initial_mag_inner = elms(728).toFloat
        val zcmodel_initial_ellipse_11 = elms(729).toFloat
        val zcmodel_initial_ellipse_22 = elms(730).toFloat
        val zcmodel_initial_ellipse_12 = elms(731).toFloat
        val zcmodel_initial_objective = elms(732).toFloat
        val zcmodel_initial_nonlinear0 = elms(733).toFloat
        val zcmodel_initial_nonlinear1 = elms(734).toFloat
        val zcmodel_initial_nonlinear2 = elms(735).toFloat
        val zcmodel_initial_fixed0 = elms(736).toFloat
        val zcmodel_initial_fixed1 = elms(737).toFloat
        val zcmodel_initial_niter = elms(738).toInt
        val zcmodel_initial_time = elms(739).toFloat
        val zcmodel_exp_flux = elms(740).toDouble
        val zcmodel_exp_mag = elms(741).toFloat
        val zcmodel_exp_flux_err = elms(742).toDouble
        val zcmodel_exp_mag_err = elms(743).toFloat
        val zcmodel_exp_flux_inner = elms(744).toDouble
        val zcmodel_exp_mag_inner = elms(745).toFloat
        val zcmodel_exp_ellipse_11 = elms(746).toFloat
        val zcmodel_exp_ellipse_22 = elms(747).toFloat
        val zcmodel_exp_ellipse_12 = elms(748).toFloat
        val zcmodel_exp_objective = elms(749).toFloat
        val zcmodel_exp_nonlinear0 = elms(750).toFloat
        val zcmodel_exp_nonlinear1 = elms(751).toFloat
        val zcmodel_exp_nonlinear2 = elms(752).toFloat
        val zcmodel_exp_fixed0 = elms(753).toFloat
        val zcmodel_exp_fixed1 = elms(754).toFloat
        val zcmodel_exp_niter = elms(755).toInt
        val zcmodel_exp_time = elms(756).toFloat
        val zcmodel_dev_flux = elms(757).toDouble
        val zcmodel_dev_mag = elms(758).toFloat
        val zcmodel_dev_flux_err = elms(759).toDouble
        val zcmodel_dev_mag_err = elms(760).toFloat
        val zcmodel_dev_flux_inner = elms(761).toDouble
        val zcmodel_dev_mag_inner = elms(762).toFloat
        val zcmodel_dev_ellipse_11 = elms(763).toFloat
        val zcmodel_dev_ellipse_22 = elms(764).toFloat
        val zcmodel_dev_ellipse_12 = elms(765).toFloat
        val zcmodel_dev_objective = elms(766).toFloat
        val zcmodel_dev_nonlinear0 = elms(767).toFloat
        val zcmodel_dev_nonlinear1 = elms(768).toFloat
        val zcmodel_dev_nonlinear2 = elms(769).toFloat
        val zcmodel_dev_fixed0 = elms(770).toFloat
        val zcmodel_dev_fixed1 = elms(771).toFloat
        val zcmodel_dev_niter = elms(772).toInt
        val zcmodel_dev_time = elms(773).toFloat
        val zcmodel_center_ra = elms(774).toDouble
        val zcmodel_center_dec = elms(775).toDouble
        val zcmodel_flux = elms(776).toDouble
        val zcmodel_mag = elms(777).toFloat
        val zcmodel_flux_err = elms(778).toDouble
        val zcmodel_mag_err = elms(779).toFloat
        val zcmodel_flux_inner = elms(780).toDouble
        val zcmodel_mag_inner = elms(781).toFloat
        val zcmodel_fracdev = elms(782).toFloat
        val zcmodel_objective = elms(783).toFloat
        val zcmodel_ellipse_11 = elms(784).toFloat
        val zcmodel_ellipse_22 = elms(785).toFloat
        val zcmodel_ellipse_12 = elms(786).toFloat
        val zcmodel_region_initial_ellipse_11 = elms(787).toFloat
        val zcmodel_region_initial_ellipse_22 = elms(788).toFloat
        val zcmodel_region_initial_ellipse_12 = elms(789).toFloat
        val zcmodel_region_final_ellipse_11 = elms(790).toFloat
        val zcmodel_region_final_ellipse_22 = elms(791).toFloat
        val zcmodel_region_final_ellipse_12 = elms(792).toFloat
        val zcmodel_dev_flux_apcorr = elms(793).toFloat
        val zcmodel_dev_flux_apcorr_err = elms(794).toFloat
        val zcmodel_exp_flux_apcorr = elms(795).toFloat
        val zcmodel_exp_flux_apcorr_err = elms(796).toFloat
        val zcmodel_flux_apcorr = elms(797).toFloat
        val zcmodel_flux_apcorr_err = elms(798).toFloat
        val zcmodel_initial_flux_flags = elms(799)
        val zcmodel_initial_flags_trsmall = elms(800)
        val zcmodel_initial_flags_maxiter = elms(801)
        val zcmodel_initial_flags_numericerror = elms(802)
        val zcmodel_exp_flux_flags = elms(803)
        val zcmodel_exp_flags_trsmall = elms(804)
        val zcmodel_exp_flags_maxiter = elms(805)
        val zcmodel_exp_flags_numericerror = elms(806)
        val zcmodel_dev_flux_flags = elms(807)
        val zcmodel_dev_flags_trsmall = elms(808)
        val zcmodel_dev_flags_maxiter = elms(809)
        val zcmodel_dev_flags_numericerror = elms(810)
        val zcmodel_flux_flags = elms(811)
        val zcmodel_flags_region_maxarea = elms(812)
        val zcmodel_flags_region_maxbadpixelfraction = elms(813)
        val zcmodel_flags_region_usedfootprintarea = elms(814)
        val zcmodel_flags_region_usedpsfarea = elms(815)
        val zcmodel_flags_region_usedinitialellipsemin = elms(816)
        val zcmodel_flags_region_usedinitialellipsemax = elms(817)
        val zcmodel_flags_noshape = elms(818)
        val zcmodel_flags_smallshape = elms(819)
        val zcmodel_flags_nopsf = elms(820)
        val zcmodel_flags_nowcs = elms(821)
        val zcmodel_flags_nocalib = elms(822)
        val zcmodel_flags_badcentroid = elms(823)
        val zcmodel_dev_flux_flags_apcorr = elms(824)
        val zcmodel_exp_flux_flags_apcorr = elms(825)
        val zcmodel_flux_flags_apcorr = elms(826)
        val zdeblend_psf_center_ra = elms(827).toDouble
        val zdeblend_psf_center_dec = elms(828).toDouble
        val zdeblend_psf_flux = elms(829).toDouble
        val zdeblend_psf_mag = elms(830).toFloat
        val zblendedness_old = elms(831).toFloat
        val zblendedness_raw_flux = elms(832).toFloat
        val zblendedness_raw_flux_child = elms(833).toDouble
        val zblendedness_raw_mag_child = elms(834).toFloat
        val zblendedness_raw_flux_parent = elms(835).toDouble
        val zblendedness_raw_mag_parent = elms(836).toFloat
        val zblendedness_abs_flux = elms(837).toFloat
        val zblendedness_abs_flux_child = elms(838).toDouble
        val zblendedness_abs_mag_child = elms(839).toFloat
        val zblendedness_abs_flux_parent = elms(840).toDouble
        val zblendedness_abs_mag_parent = elms(841).toFloat
        val zblendedness_raw_shape_child_11 = elms(842).toFloat
        val zblendedness_raw_shape_child_22 = elms(843).toFloat
        val zblendedness_raw_shape_child_12 = elms(844).toFloat
        val zblendedness_raw_shape_parent_11 = elms(845).toFloat
        val zblendedness_raw_shape_parent_22 = elms(846).toFloat
        val zblendedness_raw_shape_parent_12 = elms(847).toFloat
        val zblendedness_abs_shape_child_11 = elms(848).toFloat
        val zblendedness_abs_shape_child_22 = elms(849).toFloat
        val zblendedness_abs_shape_child_12 = elms(850).toFloat
        val zblendedness_abs_shape_parent_11 = elms(851).toFloat
        val zblendedness_abs_shape_parent_22 = elms(852).toFloat
        val zblendedness_abs_shape_parent_12 = elms(853).toFloat
        val zdeblend_deblended_as_psf = elms(854)
        val zdeblend_too_many_peaks = elms(855)
        val zdeblend_parent_too_big = elms(856)
        val zdeblend_masked = elms(857)
        val zdeblend_skipped = elms(858)
        val zdeblend_ramped_template = elms(859)
        val zdeblend_patched_template = elms(860)
        val zdeblend_has_stray_flux = elms(861)
        val zblendedness_flags = elms(862)
        val zblendedness_flags_nocentroid = elms(863)
        val zblendedness_flags_noshape = elms(864)
        val zcountinputs = elms(865).toInt
        val zclassification_extendedness = elms(866).toFloat
        val zflags_negative = elms(867)
        val zflags_badcentroid = elms(868)
        val zflags_pixel_edge = elms(869)
        val zflags_pixel_interpolated_any = elms(870)
        val zflags_pixel_interpolated_center = elms(871)
        val zflags_pixel_saturated_any = elms(872)
        val zflags_pixel_saturated_center = elms(873)
        val zflags_pixel_cr_any = elms(874)
        val zflags_pixel_cr_center = elms(875)
        val zflags_pixel_bad = elms(876)
        val zflags_pixel_suspect_any = elms(877)
        val zflags_pixel_suspect_center = elms(878)
        val zflags_pixel_offimage = elms(879)
        val zflags_pixel_bright_object_center = elms(880)
        val zflags_pixel_clipped_any = elms(881)
        val zflags_pixel_bright_object_any = elms(882)
        val zdetect_is_patch_inner = elms(883)
        val zdetect_is_tract_inner = elms(884)
        val zdetect_is_primary = elms(885)
        val zcalib_psf_candidate = elms(886)
        val zcalib_psf_used = elms(887)
        val yflux_naive = elms(888).toDouble
        val ymag_naive = elms(889).toFloat
        val yflux_naive_err = elms(890).toDouble
        val ymag_naive_err = elms(891).toFloat
        val yflux_naive_flags = elms(892)
        val yflux_sinc = elms(893).toDouble
        val ymag_sinc = elms(894).toFloat
        val yflux_sinc_err = elms(895).toDouble
        val ymag_sinc_err = elms(896).toFloat
        val yflux_sinc_flags = elms(897)
        val yflux_psf = elms(898).toDouble
        val ymag_psf = elms(899).toFloat
        val yflux_psf_err = elms(900).toDouble
        val ymag_psf_err = elms(901).toFloat
        val yflux_psf_apcorr = elms(902).toFloat
        val yflux_psf_apcorr_err = elms(903).toFloat
        val yflux_psf_flags = elms(904)
        val yflux_psf_flags_apcorr = elms(905)
        val yflux_kron = elms(906).toDouble
        val ymag_kron = elms(907).toFloat
        val yflux_kron_err = elms(908).toDouble
        val ymag_kron_err = elms(909).toFloat
        val yflux_kron_radius = elms(910).toFloat
        val yflux_kron_radiusforradius = elms(911).toFloat
        val yflux_kron_psfradius = elms(912).toFloat
        val yflux_kron_apcorr = elms(913).toFloat
        val yflux_kron_apcorr_err = elms(914).toFloat
        val yflux_kron_flags = elms(915)
        val yflux_kron_flags_edge = elms(916)
        val yflux_kron_flags_radius = elms(917)
        val yflux_kron_flags_smallradius = elms(918)
        val yflux_kron_flags_usedminimumradius = elms(919)
        val yflux_kron_flags_usedpsfradius = elms(920)
        val yflux_kron_flags_badshape = elms(921)
        val yflux_kron_flags_apcorr = elms(922)
        val yflux_gaussian = elms(923).toDouble
        val ymag_gaussian = elms(924).toFloat
        val yflux_gaussian_err = elms(925).toDouble
        val ymag_gaussian_err = elms(926).toFloat
        val yflux_gaussian_apcorr = elms(927).toFloat
        val yflux_gaussian_apcorr_err = elms(928).toFloat
        val yflux_gaussian_flags = elms(929)
        val yflux_gaussian_flags_apcorr = elms(930)
        val ycmodel_initial_flux = elms(931).toDouble
        val ycmodel_initial_mag = elms(932).toFloat
        val ycmodel_initial_flux_err = elms(933).toDouble
        val ycmodel_initial_mag_err = elms(934).toFloat
        val ycmodel_initial_flux_inner = elms(935).toDouble
        val ycmodel_initial_mag_inner = elms(936).toFloat
        val ycmodel_initial_ellipse_11 = elms(937).toFloat
        val ycmodel_initial_ellipse_22 = elms(938).toFloat
        val ycmodel_initial_ellipse_12 = elms(939).toFloat
        val ycmodel_initial_objective = elms(940).toFloat
        val ycmodel_initial_nonlinear0 = elms(941).toFloat
        val ycmodel_initial_nonlinear1 = elms(942).toFloat
        val ycmodel_initial_nonlinear2 = elms(943).toFloat
        val ycmodel_initial_fixed0 = elms(944).toFloat
        val ycmodel_initial_fixed1 = elms(945).toFloat
        val ycmodel_initial_niter = elms(946).toInt
        val ycmodel_initial_time = elms(947).toFloat
        val ycmodel_exp_flux = elms(948).toDouble
        val ycmodel_exp_mag = elms(949).toFloat
        val ycmodel_exp_flux_err = elms(950).toDouble
        val ycmodel_exp_mag_err = elms(951).toFloat
        val ycmodel_exp_flux_inner = elms(952).toDouble
        val ycmodel_exp_mag_inner = elms(953).toFloat
        val ycmodel_exp_ellipse_11 = elms(954).toFloat
        val ycmodel_exp_ellipse_22 = elms(955).toFloat
        val ycmodel_exp_ellipse_12 = elms(956).toFloat
        val ycmodel_exp_objective = elms(957).toFloat
        val ycmodel_exp_nonlinear0 = elms(958).toFloat
        val ycmodel_exp_nonlinear1 = elms(959).toFloat
        val ycmodel_exp_nonlinear2 = elms(960).toFloat
        val ycmodel_exp_fixed0 = elms(961).toFloat
        val ycmodel_exp_fixed1 = elms(962).toFloat
        val ycmodel_exp_niter = elms(963).toInt
        val ycmodel_exp_time = elms(964).toFloat
        val ycmodel_dev_flux = elms(965).toDouble
        val ycmodel_dev_mag = elms(966).toFloat
        val ycmodel_dev_flux_err = elms(967).toDouble
        val ycmodel_dev_mag_err = elms(968).toFloat
        val ycmodel_dev_flux_inner = elms(969).toDouble
        val ycmodel_dev_mag_inner = elms(970).toFloat
        val ycmodel_dev_ellipse_11 = elms(971).toFloat
        val ycmodel_dev_ellipse_22 = elms(972).toFloat
        val ycmodel_dev_ellipse_12 = elms(973).toFloat
        val ycmodel_dev_objective = elms(974).toFloat
        val ycmodel_dev_nonlinear0 = elms(975).toFloat
        val ycmodel_dev_nonlinear1 = elms(976).toFloat
        val ycmodel_dev_nonlinear2 = elms(977).toFloat
        val ycmodel_dev_fixed0 = elms(978).toFloat
        val ycmodel_dev_fixed1 = elms(979).toFloat
        val ycmodel_dev_niter = elms(980).toInt
        val ycmodel_dev_time = elms(981).toFloat
        val ycmodel_center_ra = elms(982).toDouble
        val ycmodel_center_dec = elms(983).toDouble
        val ycmodel_flux = elms(984).toDouble
        val ycmodel_mag = elms(985).toFloat
        val ycmodel_flux_err = elms(986).toDouble
        val ycmodel_mag_err = elms(987).toFloat
        val ycmodel_flux_inner = elms(988).toDouble
        val ycmodel_mag_inner = elms(989).toFloat
        val ycmodel_fracdev = elms(990).toFloat
        val ycmodel_objective = elms(991).toFloat
        val ycmodel_ellipse_11 = elms(992).toFloat
        val ycmodel_ellipse_22 = elms(993).toFloat
        val ycmodel_ellipse_12 = elms(994).toFloat
        val ycmodel_region_initial_ellipse_11 = elms(995).toFloat
        val ycmodel_region_initial_ellipse_22 = elms(996).toFloat
        val ycmodel_region_initial_ellipse_12 = elms(997).toFloat
        val ycmodel_region_final_ellipse_11 = elms(998).toFloat
        val ycmodel_region_final_ellipse_22 = elms(999).toFloat
        val ycmodel_region_final_ellipse_12 = elms(1000).toFloat
        val ycmodel_dev_flux_apcorr = elms(1001).toFloat
        val ycmodel_dev_flux_apcorr_err = elms(1002).toFloat
        val ycmodel_exp_flux_apcorr = elms(1003).toFloat
        val ycmodel_exp_flux_apcorr_err = elms(1004).toFloat
        val ycmodel_flux_apcorr = elms(1005).toFloat
        val ycmodel_flux_apcorr_err = elms(1006).toFloat
        val ycmodel_initial_flux_flags = elms(1007)
        val ycmodel_initial_flags_trsmall = elms(1008)
        val ycmodel_initial_flags_maxiter = elms(1009)
        val ycmodel_initial_flags_numericerror = elms(1010)
        val ycmodel_exp_flux_flags = elms(1011)
        val ycmodel_exp_flags_trsmall = elms(1012)
        val ycmodel_exp_flags_maxiter = elms(1013)
        val ycmodel_exp_flags_numericerror = elms(1014)
        val ycmodel_dev_flux_flags = elms(1015)
        val ycmodel_dev_flags_trsmall = elms(1016)
        val ycmodel_dev_flags_maxiter = elms(1017)
        val ycmodel_dev_flags_numericerror = elms(1018)
        val ycmodel_flux_flags = elms(1019)
        val ycmodel_flags_region_maxarea = elms(1020)
        val ycmodel_flags_region_maxbadpixelfraction = elms(1021)
        val ycmodel_flags_region_usedfootprintarea = elms(1022)
        val ycmodel_flags_region_usedpsfarea = elms(1023)
        val ycmodel_flags_region_usedinitialellipsemin = elms(1024)
        val ycmodel_flags_region_usedinitialellipsemax = elms(1025)
        val ycmodel_flags_noshape = elms(1026)
        val ycmodel_flags_smallshape = elms(1027)
        val ycmodel_flags_nopsf = elms(1028)
        val ycmodel_flags_nowcs = elms(1029)
        val ycmodel_flags_nocalib = elms(1030)
        val ycmodel_flags_badcentroid = elms(1031)
        val ycmodel_dev_flux_flags_apcorr = elms(1032)
        val ycmodel_exp_flux_flags_apcorr = elms(1033)
        val ycmodel_flux_flags_apcorr = elms(1034)
        val ydeblend_psf_center_ra = elms(1035).toDouble
        val ydeblend_psf_center_dec = elms(1036).toDouble
        val ydeblend_psf_flux = elms(1037).toDouble
        val ydeblend_psf_mag = elms(1038).toFloat
        val yblendedness_old = elms(1039).toFloat
        val yblendedness_raw_flux = elms(1040).toFloat
        val yblendedness_raw_flux_child = elms(1041).toDouble
        val yblendedness_raw_mag_child = elms(1042).toFloat
        val yblendedness_raw_flux_parent = elms(1043).toDouble
        val yblendedness_raw_mag_parent = elms(1044).toFloat
        val yblendedness_abs_flux = elms(1045).toFloat
        val yblendedness_abs_flux_child = elms(1046).toDouble
        val yblendedness_abs_mag_child = elms(1047).toFloat
        val yblendedness_abs_flux_parent = elms(1048).toDouble
        val yblendedness_abs_mag_parent = elms(1049).toFloat
        val yblendedness_raw_shape_child_11 = elms(1050).toFloat
        val yblendedness_raw_shape_child_22 = elms(1051).toFloat
        val yblendedness_raw_shape_child_12 = elms(1052).toFloat
        val yblendedness_raw_shape_parent_11 = elms(1053).toFloat
        val yblendedness_raw_shape_parent_22 = elms(1054).toFloat
        val yblendedness_raw_shape_parent_12 = elms(1055).toFloat
        val yblendedness_abs_shape_child_11 = elms(1056).toFloat
        val yblendedness_abs_shape_child_22 = elms(1057).toFloat
        val yblendedness_abs_shape_child_12 = elms(1058).toFloat
        val yblendedness_abs_shape_parent_11 = elms(1059).toFloat
        val yblendedness_abs_shape_parent_22 = elms(1060).toFloat
        val yblendedness_abs_shape_parent_12 = elms(1061).toFloat
        val ydeblend_deblended_as_psf = elms(1062)
        val ydeblend_too_many_peaks = elms(1063)
        val ydeblend_parent_too_big = elms(1064)
        val ydeblend_masked = elms(1065)
        val ydeblend_skipped = elms(1066)
        val ydeblend_ramped_template = elms(1067)
        val ydeblend_patched_template = elms(1068)
        val ydeblend_has_stray_flux = elms(1069)
        val yblendedness_flags = elms(1070)
        val yblendedness_flags_nocentroid = elms(1071)
        val yblendedness_flags_noshape = elms(1072)
        val ycountinputs = elms(1073).toInt
        val yclassification_extendedness = elms(1074).toFloat
        val yflags_negative = elms(1075)
        val yflags_badcentroid = elms(1076)
        val yflags_pixel_edge = elms(1077)
        val yflags_pixel_interpolated_any = elms(1078)
        val yflags_pixel_interpolated_center = elms(1079)
        val yflags_pixel_saturated_any = elms(1080)
        val yflags_pixel_saturated_center = elms(1081)
        val yflags_pixel_cr_any = elms(1082)
        val yflags_pixel_cr_center = elms(1083)
        val yflags_pixel_bad = elms(1084)
        val yflags_pixel_suspect_any = elms(1085)
        val yflags_pixel_suspect_center = elms(1086)
        val yflags_pixel_offimage = elms(1087)
        val yflags_pixel_bright_object_center = elms(1088)
        val yflags_pixel_clipped_any = elms(1089)
        val yflags_pixel_bright_object_any = elms(1090)
        val ydetect_is_patch_inner = elms(1091)
        val ydetect_is_tract_inner = elms(1092)
        val ydetect_is_primary = elms(1093)
        val ycalib_psf_candidate = elms(1094)
        val ycalib_psf_used = elms(1095)
        (
          object_id
          , gra, gdec, gcoord, rra, rdec, rcoord, ira, idec, icoord, zra, zdec, zcoord, yra, ydec, ycoord
          , skymap_id, tract, patch, patch_s, parent_id bigint, deblend_nchild
          , merge_footprint_i2, merge_footprint_i, merge_footprint_r, merge_footprint_z, merge_footprint_y, merge_footprint_g, merge_footprint_n921, merge_footprint_n816, merge_footprint_n1010, merge_footprint_n387, merge_footprint_n515, merge_footprint_sky
          , merge_peak_i2, merge_peak_i, merge_peak_r, merge_peak_z, merge_peak_y, merge_peak_g, merge_peak_n921, merge_peak_n816, merge_peak_n1010, merge_peak_n387, merge_peak_n515, merge_peak_sky
          , gflux_naive, gmag_naive, gflux_naive_err, gmag_naive_err, gflux_naive_flags, gflux_sinc, gmag_sinc, gflux_sinc_err, gmag_sinc_err, gflux_sinc_flags, gflux_psf, gmag_psf, gflux_psf_err, gmag_psf_err
          , gflux_psf_apcorr, gflux_psf_apcorr_err, gflux_psf_flags, gflux_psf_flags_apcorr, gflux_kron
          , gmag_kron, gflux_kron_err, gmag_kron_err, gflux_kron_radius, gflux_kron_radiusforradius, gflux_kron_psfradius, gflux_kron_apcorr, gflux_kron_apcorr_err, gflux_kron_flags, gflux_kron_flags_edge, gflux_kron_flags_radius, gflux_kron_flags_smallradius, gflux_kron_flags_usedminimumradius, gflux_kron_flags_usedpsfradius, gflux_kron_flags_badshape, gflux_kron_flags_apcorr, gflux_gaussian, gmag_gaussian, gflux_gaussian_err, gmag_gaussian_err, gflux_gaussian_apcorr, gflux_gaussian_apcorr_err, gflux_gaussian_flags, gflux_gaussian_flags_apcorr
          , gcmodel_initial_flux, gcmodel_initial_mag, gcmodel_initial_flux_err, gcmodel_initial_mag_err, gcmodel_initial_flux_inner, gcmodel_initial_mag_inner, gcmodel_initial_ellipse_11, gcmodel_initial_ellipse_22, gcmodel_initial_ellipse_12, gcmodel_initial_objective, gcmodel_initial_nonlinear0, gcmodel_initial_nonlinear1, gcmodel_initial_nonlinear2, gcmodel_initial_fixed0, gcmodel_initial_fixed1, gcmodel_initial_niter, gcmodel_initial_time, gcmodel_exp_flux, gcmodel_exp_mag, gcmodel_exp_flux_err, gcmodel_exp_mag_err, gcmodel_exp_flux_inner, gcmodel_exp_mag_inner, gcmodel_exp_ellipse_11, gcmodel_exp_ellipse_22, gcmodel_exp_ellipse_12, gcmodel_exp_objective, gcmodel_exp_nonlinear0, gcmodel_exp_nonlinear1, gcmodel_exp_nonlinear2, gcmodel_exp_fixed0, gcmodel_exp_fixed1, gcmodel_exp_niter, gcmodel_exp_time, gcmodel_dev_flux, gcmodel_dev_mag, gcmodel_dev_flux_err, gcmodel_dev_mag_err, gcmodel_dev_flux_inner, gcmodel_dev_mag_inner, gcmodel_dev_ellipse_11, gcmodel_dev_ellipse_22, gcmodel_dev_ellipse_12, gcmodel_dev_objective, gcmodel_dev_nonlinear0, gcmodel_dev_nonlinear1, gcmodel_dev_nonlinear2, gcmodel_dev_fixed0, gcmodel_dev_fixed1, gcmodel_dev_niter, gcmodel_dev_time, gcmodel_center_ra, gcmodel_center_dec, gcmodel_flux, gcmodel_mag, gcmodel_flux_err, gcmodel_mag_err, gcmodel_flux_inner, gcmodel_mag_inner, gcmodel_fracdev, gcmodel_objective, gcmodel_ellipse_11, gcmodel_ellipse_22, gcmodel_ellipse_12, gcmodel_region_initial_ellipse_11, gcmodel_region_initial_ellipse_22, gcmodel_region_initial_ellipse_12, gcmodel_region_final_ellipse_11, gcmodel_region_final_ellipse_22, gcmodel_region_final_ellipse_12, gcmodel_dev_flux_apcorr, gcmodel_dev_flux_apcorr_err, gcmodel_exp_flux_apcorr, gcmodel_exp_flux_apcorr_err, gcmodel_flux_apcorr, gcmodel_flux_apcorr_err, gcmodel_initial_flux_flags, gcmodel_initial_flags_trsmall, gcmodel_initial_flags_maxiter, gcmodel_initial_flags_numericerror, gcmodel_exp_flux_flags, gcmodel_exp_flags_trsmall, gcmodel_exp_flags_maxiter, gcmodel_exp_flags_numericerror, gcmodel_dev_flux_flags, gcmodel_dev_flags_trsmall, gcmodel_dev_flags_maxiter, gcmodel_dev_flags_numericerror, gcmodel_flux_flags, gcmodel_flags_region_maxarea, gcmodel_flags_region_maxbadpixelfraction, gcmodel_flags_region_usedfootprintarea, gcmodel_flags_region_usedpsfarea, gcmodel_flags_region_usedinitialellipsemin, gcmodel_flags_region_usedinitialellipsemax, gcmodel_flags_noshape, gcmodel_flags_smallshape, gcmodel_flags_nopsf, gcmodel_flags_nowcs, gcmodel_flags_nocalib, gcmodel_flags_badcentroid, gcmodel_dev_flux_flags_apcorr, gcmodel_exp_flux_flags_apcorr, gcmodel_flux_flags_apcorr
          , gdeblend_psf_center_ra, gdeblend_psf_center_dec, gdeblend_psf_flux, gdeblend_psf_mag
          , gblendedness_old, gblendedness_raw_flux, gblendedness_raw_flux_child, gblendedness_raw_mag_child, gblendedness_raw_flux_parent, gblendedness_raw_mag_parent, gblendedness_abs_flux, gblendedness_abs_flux_child, gblendedness_abs_mag_child, gblendedness_abs_flux_parent, gblendedness_abs_mag_parent, gblendedness_raw_shape_child_11, gblendedness_raw_shape_child_22, gblendedness_raw_shape_child_12, gblendedness_raw_shape_parent_11, gblendedness_raw_shape_parent_22, gblendedness_raw_shape_parent_12, gblendedness_abs_shape_child_11, gblendedness_abs_shape_child_22, gblendedness_abs_shape_child_12, gblendedness_abs_shape_parent_11, gblendedness_abs_shape_parent_22, gblendedness_abs_shape_parent_12
          , gdeblend_deblended_as_psf, gdeblend_too_many_peaks, gdeblend_parent_too_big, gdeblend_masked, gdeblend_skipped, gdeblend_ramped_template, gdeblend_patched_template, gdeblend_has_stray_flux
          , gblendedness_flags, gblendedness_flags_nocentroid, gblendedness_flags_noshape
          , gcountinputs smallint, gclassification_extendedness
          , gflags_negative, gflags_badcentroid, gflags_pixel_edge, gflags_pixel_interpolated_any, gflags_pixel_interpolated_center, gflags_pixel_saturated_any, gflags_pixel_saturated_center, gflags_pixel_cr_any, gflags_pixel_cr_center, gflags_pixel_bad, gflags_pixel_suspect_any, gflags_pixel_suspect_center, gflags_pixel_offimage, gflags_pixel_bright_object_center, gflags_pixel_clipped_any, gflags_pixel_bright_object_any
          , gdetect_is_patch_inner, gdetect_is_tract_inner, gdetect_is_primary
          , gcalib_psf_candidate, gcalib_psf_used
          , rflux_naive, rmag_naive, rflux_naive_err, rmag_naive_err, rflux_naive_flags, rflux_sinc, rmag_sinc, rflux_sinc_err, rmag_sinc_err, rflux_sinc_flags, rflux_psf, rmag_psf, rflux_psf_err, rmag_psf_err, rflux_psf_apcorr, rflux_psf_apcorr_err, rflux_psf_flags, rflux_psf_flags_apcorr, rflux_kron, rmag_kron, rflux_kron_err, rmag_kron_err, rflux_kron_radius, rflux_kron_radiusforradius, rflux_kron_psfradius, rflux_kron_apcorr, rflux_kron_apcorr_err, rflux_kron_flags, rflux_kron_flags_edge, rflux_kron_flags_radius, rflux_kron_flags_smallradius, rflux_kron_flags_usedminimumradius, rflux_kron_flags_usedpsfradius, rflux_kron_flags_badshape, rflux_kron_flags_apcorr, rflux_gaussian, rmag_gaussian, rflux_gaussian_err, rmag_gaussian_err
          , rflux_gaussian_apcorr, rflux_gaussian_apcorr_err, rflux_gaussian_flags, rflux_gaussian_flags_apcorr
          , rcmodel_initial_flux, rcmodel_initial_mag, rcmodel_initial_flux_err, rcmodel_initial_mag_err, rcmodel_initial_flux_inner, rcmodel_initial_mag_inner, rcmodel_initial_ellipse_11, rcmodel_initial_ellipse_22, rcmodel_initial_ellipse_12, rcmodel_initial_objective, rcmodel_initial_nonlinear0, rcmodel_initial_nonlinear1, rcmodel_initial_nonlinear2, rcmodel_initial_fixed0, rcmodel_initial_fixed1, rcmodel_initial_niter, rcmodel_initial_time, rcmodel_exp_flux, rcmodel_exp_mag, rcmodel_exp_flux_err, rcmodel_exp_mag_err, rcmodel_exp_flux_inner, rcmodel_exp_mag_inner, rcmodel_exp_ellipse_11, rcmodel_exp_ellipse_22, rcmodel_exp_ellipse_12, rcmodel_exp_objective, rcmodel_exp_nonlinear0, rcmodel_exp_nonlinear1, rcmodel_exp_nonlinear2, rcmodel_exp_fixed0, rcmodel_exp_fixed1, rcmodel_exp_niter, rcmodel_exp_time, rcmodel_dev_flux, rcmodel_dev_mag, rcmodel_dev_flux_err, rcmodel_dev_mag_err, rcmodel_dev_flux_inner, rcmodel_dev_mag_inner, rcmodel_dev_ellipse_11, rcmodel_dev_ellipse_22, rcmodel_dev_ellipse_12, rcmodel_dev_objective, rcmodel_dev_nonlinear0, rcmodel_dev_nonlinear1, rcmodel_dev_nonlinear2, rcmodel_dev_fixed0, rcmodel_dev_fixed1, rcmodel_dev_niter, rcmodel_dev_time, rcmodel_center_ra, rcmodel_center_dec, rcmodel_flux, rcmodel_mag, rcmodel_flux_err, rcmodel_mag_err, rcmodel_flux_inner, rcmodel_mag_inner, rcmodel_fracdev, rcmodel_objective, rcmodel_ellipse_11, rcmodel_ellipse_22, rcmodel_ellipse_12, rcmodel_region_initial_ellipse_11, rcmodel_region_initial_ellipse_22, rcmodel_region_initial_ellipse_12, rcmodel_region_final_ellipse_11, rcmodel_region_final_ellipse_22, rcmodel_region_final_ellipse_12, rcmodel_dev_flux_apcorr, rcmodel_dev_flux_apcorr_err, rcmodel_exp_flux_apcorr, rcmodel_exp_flux_apcorr_err, rcmodel_flux_apcorr, rcmodel_flux_apcorr_err, rcmodel_initial_flux_flags, rcmodel_initial_flags_trsmall, rcmodel_initial_flags_maxiter, rcmodel_initial_flags_numericerror, rcmodel_exp_flux_flags, rcmodel_exp_flags_trsmall, rcmodel_exp_flags_maxiter, rcmodel_exp_flags_numericerror, rcmodel_dev_flux_flags, rcmodel_dev_flags_trsmall, rcmodel_dev_flags_maxiter, rcmodel_dev_flags_numericerror, rcmodel_flux_flags, rcmodel_flags_region_maxarea, rcmodel_flags_region_maxbadpixelfraction, rcmodel_flags_region_usedfootprintarea, rcmodel_flags_region_usedpsfarea, rcmodel_flags_region_usedinitialellipsemin, rcmodel_flags_region_usedinitialellipsemax, rcmodel_flags_noshape, rcmodel_flags_smallshape, rcmodel_flags_nopsf, rcmodel_flags_nowcs, rcmodel_flags_nocalib, rcmodel_flags_badcentroid, rcmodel_dev_flux_flags_apcorr, rcmodel_exp_flux_flags_apcorr, rcmodel_flux_flags_apcorr
          , rdeblend_psf_center_ra, rdeblend_psf_center_dec, rdeblend_psf_flux, rdeblend_psf_mag
          , rblendedness_old, rblendedness_raw_flux, rblendedness_raw_flux_child, rblendedness_raw_mag_child, rblendedness_raw_flux_parent, rblendedness_raw_mag_parent, rblendedness_abs_flux, rblendedness_abs_flux_child, rblendedness_abs_mag_child, rblendedness_abs_flux_parent, rblendedness_abs_mag_parent, rblendedness_raw_shape_child_11, rblendedness_raw_shape_child_22, rblendedness_raw_shape_child_12, rblendedness_raw_shape_parent_11, rblendedness_raw_shape_parent_22, rblendedness_raw_shape_parent_12, rblendedness_abs_shape_child_11, rblendedness_abs_shape_child_22, rblendedness_abs_shape_child_12, rblendedness_abs_shape_parent_11, rblendedness_abs_shape_parent_22, rblendedness_abs_shape_parent_12
          , rdeblend_deblended_as_psf, rdeblend_too_many_peaks, rdeblend_parent_too_big, rdeblend_masked, rdeblend_skipped, rdeblend_ramped_template, rdeblend_patched_template, rdeblend_has_stray_flux
          , rblendedness_flags, rblendedness_flags_nocentroid, rblendedness_flags_noshape
          , rcountinputs smallint, rclassification_extendedness
          , rflags_negative, rflags_badcentroid, rflags_pixel_edge, rflags_pixel_interpolated_any, rflags_pixel_interpolated_center, rflags_pixel_saturated_any, rflags_pixel_saturated_center, rflags_pixel_cr_any, rflags_pixel_cr_center, rflags_pixel_bad, rflags_pixel_suspect_any, rflags_pixel_suspect_center, rflags_pixel_offimage, rflags_pixel_bright_object_center, rflags_pixel_clipped_any, rflags_pixel_bright_object_any
          , rdetect_is_patch_inner, rdetect_is_tract_inner, rdetect_is_primary
          , rcalib_psf_candidate, rcalib_psf_used
          , iflux_naive, imag_naive, iflux_naive_err, imag_naive_err, iflux_naive_flags, iflux_sinc, imag_sinc, iflux_sinc_err, imag_sinc_err, iflux_sinc_flags, iflux_psf, imag_psf, iflux_psf_err, imag_psf_err, iflux_psf_apcorr, iflux_psf_apcorr_err, iflux_psf_flags, iflux_psf_flags_apcorr, iflux_kron, imag_kron, iflux_kron_err, imag_kron_err, iflux_kron_radius, iflux_kron_radiusforradius, iflux_kron_psfradius, iflux_kron_apcorr, iflux_kron_apcorr_err, iflux_kron_flags, iflux_kron_flags_edge, iflux_kron_flags_radius, iflux_kron_flags_smallradius, iflux_kron_flags_usedminimumradius, iflux_kron_flags_usedpsfradius, iflux_kron_flags_badshape, iflux_kron_flags_apcorr, iflux_gaussian, imag_gaussian, iflux_gaussian_err, imag_gaussian_err
          , iflux_gaussian_apcorr, iflux_gaussian_apcorr_err, iflux_gaussian_flags, iflux_gaussian_flags_apcorr
          , icmodel_initial_flux, icmodel_initial_mag, icmodel_initial_flux_err, icmodel_initial_mag_err, icmodel_initial_flux_inner, icmodel_initial_mag_inner, icmodel_initial_ellipse_11, icmodel_initial_ellipse_22, icmodel_initial_ellipse_12, icmodel_initial_objective, icmodel_initial_nonlinear0, icmodel_initial_nonlinear1, icmodel_initial_nonlinear2, icmodel_initial_fixed0, icmodel_initial_fixed1, icmodel_initial_niter, icmodel_initial_time, icmodel_exp_flux, icmodel_exp_mag, icmodel_exp_flux_err, icmodel_exp_mag_err, icmodel_exp_flux_inner, icmodel_exp_mag_inner, icmodel_exp_ellipse_11, icmodel_exp_ellipse_22, icmodel_exp_ellipse_12, icmodel_exp_objective, icmodel_exp_nonlinear0, icmodel_exp_nonlinear1, icmodel_exp_nonlinear2, icmodel_exp_fixed0, icmodel_exp_fixed1, icmodel_exp_niter, icmodel_exp_time, icmodel_dev_flux, icmodel_dev_mag, icmodel_dev_flux_err, icmodel_dev_mag_err, icmodel_dev_flux_inner, icmodel_dev_mag_inner, icmodel_dev_ellipse_11, icmodel_dev_ellipse_22, icmodel_dev_ellipse_12, icmodel_dev_objective, icmodel_dev_nonlinear0, icmodel_dev_nonlinear1, icmodel_dev_nonlinear2, icmodel_dev_fixed0, icmodel_dev_fixed1, icmodel_dev_niter, icmodel_dev_time, icmodel_center_ra, icmodel_center_dec, icmodel_flux, icmodel_mag, icmodel_flux_err, icmodel_mag_err, icmodel_flux_inner, icmodel_mag_inner, icmodel_fracdev, icmodel_objective, icmodel_ellipse_11, icmodel_ellipse_22, icmodel_ellipse_12, icmodel_region_initial_ellipse_11, icmodel_region_initial_ellipse_22, icmodel_region_initial_ellipse_12, icmodel_region_final_ellipse_11, icmodel_region_final_ellipse_22, icmodel_region_final_ellipse_12, icmodel_dev_flux_apcorr, icmodel_dev_flux_apcorr_err, icmodel_exp_flux_apcorr, icmodel_exp_flux_apcorr_err, icmodel_flux_apcorr, icmodel_flux_apcorr_err, icmodel_initial_flux_flags, icmodel_initial_flags_trsmall, icmodel_initial_flags_maxiter, icmodel_initial_flags_numericerror, icmodel_exp_flux_flags, icmodel_exp_flags_trsmall, icmodel_exp_flags_maxiter, icmodel_exp_flags_numericerror, icmodel_dev_flux_flags, icmodel_dev_flags_trsmall, icmodel_dev_flags_maxiter, icmodel_dev_flags_numericerror, icmodel_flux_flags, icmodel_flags_region_maxarea, icmodel_flags_region_maxbadpixelfraction, icmodel_flags_region_usedfootprintarea, icmodel_flags_region_usedpsfarea, icmodel_flags_region_usedinitialellipsemin, icmodel_flags_region_usedinitialellipsemax, icmodel_flags_noshape, icmodel_flags_smallshape, icmodel_flags_nopsf, icmodel_flags_nowcs, icmodel_flags_nocalib, icmodel_flags_badcentroid, icmodel_dev_flux_flags_apcorr, icmodel_exp_flux_flags_apcorr, icmodel_flux_flags_apcorr
          , ideblend_psf_center_ra, ideblend_psf_center_dec, ideblend_psf_flux, ideblend_psf_mag
          , iblendedness_old, iblendedness_raw_flux, iblendedness_raw_flux_child, iblendedness_raw_mag_child, iblendedness_raw_flux_parent, iblendedness_raw_mag_parent, iblendedness_abs_flux, iblendedness_abs_flux_child, iblendedness_abs_mag_child, iblendedness_abs_flux_parent, iblendedness_abs_mag_parent, iblendedness_raw_shape_child_11, iblendedness_raw_shape_child_22, iblendedness_raw_shape_child_12, iblendedness_raw_shape_parent_11, iblendedness_raw_shape_parent_22, iblendedness_raw_shape_parent_12, iblendedness_abs_shape_child_11, iblendedness_abs_shape_child_22, iblendedness_abs_shape_child_12, iblendedness_abs_shape_parent_11, iblendedness_abs_shape_parent_22, iblendedness_abs_shape_parent_12
          , ideblend_deblended_as_psf, ideblend_too_many_peaks, ideblend_parent_too_big, ideblend_masked, ideblend_skipped, ideblend_ramped_template, ideblend_patched_template, ideblend_has_stray_flux
          , iblendedness_flags, iblendedness_flags_nocentroid, iblendedness_flags_noshape
          , icountinputs smallint, iclassification_extendedness
          , iflags_negative, iflags_badcentroid, iflags_pixel_edge, iflags_pixel_interpolated_any, iflags_pixel_interpolated_center, iflags_pixel_saturated_any, iflags_pixel_saturated_center, iflags_pixel_cr_any, iflags_pixel_cr_center, iflags_pixel_bad, iflags_pixel_suspect_any, iflags_pixel_suspect_center, iflags_pixel_offimage, iflags_pixel_bright_object_center, iflags_pixel_clipped_any, iflags_pixel_bright_object_any
          , idetect_is_patch_inner, idetect_is_tract_inner, idetect_is_primary, icalib_psf_candidate, icalib_psf_used
          , zflux_naive, zmag_naive, zflux_naive_err, zmag_naive_err, zflux_naive_flags, zflux_sinc, zmag_sinc, zflux_sinc_err, zmag_sinc_err, zflux_sinc_flags, zflux_psf, zmag_psf, zflux_psf_err, zmag_psf_err, zflux_psf_apcorr, zflux_psf_apcorr_err, zflux_psf_flags, zflux_psf_flags_apcorr, zflux_kron, zmag_kron, zflux_kron_err, zmag_kron_err, zflux_kron_radius, zflux_kron_radiusforradius, zflux_kron_psfradius, zflux_kron_apcorr, zflux_kron_apcorr_err, zflux_kron_flags, zflux_kron_flags_edge, zflux_kron_flags_radius, zflux_kron_flags_smallradius, zflux_kron_flags_usedminimumradius, zflux_kron_flags_usedpsfradius, zflux_kron_flags_badshape, zflux_kron_flags_apcorr, zflux_gaussian, zmag_gaussian, zflux_gaussian_err, zmag_gaussian_err
          , zflux_gaussian_apcorr, zflux_gaussian_apcorr_err, zflux_gaussian_flags, zflux_gaussian_flags_apcorr
          , zcmodel_initial_flux, zcmodel_initial_mag, zcmodel_initial_flux_err, zcmodel_initial_mag_err, zcmodel_initial_flux_inner, zcmodel_initial_mag_inner, zcmodel_initial_ellipse_11, zcmodel_initial_ellipse_22, zcmodel_initial_ellipse_12, zcmodel_initial_objective, zcmodel_initial_nonlinear0, zcmodel_initial_nonlinear1, zcmodel_initial_nonlinear2, zcmodel_initial_fixed0, zcmodel_initial_fixed1, zcmodel_initial_niter, zcmodel_initial_time
          , zcmodel_exp_flux, zcmodel_exp_mag, zcmodel_exp_flux_err, zcmodel_exp_mag_err, zcmodel_exp_flux_inner, zcmodel_exp_mag_inner, zcmodel_exp_ellipse_11, zcmodel_exp_ellipse_22, zcmodel_exp_ellipse_12, zcmodel_exp_objective, zcmodel_exp_nonlinear0, zcmodel_exp_nonlinear1, zcmodel_exp_nonlinear2, zcmodel_exp_fixed0, zcmodel_exp_fixed1, zcmodel_exp_niter, zcmodel_exp_time
          , zcmodel_dev_flux, zcmodel_dev_mag, zcmodel_dev_flux_err, zcmodel_dev_mag_err, zcmodel_dev_flux_inner, zcmodel_dev_mag_inner, zcmodel_dev_ellipse_11, zcmodel_dev_ellipse_22, zcmodel_dev_ellipse_12, zcmodel_dev_objective, zcmodel_dev_nonlinear0, zcmodel_dev_nonlinear1, zcmodel_dev_nonlinear2, zcmodel_dev_fixed0, zcmodel_dev_fixed1, zcmodel_dev_niter, zcmodel_dev_time
          , zcmodel_center_ra, zcmodel_center_dec, zcmodel_flux, zcmodel_mag, zcmodel_flux_err, zcmodel_mag_err, zcmodel_flux_inner, zcmodel_mag_inner, zcmodel_fracdev, zcmodel_objective, zcmodel_ellipse_11, zcmodel_ellipse_22, zcmodel_ellipse_12
          , zcmodel_region_initial_ellipse_11, zcmodel_region_initial_ellipse_22, zcmodel_region_initial_ellipse_12, zcmodel_region_final_ellipse_11, zcmodel_region_final_ellipse_22, zcmodel_region_final_ellipse_12
          , zcmodel_dev_flux_apcorr, zcmodel_dev_flux_apcorr_err, zcmodel_exp_flux_apcorr, zcmodel_exp_flux_apcorr_err, zcmodel_flux_apcorr, zcmodel_flux_apcorr_err, zcmodel_initial_flux_flags, zcmodel_initial_flags_trsmall, zcmodel_initial_flags_maxiter, zcmodel_initial_flags_numericerror, zcmodel_exp_flux_flags, zcmodel_exp_flags_trsmall, zcmodel_exp_flags_maxiter, zcmodel_exp_flags_numericerror, zcmodel_dev_flux_flags, zcmodel_dev_flags_trsmall, zcmodel_dev_flags_maxiter, zcmodel_dev_flags_numericerror, zcmodel_flux_flags
          , zcmodel_flags_region_maxarea, zcmodel_flags_region_maxbadpixelfraction, zcmodel_flags_region_usedfootprintarea, zcmodel_flags_region_usedpsfarea, zcmodel_flags_region_usedinitialellipsemin, zcmodel_flags_region_usedinitialellipsemax, zcmodel_flags_noshape, zcmodel_flags_smallshape, zcmodel_flags_nopsf, zcmodel_flags_nowcs, zcmodel_flags_nocalib, zcmodel_flags_badcentroid, zcmodel_dev_flux_flags_apcorr, zcmodel_exp_flux_flags_apcorr, zcmodel_flux_flags_apcorr
          , zdeblend_psf_center_ra, zdeblend_psf_center_dec, zdeblend_psf_flux, zdeblend_psf_mag, zblendedness_old, zblendedness_raw_flux, zblendedness_raw_flux_child, zblendedness_raw_mag_child, zblendedness_raw_flux_parent, zblendedness_raw_mag_parent, zblendedness_abs_flux, zblendedness_abs_flux_child, zblendedness_abs_mag_child, zblendedness_abs_flux_parent, zblendedness_abs_mag_parent, zblendedness_raw_shape_child_11, zblendedness_raw_shape_child_22, zblendedness_raw_shape_child_12, zblendedness_raw_shape_parent_11, zblendedness_raw_shape_parent_22, zblendedness_raw_shape_parent_12, zblendedness_abs_shape_child_11, zblendedness_abs_shape_child_22, zblendedness_abs_shape_child_12, zblendedness_abs_shape_parent_11, zblendedness_abs_shape_parent_22, zblendedness_abs_shape_parent_12
          , zdeblend_deblended_as_psf, zdeblend_too_many_peaks, zdeblend_parent_too_big, zdeblend_masked, zdeblend_skipped, zdeblend_ramped_template, zdeblend_patched_template, zdeblend_has_stray_flux
          , zblendedness_flags, zblendedness_flags_nocentroid, zblendedness_flags_noshape
          , zcountinputs smallint, zclassification_extendedness
          , zflags_negative, zflags_badcentroid, zflags_pixel_edge, zflags_pixel_interpolated_any, zflags_pixel_interpolated_center, zflags_pixel_saturated_any, zflags_pixel_saturated_center, zflags_pixel_cr_any, zflags_pixel_cr_center, zflags_pixel_bad, zflags_pixel_suspect_any, zflags_pixel_suspect_center, zflags_pixel_offimage, zflags_pixel_bright_object_center, zflags_pixel_clipped_any, zflags_pixel_bright_object_any
          , zdetect_is_patch_inner, zdetect_is_tract_inner, zdetect_is_primary
          , zcalib_psf_candidate, zcalib_psf_used
          , yflux_naive, ymag_naive, yflux_naive_err, ymag_naive_err, yflux_naive_flags, yflux_sinc, ymag_sinc, yflux_sinc_err, ymag_sinc_err, yflux_sinc_flags, yflux_psf, ymag_psf, yflux_psf_err, ymag_psf_err, yflux_psf_apcorr, yflux_psf_apcorr_err, yflux_psf_flags, yflux_psf_flags_apcorr, yflux_kron, ymag_kron, yflux_kron_err, ymag_kron_err, yflux_kron_radius, yflux_kron_radiusforradius, yflux_kron_psfradius, yflux_kron_apcorr, yflux_kron_apcorr_err, yflux_kron_flags, yflux_kron_flags_edge, yflux_kron_flags_radius, yflux_kron_flags_smallradius, yflux_kron_flags_usedminimumradius, yflux_kron_flags_usedpsfradius, yflux_kron_flags_badshape, yflux_kron_flags_apcorr, yflux_gaussian
          , ymag_gaussian, yflux_gaussian_err, ymag_gaussian_err, yflux_gaussian_apcorr, yflux_gaussian_apcorr_err, yflux_gaussian_flags, yflux_gaussian_flags_apcorr
          , ycmodel_initial_flux, ycmodel_initial_mag, ycmodel_initial_flux_err, ycmodel_initial_mag_err, ycmodel_initial_flux_inner, ycmodel_initial_mag_inner, ycmodel_initial_ellipse_11, ycmodel_initial_ellipse_22, ycmodel_initial_ellipse_12, ycmodel_initial_objective, ycmodel_initial_nonlinear0, ycmodel_initial_nonlinear1, ycmodel_initial_nonlinear2, ycmodel_initial_fixed0, ycmodel_initial_fixed1, ycmodel_initial_niter, ycmodel_initial_time
          , ycmodel_exp_flux, ycmodel_exp_mag, ycmodel_exp_flux_err, ycmodel_exp_mag_err, ycmodel_exp_flux_inner, ycmodel_exp_mag_inner, ycmodel_exp_ellipse_11, ycmodel_exp_ellipse_22, ycmodel_exp_ellipse_12, ycmodel_exp_objective, ycmodel_exp_nonlinear0, ycmodel_exp_nonlinear1, ycmodel_exp_nonlinear2, ycmodel_exp_fixed0, ycmodel_exp_fixed1, ycmodel_exp_niter, ycmodel_exp_time, ycmodel_dev_flux, ycmodel_dev_mag, ycmodel_dev_flux_err, ycmodel_dev_mag_err, ycmodel_dev_flux_inner, ycmodel_dev_mag_inner, ycmodel_dev_ellipse_11, ycmodel_dev_ellipse_22, ycmodel_dev_ellipse_12, ycmodel_dev_objective, ycmodel_dev_nonlinear0, ycmodel_dev_nonlinear1, ycmodel_dev_nonlinear2, ycmodel_dev_fixed0, ycmodel_dev_fixed1, ycmodel_dev_niter, ycmodel_dev_time, ycmodel_center_ra, ycmodel_center_dec, ycmodel_flux, ycmodel_mag, ycmodel_flux_err, ycmodel_mag_err, ycmodel_flux_inner, ycmodel_mag_inner, ycmodel_fracdev, ycmodel_objective, ycmodel_ellipse_11, ycmodel_ellipse_22, ycmodel_ellipse_12, ycmodel_region_initial_ellipse_11, ycmodel_region_initial_ellipse_22, ycmodel_region_initial_ellipse_12, ycmodel_region_final_ellipse_11, ycmodel_region_final_ellipse_22, ycmodel_region_final_ellipse_12, ycmodel_dev_flux_apcorr, ycmodel_dev_flux_apcorr_err, ycmodel_exp_flux_apcorr, ycmodel_exp_flux_apcorr_err
          , ycmodel_flux_apcorr, ycmodel_flux_apcorr_err
          , ycmodel_initial_flux_flags, ycmodel_initial_flags_trsmall, ycmodel_initial_flags_maxiter, ycmodel_initial_flags_numericerror
          , ycmodel_exp_flux_flags, ycmodel_exp_flags_trsmall, ycmodel_exp_flags_maxiter, ycmodel_exp_flags_numericerror
          , ycmodel_dev_flux_flags, ycmodel_dev_flags_trsmall, ycmodel_dev_flags_maxiter, ycmodel_dev_flags_numericerror, ycmodel_flux_flags, ycmodel_flags_region_maxarea, ycmodel_flags_region_maxbadpixelfraction, ycmodel_flags_region_usedfootprintarea, ycmodel_flags_region_usedpsfarea, ycmodel_flags_region_usedinitialellipsemin, ycmodel_flags_region_usedinitialellipsemax, ycmodel_flags_noshape, ycmodel_flags_smallshape, ycmodel_flags_nopsf, ycmodel_flags_nowcs, ycmodel_flags_nocalib, ycmodel_flags_badcentroid, ycmodel_dev_flux_flags_apcorr
          , ycmodel_exp_flux_flags_apcorr, ycmodel_flux_flags_apcorr
          , ydeblend_psf_center_ra, ydeblend_psf_center_dec, ydeblend_psf_flux, ydeblend_psf_mag
          , yblendedness_old, yblendedness_raw_flux, yblendedness_raw_flux_child, yblendedness_raw_mag_child, yblendedness_raw_flux_parent, yblendedness_raw_mag_parent, yblendedness_abs_flux, yblendedness_abs_flux_child, yblendedness_abs_mag_child, yblendedness_abs_flux_parent, yblendedness_abs_mag_parent, yblendedness_raw_shape_child_11, yblendedness_raw_shape_child_22, yblendedness_raw_shape_child_12, yblendedness_raw_shape_parent_11, yblendedness_raw_shape_parent_22, yblendedness_raw_shape_parent_12, yblendedness_abs_shape_child_11, yblendedness_abs_shape_child_22, yblendedness_abs_shape_child_12, yblendedness_abs_shape_parent_11, yblendedness_abs_shape_parent_22, yblendedness_abs_shape_parent_12
          , ydeblend_deblended_as_psf, ydeblend_too_many_peaks, ydeblend_parent_too_big, ydeblend_masked, ydeblend_skipped, ydeblend_ramped_template, ydeblend_patched_template, ydeblend_has_stray_flux
          , yblendedness_flags, yblendedness_flags_nocentroid, yblendedness_flags_noshape, ycountinputs smallint, yclassification_extendedness
          , yflags_negative, yflags_badcentroid, yflags_pixel_edge, yflags_pixel_interpolated_any, yflags_pixel_interpolated_center, yflags_pixel_saturated_any, yflags_pixel_saturated_center, yflags_pixel_cr_any, yflags_pixel_cr_center, yflags_pixel_bad, yflags_pixel_suspect_any, yflags_pixel_suspect_center, yflags_pixel_offimage, yflags_pixel_bright_object_center, yflags_pixel_clipped_any, yflags_pixel_bright_object_any
          , ydetect_is_patch_inner, ydetect_is_tract_inner, ydetect_is_primary, ycalib_psf_candidate, ycalib_psf_used
        )
      }

  }

}