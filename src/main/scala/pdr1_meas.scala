package udafApp

import org.apache.spark.SparkContext

object meas {

  case class pdr1meas(
                       object_id: BigInt
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
                       , parent_id: BigInt
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
    sc.textFile("hdfs://user/matsumoto/sample_pdr1_wide.photoz_demp").
      map { lines =>
        val elms = lines.split(",")
        val object_id = elms(0).toLong
        val gra = elms(1).toDouble
        val gdec = elms(2).toDouble
        val gcoord = elms(3).toString
        val rra = elms(4).toDouble
        val rdec = elms(5).toDouble
        val rcoord = elms(6).toString
        val ira = elms(7).toDouble
        val idec = elms(8).toDouble
        val icoord = elms(9).toString
        val zra = elms(10).toDouble
        val zdec = elms(11).toDouble
        val zcoord = elms(12).toString
        val yra = elms(13).toDouble
        val ydec = elms(14).toDouble
        val ycoord = elms(15).toString
        val skymap_id = elms(16).toInt
        val tract = elms(17).toInt
        val patch = elms(18).toInt
        val patch_s = elms(19).toString
        val parent_id = elms(20).toLong
        val deblend_nchild = elms(21).toInt
        val merge_footprInt_i2 = elms(22).toString
        val merge_footprInt_i = elms(23).toString
        val merge_footprInt_r = elms(24).toString
        val merge_footprInt_z = elms(25).toString
        val merge_footprInt_y = elms(26).toString
        val merge_footprInt_g = elms(27).toString
        val merge_footprInt_n921 = elms(28).toString
        val merge_footprInt_n816 = elms(29).toString
        val merge_footprInt_n1010 = elms(30).toString
        val merge_footprInt_n387 = elms(31).toString
        val merge_footprInt_n515 = elms(32).toString
        val merge_footprInt_sky = elms(33).toString
        val merge_peak_i2 = elms(34).toString
        val merge_peak_i = elms(35).toString
        val merge_peak_r = elms(36).toString
        val merge_peak_z = elms(37).toString
        val merge_peak_y = elms(38).toString
        val merge_peak_g = elms(39).toString
        val merge_peak_n921 = elms(40).toString
        val merge_peak_n816 = elms(41).toString
        val merge_peak_n1010 = elms(42).toString
        val merge_peak_n387 = elms(43).toString
        val merge_peak_n515 = elms(44).toString
        val merge_peak_sky = elms(45).toString
        val gflux_naive = elms(46).toDouble
        val gmag_naive = elms(47).toFloat
        val gflux_naive_err = elms(48).toDouble
        val gmag_naive_err = elms(49).toFloat
        val gflux_naive_flags = elms(50).toString
        val gflux_sinc = elms(51).toDouble
        val gmag_sinc = elms(52).toFloat
        val gflux_sinc_err = elms(53).toDouble
        val gmag_sinc_err = elms(54).toFloat
        val gflux_sinc_flags = elms(55).toString
        val gflux_psf = elms(56).toDouble
        val gmag_psf = elms(57).toFloat
        val gflux_psf_err = elms(58).toDouble
        val gmag_psf_err = elms(59).toFloat
        val gflux_psf_apcorr = elms(60).toFloat
        val gflux_psf_apcorr_err = elms(61).toFloat
        val gflux_psf_flags = elms(62).toString
        val gflux_psf_flags_apcorr = elms(63).toString
        val gflux_kron = elms(64).toDouble
        val gmag_kron = elms(65).toFloat
        val gflux_kron_err = elms(66).toDouble
        val gmag_kron_err = elms(67).toFloat
        val gflux_kron_radius = elms(68).toFloat
        val gflux_kron_radiusforradius = elms(69).toFloat
        val gflux_kron_psfradius = elms(70).toFloat
        val gflux_kron_apcorr = elms(71).toFloat
        val gflux_kron_apcorr_err = elms(72).toFloat
        val gflux_kron_flags = elms(73).toString
        val gflux_kron_flags_edge = elms(74).toString
        val gflux_kron_flags_radius = elms(75).toString
        val gflux_kron_flags_smallradius = elms(76).toString
        val gflux_kron_flags_usedminimumradius = elms(77).toString
        val gflux_kron_flags_usedpsfradius = elms(78).toString
        val gflux_kron_flags_badshape = elms(79).toString
        val gflux_kron_flags_apcorr = elms(80).toString
        val gflux_gaussian = elms(81).toDouble
        val gmag_gaussian = elms(82).toFloat
        val gflux_gaussian_err = elms(83).toDouble
        val gmag_gaussian_err = elms(84).toFloat
        val gflux_gaussian_apcorr = elms(85).toFloat
        val gflux_gaussian_apcorr_err = elms(86).toFloat
        val gflux_gaussian_flags = elms(87).toString
        val gflux_gaussian_flags_apcorr = elms(88).toString
        val gcmodel_initial_flux = elms(89).toDouble
        val gcmodel_initial_mag = elms(90).toFloat
        val gcmodel_initial_flux_err = elms(91).toDouble
        val gcmodel_initial_mag_err = elms(92).toFloat
        val gcmodel_initial_flux_inner = elms(93).toDouble
        val gcmodel_initial_mag_inner = elms(94).toFloat
        val gcmodel_initial_ellipse_11 = elms(95).toFloat
        val gcmodel_initial_ellipse_22 = elms(96).toFloat
        val gcmodel_initial_ellipse_12 = elms(97).toFloat
        val gcmodel_initial_objective = elms(98).toFloat
        val gcmodel_initial_nonlinear0 = elms(99).toFloat
        val gcmodel_initial_nonlinear1 = elms(100).toFloat
        val gcmodel_initial_nonlinear2 = elms(101).toFloat
        val gcmodel_initial_fixed0 = elms(102).toFloat
        val gcmodel_initial_fixed1 = elms(103).toFloat
        val gcmodel_initial_niter = elms(104).toInt
        val gcmodel_initial_time = elms(105).toFloat
        val gcmodel_exp_flux = elms(106).toDouble
        val gcmodel_exp_mag = elms(107).toFloat
        val gcmodel_exp_flux_err = elms(108).toDouble
        val gcmodel_exp_mag_err = elms(109).toFloat
        val gcmodel_exp_flux_inner = elms(110).toDouble
        val gcmodel_exp_mag_inner = elms(111).toFloat
        val gcmodel_exp_ellipse_11 = elms(112).toFloat
        val gcmodel_exp_ellipse_22 = elms(113).toFloat
        val gcmodel_exp_ellipse_12 = elms(114).toFloat
        val gcmodel_exp_objective = elms(115).toFloat
        val gcmodel_exp_nonlinear0 = elms(116).toFloat
        val gcmodel_exp_nonlinear1 = elms(117).toFloat
        val gcmodel_exp_nonlinear2 = elms(118).toFloat
        val gcmodel_exp_fixed0 = elms(119).toFloat
        val gcmodel_exp_fixed1 = elms(120).toFloat
        val gcmodel_exp_niter = elms(121).toInt
        val gcmodel_exp_time = elms(122).toFloat
        val gcmodel_dev_flux = elms(123).toDouble
        val gcmodel_dev_mag = elms(124).toFloat
        val gcmodel_dev_flux_err = elms(125).toDouble
        val gcmodel_dev_mag_err = elms(126).toFloat
        val gcmodel_dev_flux_inner = elms(127).toDouble
        val gcmodel_dev_mag_inner = elms(128).toFloat
        val gcmodel_dev_ellipse_11 = elms(129).toFloat
        val gcmodel_dev_ellipse_22 = elms(130).toFloat
        val gcmodel_dev_ellipse_12 = elms(131).toFloat
        val gcmodel_dev_objective = elms(132).toFloat
        val gcmodel_dev_nonlinear0 = elms(133).toFloat
        val gcmodel_dev_nonlinear1 = elms(134).toFloat
        val gcmodel_dev_nonlinear2 = elms(135).toFloat
        val gcmodel_dev_fixed0 = elms(136).toFloat
        val gcmodel_dev_fixed1 = elms(137).toFloat
        val gcmodel_dev_niter = elms(138).toInt
        val gcmodel_dev_time = elms(139).toFloat
        val gcmodel_center_ra = elms(140).toDouble
        val gcmodel_center_dec = elms(141).toDouble
        val gcmodel_flux = elms(142).toDouble
        val gcmodel_mag = elms(143).toFloat
        val gcmodel_flux_err = elms(144).toDouble
        val gcmodel_mag_err = elms(145).toFloat
        val gcmodel_flux_inner = elms(146).toDouble
        val gcmodel_mag_inner = elms(147).toFloat
        val gcmodel_fracdev = elms(148).toFloat
        val gcmodel_objective = elms(149).toFloat
        val gcmodel_ellipse_11 = elms(150).toFloat
        val gcmodel_ellipse_22 = elms(151).toFloat
        val gcmodel_ellipse_12 = elms(152).toFloat
        val gcmodel_region_initial_ellipse_11 = elms(153).toFloat
        val gcmodel_region_initial_ellipse_22 = elms(154).toFloat
        val gcmodel_region_initial_ellipse_12 = elms(155).toFloat
        val gcmodel_region_final_ellipse_11 = elms(156).toFloat
        val gcmodel_region_final_ellipse_22 = elms(157).toFloat
        val gcmodel_region_final_ellipse_12 = elms(158).toFloat
        val gcmodel_dev_flux_apcorr = elms(159).toFloat
        val gcmodel_dev_flux_apcorr_err = elms(160).toFloat
        val gcmodel_exp_flux_apcorr = elms(161).toFloat
        val gcmodel_exp_flux_apcorr_err = elms(162).toFloat
        val gcmodel_flux_apcorr = elms(163).toFloat
        val gcmodel_flux_apcorr_err = elms(164).toFloat
        val gcmodel_initial_flux_flags = elms(165).toString
        val gcmodel_initial_flags_trsmall = elms(166).toString
        val gcmodel_initial_flags_maxiter = elms(167).toString
        val gcmodel_initial_flags_numericerror = elms(168).toString
        val gcmodel_exp_flux_flags = elms(169).toString
        val gcmodel_exp_flags_trsmall = elms(170).toString
        val gcmodel_exp_flags_maxiter = elms(171).toString
        val gcmodel_exp_flags_numericerror = elms(172).toString
        val gcmodel_dev_flux_flags = elms(173).toString
        val gcmodel_dev_flags_trsmall = elms(174).toString
        val gcmodel_dev_flags_maxiter = elms(175).toString
        val gcmodel_dev_flags_numericerror = elms(176).toString
        val gcmodel_flux_flags = elms(177).toString
        val gcmodel_flags_region_maxarea = elms(178).toString
        val gcmodel_flags_region_maxbadpixelfraction = elms(179).toString
        val gcmodel_flags_region_usedfootprIntarea = elms(180).toString
        val gcmodel_flags_region_usedpsfarea = elms(181).toString
        val gcmodel_flags_region_usedinitialellipsemin = elms(182).toString
        val gcmodel_flags_region_usedinitialellipsemax = elms(183).toString
        val gcmodel_flags_noshape = elms(184).toString
        val gcmodel_flags_smallshape = elms(185).toString
        val gcmodel_flags_nopsf = elms(186).toString
        val gcmodel_flags_nowcs = elms(187).toString
        val gcmodel_flags_nocalib = elms(188).toString
        val gcmodel_flags_badcentroid = elms(189).toString
        val gcmodel_dev_flux_flags_apcorr = elms(190).toString
        val gcmodel_exp_flux_flags_apcorr = elms(191).toString
        val gcmodel_flux_flags_apcorr = elms(192).toString
        val gdeblend_psf_center_ra = elms(193).toDouble
        val gdeblend_psf_center_dec = elms(194).toDouble
        val gdeblend_psf_flux = elms(195).toDouble
        val gdeblend_psf_mag = elms(196).toFloat
        val gblendedness_old = elms(197).toFloat
        val gblendedness_raw_flux = elms(198).toFloat
        val gblendedness_raw_flux_child = elms(199).toDouble
        val gblendedness_raw_mag_child = elms(200).toFloat
        val gblendedness_raw_flux_parent = elms(201).toDouble
        val gblendedness_raw_mag_parent = elms(202).toFloat
        val gblendedness_abs_flux = elms(203).toFloat
        val gblendedness_abs_flux_child = elms(204).toDouble
        val gblendedness_abs_mag_child = elms(205).toFloat
        val gblendedness_abs_flux_parent = elms(206).toDouble
        val gblendedness_abs_mag_parent = elms(207).toFloat
        val gblendedness_raw_shape_child_11 = elms(208).toFloat
        val gblendedness_raw_shape_child_22 = elms(209).toFloat
        val gblendedness_raw_shape_child_12 = elms(210).toFloat
        val gblendedness_raw_shape_parent_11 = elms(211).toFloat
        val gblendedness_raw_shape_parent_22 = elms(212).toFloat
        val gblendedness_raw_shape_parent_12 = elms(213).toFloat
        val gblendedness_abs_shape_child_11 = elms(214).toFloat
        val gblendedness_abs_shape_child_22 = elms(215).toFloat
        val gblendedness_abs_shape_child_12 = elms(216).toFloat
        val gblendedness_abs_shape_parent_11 = elms(217).toFloat
        val gblendedness_abs_shape_parent_22 = elms(218).toFloat
        val gblendedness_abs_shape_parent_12 = elms(219).toFloat
        val gdeblend_deblended_as_psf = elms(220).toString
        val gdeblend_too_many_peaks = elms(221).toString
        val gdeblend_parent_too_big = elms(222).toString
        val gdeblend_masked = elms(223).toString
        val gdeblend_skipped = elms(224).toString
        val gdeblend_ramped_template = elms(225).toString
        val gdeblend_patched_template = elms(226).toString
        val gdeblend_has_stray_flux = elms(227).toString
        val gblendedness_flags = elms(228).toString
        val gblendedness_flags_nocentroid = elms(229).toString
        val gblendedness_flags_noshape = elms(230).toString
        val gcountinputs = elms(231).toInt
        val gclassification_extendedness = elms(232).toFloat
        val gflags_negative = elms(233).toString
        val gflags_badcentroid = elms(234).toString
        val gflags_pixel_edge = elms(235).toString
        val gflags_pixel_Interpolated_any = elms(236).toString
        val gflags_pixel_Interpolated_center = elms(237).toString
        val gflags_pixel_saturated_any = elms(238).toString
        val gflags_pixel_saturated_center = elms(239).toString
        val gflags_pixel_cr_any = elms(240).toString
        val gflags_pixel_cr_center = elms(241).toString
        val gflags_pixel_bad = elms(242).toString
        val gflags_pixel_suspect_any = elms(243).toString
        val gflags_pixel_suspect_center = elms(244).toString
        val gflags_pixel_offimage = elms(245).toString
        val gflags_pixel_bright_object_center = elms(246).toString
        val gflags_pixel_clipped_any = elms(247).toString
        val gflags_pixel_bright_object_any = elms(248).toString
        val gdetect_is_patch_inner = elms(249).toString
        val gdetect_is_tract_inner = elms(250).toString
        val gdetect_is_primary = elms(251).toString
        val gcalib_psf_candidate = elms(252).toString
        val gcalib_psf_used = elms(253).toString
        val rflux_naive = elms(254).toDouble
        val rmag_naive = elms(255).toFloat
        val rflux_naive_err = elms(256).toDouble
        val rmag_naive_err = elms(257).toFloat
        val rflux_naive_flags = elms(258).toString
        val rflux_sinc = elms(259).toDouble
        val rmag_sinc = elms(260).toFloat
        val rflux_sinc_err = elms(261).toDouble
        val rmag_sinc_err = elms(262).toFloat
        val rflux_sinc_flags = elms(263).toString
        val rflux_psf = elms(264).toDouble
        val rmag_psf = elms(265).toFloat
        val rflux_psf_err = elms(266).toDouble
        val rmag_psf_err = elms(267).toFloat
        val rflux_psf_apcorr = elms(268).toFloat
        val rflux_psf_apcorr_err = elms(269).toFloat
        val rflux_psf_flags = elms(270).toString
        val rflux_psf_flags_apcorr = elms(271).toString
        val rflux_kron = elms(272).toDouble
        val rmag_kron = elms(273).toFloat
        val rflux_kron_err = elms(274).toDouble
        val rmag_kron_err = elms(275).toFloat
        val rflux_kron_radius = elms(276).toFloat
        val rflux_kron_radiusforradius = elms(277).toFloat
        val rflux_kron_psfradius = elms(278).toFloat
        val rflux_kron_apcorr = elms(279).toFloat
        val rflux_kron_apcorr_err = elms(280).toFloat
        val rflux_kron_flags = elms(281).toString
        val rflux_kron_flags_edge = elms(282).toString
        val rflux_kron_flags_radius = elms(283).toString
        val rflux_kron_flags_smallradius = elms(284).toString
        val rflux_kron_flags_usedminimumradius = elms(285).toString
        val rflux_kron_flags_usedpsfradius = elms(286).toString
        val rflux_kron_flags_badshape = elms(287).toString
        val rflux_kron_flags_apcorr = elms(288).toString
        val rflux_gaussian = elms(289).toDouble
        val rmag_gaussian = elms(290).toFloat
        val rflux_gaussian_err = elms(291).toDouble
        val rmag_gaussian_err = elms(292).toFloat
        val rflux_gaussian_apcorr = elms(293).toFloat
        val rflux_gaussian_apcorr_err = elms(294).toFloat
        val rflux_gaussian_flags = elms(295).toString
        val rflux_gaussian_flags_apcorr = elms(296).toString
        val rcmodel_initial_flux = elms(297).toDouble
        val rcmodel_initial_mag = elms(298).toFloat
        val rcmodel_initial_flux_err = elms(299).toDouble
        val rcmodel_initial_mag_err = elms(300).toFloat
        val rcmodel_initial_flux_inner = elms(301).toDouble
        val rcmodel_initial_mag_inner = elms(302).toFloat
        val rcmodel_initial_ellipse_11 = elms(303).toFloat
        val rcmodel_initial_ellipse_22 = elms(304).toFloat
        val rcmodel_initial_ellipse_12 = elms(305).toFloat
        val rcmodel_initial_objective = elms(306).toFloat
        val rcmodel_initial_nonlinear0 = elms(307).toFloat
        val rcmodel_initial_nonlinear1 = elms(308).toFloat
        val rcmodel_initial_nonlinear2 = elms(309).toFloat
        val rcmodel_initial_fixed0 = elms(310).toFloat
        val rcmodel_initial_fixed1 = elms(311).toFloat
        val rcmodel_initial_niter = elms(312).toInt
        val rcmodel_initial_time = elms(313).toFloat
        val rcmodel_exp_flux = elms(314).toDouble
        val rcmodel_exp_mag = elms(315).toFloat
        val rcmodel_exp_flux_err = elms(316).toDouble
        val rcmodel_exp_mag_err = elms(317).toFloat
        val rcmodel_exp_flux_inner = elms(318).toDouble
        val rcmodel_exp_mag_inner = elms(319).toFloat
        val rcmodel_exp_ellipse_11 = elms(320).toFloat
        val rcmodel_exp_ellipse_22 = elms(321).toFloat
        val rcmodel_exp_ellipse_12 = elms(322).toFloat
        val rcmodel_exp_objective = elms(323).toFloat
        val rcmodel_exp_nonlinear0 = elms(324).toFloat
        val rcmodel_exp_nonlinear1 = elms(325).toFloat
        val rcmodel_exp_nonlinear2 = elms(326).toFloat
        val rcmodel_exp_fixed0 = elms(327).toFloat
        val rcmodel_exp_fixed1 = elms(328).toFloat
        val rcmodel_exp_niter = elms(329).toInt
        val rcmodel_exp_time = elms(330).toFloat
        val rcmodel_dev_flux = elms(331).toDouble
        val rcmodel_dev_mag = elms(332).toFloat
        val rcmodel_dev_flux_err = elms(333).toDouble
        val rcmodel_dev_mag_err = elms(334).toFloat
        val rcmodel_dev_flux_inner = elms(335).toDouble
        val rcmodel_dev_mag_inner = elms(336).toFloat
        val rcmodel_dev_ellipse_11 = elms(337).toFloat
        val rcmodel_dev_ellipse_22 = elms(338).toFloat
        val rcmodel_dev_ellipse_12 = elms(339).toFloat
        val rcmodel_dev_objective = elms(340).toFloat
        val rcmodel_dev_nonlinear0 = elms(341).toFloat
        val rcmodel_dev_nonlinear1 = elms(342).toFloat
        val rcmodel_dev_nonlinear2 = elms(343).toFloat
        val rcmodel_dev_fixed0 = elms(344).toFloat
        val rcmodel_dev_fixed1 = elms(345).toFloat
        val rcmodel_dev_niter = elms(346).toInt
        val rcmodel_dev_time = elms(347).toFloat
        val rcmodel_center_ra = elms(348).toDouble
        val rcmodel_center_dec = elms(349).toDouble
        val rcmodel_flux = elms(350).toDouble
        val rcmodel_mag = elms(351).toFloat
        val rcmodel_flux_err = elms(352).toDouble
        val rcmodel_mag_err = elms(353).toFloat
        val rcmodel_flux_inner = elms(354).toDouble
        val rcmodel_mag_inner = elms(355).toFloat
        val rcmodel_fracdev = elms(356).toFloat
        val rcmodel_objective = elms(357).toFloat
        val rcmodel_ellipse_11 = elms(358).toFloat
        val rcmodel_ellipse_22 = elms(359).toFloat
        val rcmodel_ellipse_12 = elms(360).toFloat
        val rcmodel_region_initial_ellipse_11 = elms(361).toFloat
        val rcmodel_region_initial_ellipse_22 = elms(362).toFloat
        val rcmodel_region_initial_ellipse_12 = elms(363).toFloat
        val rcmodel_region_final_ellipse_11 = elms(364).toFloat
        val rcmodel_region_final_ellipse_22 = elms(365).toFloat
        val rcmodel_region_final_ellipse_12 = elms(366).toFloat
        val rcmodel_dev_flux_apcorr = elms(367).toFloat
        val rcmodel_dev_flux_apcorr_err = elms(368).toFloat
        val rcmodel_exp_flux_apcorr = elms(369).toFloat
        val rcmodel_exp_flux_apcorr_err = elms(370).toFloat
        val rcmodel_flux_apcorr = elms(371).toFloat
        val rcmodel_flux_apcorr_err = elms(372).toFloat
        val rcmodel_initial_flux_flags = elms(373).toString
        val rcmodel_initial_flags_trsmall = elms(374).toString
        val rcmodel_initial_flags_maxiter = elms(375).toString
        val rcmodel_initial_flags_numericerror = elms(376).toString
        val rcmodel_exp_flux_flags = elms(377).toString
        val rcmodel_exp_flags_trsmall = elms(378).toString
        val rcmodel_exp_flags_maxiter = elms(379).toString
        val rcmodel_exp_flags_numericerror = elms(380).toString
        val rcmodel_dev_flux_flags = elms(381).toString
        val rcmodel_dev_flags_trsmall = elms(382).toString
        val rcmodel_dev_flags_maxiter = elms(383).toString
        val rcmodel_dev_flags_numericerror = elms(384).toString
        val rcmodel_flux_flags = elms(385).toString
        val rcmodel_flags_region_maxarea = elms(386).toString
        val rcmodel_flags_region_maxbadpixelfraction = elms(387).toString
        val rcmodel_flags_region_usedfootprIntarea = elms(388).toString
        val rcmodel_flags_region_usedpsfarea = elms(389).toString
        val rcmodel_flags_region_usedinitialellipsemin = elms(390).toString
        val rcmodel_flags_region_usedinitialellipsemax = elms(391).toString
        val rcmodel_flags_noshape = elms(392).toString
        val rcmodel_flags_smallshape = elms(393).toString
        val rcmodel_flags_nopsf = elms(394).toString
        val rcmodel_flags_nowcs = elms(395).toString
        val rcmodel_flags_nocalib = elms(396).toString
        val rcmodel_flags_badcentroid = elms(397).toString
        val rcmodel_dev_flux_flags_apcorr = elms(398).toString
        val rcmodel_exp_flux_flags_apcorr = elms(399).toString
        val rcmodel_flux_flags_apcorr = elms(400).toString
        val rdeblend_psf_center_ra = elms(401).toDouble
        val rdeblend_psf_center_dec = elms(402).toDouble
        val rdeblend_psf_flux = elms(403).toDouble
        val rdeblend_psf_mag = elms(404).toFloat
        val rblendedness_old = elms(405).toFloat
        val rblendedness_raw_flux = elms(406).toFloat
        val rblendedness_raw_flux_child = elms(407).toDouble
        val rblendedness_raw_mag_child = elms(408).toFloat
        val rblendedness_raw_flux_parent = elms(409).toDouble
        val rblendedness_raw_mag_parent = elms(410).toFloat
        val rblendedness_abs_flux = elms(411).toFloat
        val rblendedness_abs_flux_child = elms(412).toDouble
        val rblendedness_abs_mag_child = elms(413).toFloat
        val rblendedness_abs_flux_parent = elms(414).toDouble
        val rblendedness_abs_mag_parent = elms(415).toFloat
        val rblendedness_raw_shape_child_11 = elms(416).toFloat
        val rblendedness_raw_shape_child_22 = elms(417).toFloat
        val rblendedness_raw_shape_child_12 = elms(418).toFloat
        val rblendedness_raw_shape_parent_11 = elms(419).toFloat
        val rblendedness_raw_shape_parent_22 = elms(420).toFloat
        val rblendedness_raw_shape_parent_12 = elms(421).toFloat
        val rblendedness_abs_shape_child_11 = elms(422).toFloat
        val rblendedness_abs_shape_child_22 = elms(423).toFloat
        val rblendedness_abs_shape_child_12 = elms(424).toFloat
        val rblendedness_abs_shape_parent_11 = elms(425).toFloat
        val rblendedness_abs_shape_parent_22 = elms(426).toFloat
        val rblendedness_abs_shape_parent_12 = elms(427).toFloat
        val rdeblend_deblended_as_psf = elms(428).toString
        val rdeblend_too_many_peaks = elms(429).toString
        val rdeblend_parent_too_big = elms(430).toString
        val rdeblend_masked = elms(431).toString
        val rdeblend_skipped = elms(432).toString
        val rdeblend_ramped_template = elms(433).toString
        val rdeblend_patched_template = elms(434).toString
        val rdeblend_has_stray_flux = elms(435).toString
        val rblendedness_flags = elms(436).toString
        val rblendedness_flags_nocentroid = elms(437).toString
        val rblendedness_flags_noshape = elms(438).toString
        val rcountinputs = elms(439).toInt
        val rclassification_extendedness = elms(440).toFloat
        val rflags_negative = elms(441).toString
        val rflags_badcentroid = elms(442).toString
        val rflags_pixel_edge = elms(443).toString
        val rflags_pixel_Interpolated_any = elms(444).toString
        val rflags_pixel_Interpolated_center = elms(445).toString
        val rflags_pixel_saturated_any = elms(446).toString
        val rflags_pixel_saturated_center = elms(447).toString
        val rflags_pixel_cr_any = elms(448).toString
        val rflags_pixel_cr_center = elms(449).toString
        val rflags_pixel_bad = elms(450).toString
        val rflags_pixel_suspect_any = elms(451).toString
        val rflags_pixel_suspect_center = elms(452).toString
        val rflags_pixel_offimage = elms(453).toString
        val rflags_pixel_bright_object_center = elms(454).toString
        val rflags_pixel_clipped_any = elms(455).toString
        val rflags_pixel_bright_object_any = elms(456).toString
        val rdetect_is_patch_inner = elms(457).toString
        val rdetect_is_tract_inner = elms(458).toString
        val rdetect_is_primary = elms(459).toString
        val rcalib_psf_candidate = elms(460).toString
        val rcalib_psf_used = elms(461).toString
        val iflux_naive = elms(462).toDouble
        val imag_naive = elms(463).toFloat
        val iflux_naive_err = elms(464).toDouble
        val imag_naive_err = elms(465).toFloat
        val iflux_naive_flags = elms(466).toString
        val iflux_sinc = elms(467).toDouble
        val imag_sinc = elms(468).toFloat
        val iflux_sinc_err = elms(469).toDouble
        val imag_sinc_err = elms(470).toFloat
        val iflux_sinc_flags = elms(471).toString
        val iflux_psf = elms(472).toDouble
        val imag_psf = elms(473).toFloat
        val iflux_psf_err = elms(474).toDouble
        val imag_psf_err = elms(475).toFloat
        val iflux_psf_apcorr = elms(476).toFloat
        val iflux_psf_apcorr_err = elms(477).toFloat
        val iflux_psf_flags = elms(478).toString
        val iflux_psf_flags_apcorr = elms(479).toString
        val iflux_kron = elms(480).toDouble
        val imag_kron = elms(481).toFloat
        val iflux_kron_err = elms(482).toDouble
        val imag_kron_err = elms(483).toFloat
        val iflux_kron_radius = elms(484).toFloat
        val iflux_kron_radiusforradius = elms(485).toFloat
        val iflux_kron_psfradius = elms(486).toFloat
        val iflux_kron_apcorr = elms(487).toFloat
        val iflux_kron_apcorr_err = elms(488).toFloat
        val iflux_kron_flags = elms(489).toString
        val iflux_kron_flags_edge = elms(490).toString
        val iflux_kron_flags_radius = elms(491).toString
        val iflux_kron_flags_smallradius = elms(492).toString
        val iflux_kron_flags_usedminimumradius = elms(493).toString
        val iflux_kron_flags_usedpsfradius = elms(494).toString
        val iflux_kron_flags_badshape = elms(495).toString
        val iflux_kron_flags_apcorr = elms(496).toString
        val iflux_gaussian = elms(497).toDouble
        val imag_gaussian = elms(498).toFloat
        val iflux_gaussian_err = elms(499).toDouble
        val imag_gaussian_err = elms(500).toFloat
        val iflux_gaussian_apcorr = elms(501).toFloat
        val iflux_gaussian_apcorr_err = elms(502).toFloat
        val iflux_gaussian_flags = elms(503).toString
        val iflux_gaussian_flags_apcorr = elms(504).toString
        val icmodel_initial_flux = elms(505).toDouble
        val icmodel_initial_mag = elms(506).toFloat
        val icmodel_initial_flux_err = elms(507).toDouble
        val icmodel_initial_mag_err = elms(508).toFloat
        val icmodel_initial_flux_inner = elms(509).toDouble
        val icmodel_initial_mag_inner = elms(510).toFloat
        val icmodel_initial_ellipse_11 = elms(511).toFloat
        val icmodel_initial_ellipse_22 = elms(512).toFloat
        val icmodel_initial_ellipse_12 = elms(513).toFloat
        val icmodel_initial_objective = elms(514).toFloat
        val icmodel_initial_nonlinear0 = elms(515).toFloat
        val icmodel_initial_nonlinear1 = elms(516).toFloat
        val icmodel_initial_nonlinear2 = elms(517).toFloat
        val icmodel_initial_fixed0 = elms(518).toFloat
        val icmodel_initial_fixed1 = elms(519).toFloat
        val icmodel_initial_niter = elms(520).toInt
        val icmodel_initial_time = elms(521).toFloat
        val icmodel_exp_flux = elms(522).toDouble
        val icmodel_exp_mag = elms(523).toFloat
        val icmodel_exp_flux_err = elms(524).toDouble
        val icmodel_exp_mag_err = elms(525).toFloat
        val icmodel_exp_flux_inner = elms(526).toDouble
        val icmodel_exp_mag_inner = elms(527).toFloat
        val icmodel_exp_ellipse_11 = elms(528).toFloat
        val icmodel_exp_ellipse_22 = elms(529).toFloat
        val icmodel_exp_ellipse_12 = elms(530).toFloat
        val icmodel_exp_objective = elms(531).toFloat
        val icmodel_exp_nonlinear0 = elms(532).toFloat
        val icmodel_exp_nonlinear1 = elms(533).toFloat
        val icmodel_exp_nonlinear2 = elms(534).toFloat
        val icmodel_exp_fixed0 = elms(535).toFloat
        val icmodel_exp_fixed1 = elms(536).toFloat
        val icmodel_exp_niter = elms(537).toInt
        val icmodel_exp_time = elms(538).toFloat
        val icmodel_dev_flux = elms(539).toDouble
        val icmodel_dev_mag = elms(540).toFloat
        val icmodel_dev_flux_err = elms(541).toDouble
        val icmodel_dev_mag_err = elms(542).toFloat
        val icmodel_dev_flux_inner = elms(543).toDouble
        val icmodel_dev_mag_inner = elms(544).toFloat
        val icmodel_dev_ellipse_11 = elms(545).toFloat
        val icmodel_dev_ellipse_22 = elms(546).toFloat
        val icmodel_dev_ellipse_12 = elms(547).toFloat
        val icmodel_dev_objective = elms(548).toFloat
        val icmodel_dev_nonlinear0 = elms(549).toFloat
        val icmodel_dev_nonlinear1 = elms(550).toFloat
        val icmodel_dev_nonlinear2 = elms(551).toFloat
        val icmodel_dev_fixed0 = elms(552).toFloat
        val icmodel_dev_fixed1 = elms(553).toFloat
        val icmodel_dev_niter = elms(554).toInt
        val icmodel_dev_time = elms(555).toFloat
        val icmodel_center_ra = elms(556).toDouble
        val icmodel_center_dec = elms(557).toDouble
        val icmodel_flux = elms(558).toDouble
        val icmodel_mag = elms(559).toFloat
        val icmodel_flux_err = elms(560).toDouble
        val icmodel_mag_err = elms(561).toFloat
        val icmodel_flux_inner = elms(562).toDouble
        val icmodel_mag_inner = elms(563).toFloat
        val icmodel_fracdev = elms(564).toFloat
        val icmodel_objective = elms(565).toFloat
        val icmodel_ellipse_11 = elms(566).toFloat
        val icmodel_ellipse_22 = elms(567).toFloat
        val icmodel_ellipse_12 = elms(568).toFloat
        val icmodel_region_initial_ellipse_11 = elms(569).toFloat
        val icmodel_region_initial_ellipse_22 = elms(570).toFloat
        val icmodel_region_initial_ellipse_12 = elms(571).toFloat
        val icmodel_region_final_ellipse_11 = elms(572).toFloat
        val icmodel_region_final_ellipse_22 = elms(573).toFloat
        val icmodel_region_final_ellipse_12 = elms(574).toFloat
        val icmodel_dev_flux_apcorr = elms(575).toFloat
        val icmodel_dev_flux_apcorr_err = elms(576).toFloat
        val icmodel_exp_flux_apcorr = elms(577).toFloat
        val icmodel_exp_flux_apcorr_err = elms(578).toFloat
        val icmodel_flux_apcorr = elms(579).toFloat
        val icmodel_flux_apcorr_err = elms(580).toFloat
        val icmodel_initial_flux_flags = elms(581).toString
        val icmodel_initial_flags_trsmall = elms(582).toString
        val icmodel_initial_flags_maxiter = elms(583).toString
        val icmodel_initial_flags_numericerror = elms(584).toString
        val icmodel_exp_flux_flags = elms(585).toString
        val icmodel_exp_flags_trsmall = elms(586).toString
        val icmodel_exp_flags_maxiter = elms(587).toString
        val icmodel_exp_flags_numericerror = elms(588).toString
        val icmodel_dev_flux_flags = elms(589).toString
        val icmodel_dev_flags_trsmall = elms(590).toString
        val icmodel_dev_flags_maxiter = elms(591).toString
        val icmodel_dev_flags_numericerror = elms(592).toString
        val icmodel_flux_flags = elms(593).toString
        val icmodel_flags_region_maxarea = elms(594).toString
        val icmodel_flags_region_maxbadpixelfraction = elms(595).toString
        val icmodel_flags_region_usedfootprIntarea = elms(596).toString
        val icmodel_flags_region_usedpsfarea = elms(597).toString
        val icmodel_flags_region_usedinitialellipsemin = elms(598).toString
        val icmodel_flags_region_usedinitialellipsemax = elms(599).toString
        val icmodel_flags_noshape = elms(600).toString
        val icmodel_flags_smallshape = elms(601).toString
        val icmodel_flags_nopsf = elms(602).toString
        val icmodel_flags_nowcs = elms(603).toString
        val icmodel_flags_nocalib = elms(604).toString
        val icmodel_flags_badcentroid = elms(605).toString
        val icmodel_dev_flux_flags_apcorr = elms(606).toString
        val icmodel_exp_flux_flags_apcorr = elms(607).toString
        val icmodel_flux_flags_apcorr = elms(608).toString
        val ideblend_psf_center_ra = elms(609).toDouble
        val ideblend_psf_center_dec = elms(610).toDouble
        val ideblend_psf_flux = elms(611).toDouble
        val ideblend_psf_mag = elms(612).toFloat
        val iblendedness_old = elms(613).toFloat
        val iblendedness_raw_flux = elms(614).toFloat
        val iblendedness_raw_flux_child = elms(615).toDouble
        val iblendedness_raw_mag_child = elms(616).toFloat
        val iblendedness_raw_flux_parent = elms(617).toDouble
        val iblendedness_raw_mag_parent = elms(618).toFloat
        val iblendedness_abs_flux = elms(619).toFloat
        val iblendedness_abs_flux_child = elms(620).toDouble
        val iblendedness_abs_mag_child = elms(621).toFloat
        val iblendedness_abs_flux_parent = elms(622).toDouble
        val iblendedness_abs_mag_parent = elms(623).toFloat
        val iblendedness_raw_shape_child_11 = elms(624).toFloat
        val iblendedness_raw_shape_child_22 = elms(625).toFloat
        val iblendedness_raw_shape_child_12 = elms(626).toFloat
        val iblendedness_raw_shape_parent_11 = elms(627).toFloat
        val iblendedness_raw_shape_parent_22 = elms(628).toFloat
        val iblendedness_raw_shape_parent_12 = elms(629).toFloat
        val iblendedness_abs_shape_child_11 = elms(630).toFloat
        val iblendedness_abs_shape_child_22 = elms(631).toFloat
        val iblendedness_abs_shape_child_12 = elms(632).toFloat
        val iblendedness_abs_shape_parent_11 = elms(633).toFloat
        val iblendedness_abs_shape_parent_22 = elms(634).toFloat
        val iblendedness_abs_shape_parent_12 = elms(635).toFloat
        val ideblend_deblended_as_psf = elms(636).toString
        val ideblend_too_many_peaks = elms(637).toString
        val ideblend_parent_too_big = elms(638).toString
        val ideblend_masked = elms(639).toString
        val ideblend_skipped = elms(640).toString
        val ideblend_ramped_template = elms(641).toString
        val ideblend_patched_template = elms(642).toString
        val ideblend_has_stray_flux = elms(643).toString
        val iblendedness_flags = elms(644).toString
        val iblendedness_flags_nocentroid = elms(645).toString
        val iblendedness_flags_noshape = elms(646).toString
        val icountinputs = elms(647).toInt
        val iclassification_extendedness = elms(648).toFloat
        val iflags_negative = elms(649).toString
        val iflags_badcentroid = elms(650).toString
        val iflags_pixel_edge = elms(651).toString
        val iflags_pixel_Interpolated_any = elms(652).toString
        val iflags_pixel_Interpolated_center = elms(653).toString
        val iflags_pixel_saturated_any = elms(654).toString
        val iflags_pixel_saturated_center = elms(655).toString
        val iflags_pixel_cr_any = elms(656).toString
        val iflags_pixel_cr_center = elms(657).toString
        val iflags_pixel_bad = elms(658).toString
        val iflags_pixel_suspect_any = elms(659).toString
        val iflags_pixel_suspect_center = elms(660).toString
        val iflags_pixel_offimage = elms(661).toString
        val iflags_pixel_bright_object_center = elms(662).toString
        val iflags_pixel_clipped_any = elms(663).toString
        val iflags_pixel_bright_object_any = elms(664).toString
        val idetect_is_patch_inner = elms(665).toString
        val idetect_is_tract_inner = elms(666).toString
        val idetect_is_primary = elms(667).toString
        val icalib_psf_candidate = elms(668).toString
        val icalib_psf_used = elms(669).toString
        val zflux_naive = elms(670).toDouble
        val zmag_naive = elms(671).toFloat
        val zflux_naive_err = elms(672).toDouble
        val zmag_naive_err = elms(673).toFloat
        val zflux_naive_flags = elms(674).toString
        val zflux_sinc = elms(675).toDouble
        val zmag_sinc = elms(676).toFloat
        val zflux_sinc_err = elms(677).toDouble
        val zmag_sinc_err = elms(678).toFloat
        val zflux_sinc_flags = elms(679).toString
        val zflux_psf = elms(680).toDouble
        val zmag_psf = elms(681).toFloat
        val zflux_psf_err = elms(682).toDouble
        val zmag_psf_err = elms(683).toFloat
        val zflux_psf_apcorr = elms(684).toFloat
        val zflux_psf_apcorr_err = elms(685).toFloat
        val zflux_psf_flags = elms(686).toString
        val zflux_psf_flags_apcorr = elms(687).toString
        val zflux_kron = elms(688).toDouble
        val zmag_kron = elms(689).toFloat
        val zflux_kron_err = elms(690).toDouble
        val zmag_kron_err = elms(691).toFloat
        val zflux_kron_radius = elms(692).toFloat
        val zflux_kron_radiusforradius = elms(693).toFloat
        val zflux_kron_psfradius = elms(694).toFloat
        val zflux_kron_apcorr = elms(695).toFloat
        val zflux_kron_apcorr_err = elms(696).toFloat
        val zflux_kron_flags = elms(697).toString
        val zflux_kron_flags_edge = elms(698).toString
        val zflux_kron_flags_radius = elms(699).toString
        val zflux_kron_flags_smallradius = elms(700).toString
        val zflux_kron_flags_usedminimumradius = elms(701).toString
        val zflux_kron_flags_usedpsfradius = elms(702).toString
        val zflux_kron_flags_badshape = elms(703).toString
        val zflux_kron_flags_apcorr = elms(704).toString
        val zflux_gaussian = elms(705).toDouble
        val zmag_gaussian = elms(706).toFloat
        val zflux_gaussian_err = elms(707).toDouble
        val zmag_gaussian_err = elms(708).toFloat
        val zflux_gaussian_apcorr = elms(709).toFloat
        val zflux_gaussian_apcorr_err = elms(710).toFloat
        val zflux_gaussian_flags = elms(711).toString
        val zflux_gaussian_flags_apcorr = elms(712).toString
        val zcmodel_initial_flux = elms(713).toDouble
        val zcmodel_initial_mag = elms(714).toFloat
        val zcmodel_initial_flux_err = elms(715).toDouble
        val zcmodel_initial_mag_err = elms(716).toFloat
        val zcmodel_initial_flux_inner = elms(717).toDouble
        val zcmodel_initial_mag_inner = elms(718).toFloat
        val zcmodel_initial_ellipse_11 = elms(719).toFloat
        val zcmodel_initial_ellipse_22 = elms(720).toFloat
        val zcmodel_initial_ellipse_12 = elms(721).toFloat
        val zcmodel_initial_objective = elms(722).toFloat
        val zcmodel_initial_nonlinear0 = elms(723).toFloat
        val zcmodel_initial_nonlinear1 = elms(724).toFloat
        val zcmodel_initial_nonlinear2 = elms(725).toFloat
        val zcmodel_initial_fixed0 = elms(726).toFloat
        val zcmodel_initial_fixed1 = elms(727).toFloat
        val zcmodel_initial_niter = elms(728).toInt
        val zcmodel_initial_time = elms(729).toFloat
        val zcmodel_exp_flux = elms(730).toDouble
        val zcmodel_exp_mag = elms(731).toFloat
        val zcmodel_exp_flux_err = elms(732).toDouble
        val zcmodel_exp_mag_err = elms(733).toFloat
        val zcmodel_exp_flux_inner = elms(734).toDouble
        val zcmodel_exp_mag_inner = elms(735).toFloat
        val zcmodel_exp_ellipse_11 = elms(736).toFloat
        val zcmodel_exp_ellipse_22 = elms(737).toFloat
        val zcmodel_exp_ellipse_12 = elms(738).toFloat
        val zcmodel_exp_objective = elms(739).toFloat
        val zcmodel_exp_nonlinear0 = elms(740).toFloat
        val zcmodel_exp_nonlinear1 = elms(741).toFloat
        val zcmodel_exp_nonlinear2 = elms(742).toFloat
        val zcmodel_exp_fixed0 = elms(743).toFloat
        val zcmodel_exp_fixed1 = elms(744).toFloat
        val zcmodel_exp_niter = elms(745).toInt
        val zcmodel_exp_time = elms(746).toFloat
        val zcmodel_dev_flux = elms(747).toDouble
        val zcmodel_dev_mag = elms(748).toFloat
        val zcmodel_dev_flux_err = elms(749).toDouble
        val zcmodel_dev_mag_err = elms(750).toFloat
        val zcmodel_dev_flux_inner = elms(751).toDouble
        val zcmodel_dev_mag_inner = elms(752).toFloat
        val zcmodel_dev_ellipse_11 = elms(753).toFloat
        val zcmodel_dev_ellipse_22 = elms(754).toFloat
        val zcmodel_dev_ellipse_12 = elms(755).toFloat
        val zcmodel_dev_objective = elms(756).toFloat
        val zcmodel_dev_nonlinear0 = elms(757).toFloat
        val zcmodel_dev_nonlinear1 = elms(758).toFloat
        val zcmodel_dev_nonlinear2 = elms(759).toFloat
        val zcmodel_dev_fixed0 = elms(760).toFloat
        val zcmodel_dev_fixed1 = elms(761).toFloat
        val zcmodel_dev_niter = elms(762).toInt
        val zcmodel_dev_time = elms(763).toFloat
        val zcmodel_center_ra = elms(764).toDouble
        val zcmodel_center_dec = elms(765).toDouble
        val zcmodel_flux = elms(766).toDouble
        val zcmodel_mag = elms(767).toFloat
        val zcmodel_flux_err = elms(768).toDouble
        val zcmodel_mag_err = elms(769).toFloat
        val zcmodel_flux_inner = elms(770).toDouble
        val zcmodel_mag_inner = elms(771).toFloat
        val zcmodel_fracdev = elms(772).toFloat
        val zcmodel_objective = elms(773).toFloat
        val zcmodel_ellipse_11 = elms(774).toFloat
        val zcmodel_ellipse_22 = elms(775).toFloat
        val zcmodel_ellipse_12 = elms(776).toFloat
        val zcmodel_region_initial_ellipse_11 = elms(777).toFloat
        val zcmodel_region_initial_ellipse_22 = elms(778).toFloat
        val zcmodel_region_initial_ellipse_12 = elms(779).toFloat
        val zcmodel_region_final_ellipse_11 = elms(780).toFloat
        val zcmodel_region_final_ellipse_22 = elms(781).toFloat
        val zcmodel_region_final_ellipse_12 = elms(782).toFloat
        val zcmodel_dev_flux_apcorr = elms(783).toFloat
        val zcmodel_dev_flux_apcorr_err = elms(784).toFloat
        val zcmodel_exp_flux_apcorr = elms(785).toFloat
        val zcmodel_exp_flux_apcorr_err = elms(786).toFloat
        val zcmodel_flux_apcorr = elms(787).toFloat
        val zcmodel_flux_apcorr_err = elms(788).toFloat
        val zcmodel_initial_flux_flags = elms(789).toString
        val zcmodel_initial_flags_trsmall = elms(790).toString
        val zcmodel_initial_flags_maxiter = elms(791).toString
        val zcmodel_initial_flags_numericerror = elms(792).toString
        val zcmodel_exp_flux_flags = elms(793).toString
        val zcmodel_exp_flags_trsmall = elms(794).toString
        val zcmodel_exp_flags_maxiter = elms(795).toString
        val zcmodel_exp_flags_numericerror = elms(796).toString
        val zcmodel_dev_flux_flags = elms(797).toString
        val zcmodel_dev_flags_trsmall = elms(798).toString
        val zcmodel_dev_flags_maxiter = elms(799).toString
        val zcmodel_dev_flags_numericerror = elms(800).toString
        val zcmodel_flux_flags = elms(801).toString
        val zcmodel_flags_region_maxarea = elms(802).toString
        val zcmodel_flags_region_maxbadpixelfraction = elms(803).toString
        val zcmodel_flags_region_usedfootprIntarea = elms(804).toString
        val zcmodel_flags_region_usedpsfarea = elms(805).toString
        val zcmodel_flags_region_usedinitialellipsemin = elms(806).toString
        val zcmodel_flags_region_usedinitialellipsemax = elms(807).toString
        val zcmodel_flags_noshape = elms(808).toString
        val zcmodel_flags_smallshape = elms(809).toString
        val zcmodel_flags_nopsf = elms(810).toString
        val zcmodel_flags_nowcs = elms(811).toString
        val zcmodel_flags_nocalib = elms(812).toString
        val zcmodel_flags_badcentroid = elms(813).toString
        val zcmodel_dev_flux_flags_apcorr = elms(814).toString
        val zcmodel_exp_flux_flags_apcorr = elms(815).toString
        val zcmodel_flux_flags_apcorr = elms(816).toString
        val zdeblend_psf_center_ra = elms(817).toDouble
        val zdeblend_psf_center_dec = elms(818).toDouble
        val zdeblend_psf_flux = elms(819).toDouble
        val zdeblend_psf_mag = elms(820).toFloat
        val zblendedness_old = elms(821).toFloat
        val zblendedness_raw_flux = elms(822).toFloat
        val zblendedness_raw_flux_child = elms(823).toDouble
        val zblendedness_raw_mag_child = elms(824).toFloat
        val zblendedness_raw_flux_parent = elms(825).toDouble
        val zblendedness_raw_mag_parent = elms(826).toFloat
        val zblendedness_abs_flux = elms(827).toFloat
        val zblendedness_abs_flux_child = elms(828).toDouble
        val zblendedness_abs_mag_child = elms(829).toFloat
        val zblendedness_abs_flux_parent = elms(830).toDouble
        val zblendedness_abs_mag_parent = elms(831).toFloat
        val zblendedness_raw_shape_child_11 = elms(832).toFloat
        val zblendedness_raw_shape_child_22 = elms(833).toFloat
        val zblendedness_raw_shape_child_12 = elms(834).toFloat
        val zblendedness_raw_shape_parent_11 = elms(835).toFloat
        val zblendedness_raw_shape_parent_22 = elms(836).toFloat
        val zblendedness_raw_shape_parent_12 = elms(837).toFloat
        val zblendedness_abs_shape_child_11 = elms(838).toFloat
        val zblendedness_abs_shape_child_22 = elms(839).toFloat
        val zblendedness_abs_shape_child_12 = elms(840).toFloat
        val zblendedness_abs_shape_parent_11 = elms(841).toFloat
        val zblendedness_abs_shape_parent_22 = elms(842).toFloat
        val zblendedness_abs_shape_parent_12 = elms(843).toFloat
        val zdeblend_deblended_as_psf = elms(844).toString
        val zdeblend_too_many_peaks = elms(845).toString
        val zdeblend_parent_too_big = elms(846).toString
        val zdeblend_masked = elms(847).toString
        val zdeblend_skipped = elms(848).toString
        val zdeblend_ramped_template = elms(849).toString
        val zdeblend_patched_template = elms(850).toString
        val zdeblend_has_stray_flux = elms(851).toString
        val zblendedness_flags = elms(852).toString
        val zblendedness_flags_nocentroid = elms(853).toString
        val zblendedness_flags_noshape = elms(854).toString
        val zcountinputs = elms(855).toInt
        val zclassification_extendedness = elms(856).toFloat
        val zflags_negative = elms(857).toString
        val zflags_badcentroid = elms(858).toString
        val zflags_pixel_edge = elms(859).toString
        val zflags_pixel_Interpolated_any = elms(860).toString
        val zflags_pixel_Interpolated_center = elms(861).toString
        val zflags_pixel_saturated_any = elms(862).toString
        val zflags_pixel_saturated_center = elms(863).toString
        val zflags_pixel_cr_any = elms(864).toString
        val zflags_pixel_cr_center = elms(865).toString
        val zflags_pixel_bad = elms(866).toString
        val zflags_pixel_suspect_any = elms(867).toString
        val zflags_pixel_suspect_center = elms(868).toString
        val zflags_pixel_offimage = elms(869).toString
        val zflags_pixel_bright_object_center = elms(870).toString
        val zflags_pixel_clipped_any = elms(871).toString
        val zflags_pixel_bright_object_any = elms(872).toString
        val zdetect_is_patch_inner = elms(873).toString
        val zdetect_is_tract_inner = elms(874).toString
        val zdetect_is_primary = elms(875).toString
        val zcalib_psf_candidate = elms(876).toString
        val zcalib_psf_used = elms(877).toString
        val yflux_naive = elms(878).toDouble
        val ymag_naive = elms(879).toFloat
        val yflux_naive_err = elms(880).toDouble
        val ymag_naive_err = elms(881).toFloat
        val yflux_naive_flags = elms(882).toString
        val yflux_sinc = elms(883).toDouble
        val ymag_sinc = elms(884).toFloat
        val yflux_sinc_err = elms(885).toDouble
        val ymag_sinc_err = elms(886).toFloat
        val yflux_sinc_flags = elms(887).toString
        val yflux_psf = elms(888).toDouble
        val ymag_psf = elms(889).toFloat
        val yflux_psf_err = elms(890).toDouble
        val ymag_psf_err = elms(891).toFloat
        val yflux_psf_apcorr = elms(892).toFloat
        val yflux_psf_apcorr_err = elms(893).toFloat
        val yflux_psf_flags = elms(894).toString
        val yflux_psf_flags_apcorr = elms(895).toString
        val yflux_kron = elms(896).toDouble
        val ymag_kron = elms(897).toFloat
        val yflux_kron_err = elms(898).toDouble
        val ymag_kron_err = elms(899).toFloat
        val yflux_kron_radius = elms(900).toFloat
        val yflux_kron_radiusforradius = elms(901).toFloat
        val yflux_kron_psfradius = elms(902).toFloat
        val yflux_kron_apcorr = elms(903).toFloat
        val yflux_kron_apcorr_err = elms(904).toFloat
        val yflux_kron_flags = elms(905).toString
        val yflux_kron_flags_edge = elms(906).toString
        val yflux_kron_flags_radius = elms(907).toString
        val yflux_kron_flags_smallradius = elms(908).toString
        val yflux_kron_flags_usedminimumradius = elms(909).toString
        val yflux_kron_flags_usedpsfradius = elms(910).toString
        val yflux_kron_flags_badshape = elms(911).toString
        val yflux_kron_flags_apcorr = elms(912).toString
        val yflux_gaussian = elms(913).toDouble
        val ymag_gaussian = elms(914).toFloat
        val yflux_gaussian_err = elms(915).toDouble
        val ymag_gaussian_err = elms(916).toFloat
        val yflux_gaussian_apcorr = elms(917).toFloat
        val yflux_gaussian_apcorr_err = elms(918).toFloat
        val yflux_gaussian_flags = elms(919).toString
        val yflux_gaussian_flags_apcorr = elms(920).toString
        val ycmodel_initial_flux = elms(921).toDouble
        val ycmodel_initial_mag = elms(922).toFloat
        val ycmodel_initial_flux_err = elms(923).toDouble
        val ycmodel_initial_mag_err = elms(924).toFloat
        val ycmodel_initial_flux_inner = elms(925).toDouble
        val ycmodel_initial_mag_inner = elms(926).toFloat
        val ycmodel_initial_ellipse_11 = elms(927).toFloat
        val ycmodel_initial_ellipse_22 = elms(928).toFloat
        val ycmodel_initial_ellipse_12 = elms(929).toFloat
        val ycmodel_initial_objective = elms(930).toFloat
        val ycmodel_initial_nonlinear0 = elms(931).toFloat
        val ycmodel_initial_nonlinear1 = elms(932).toFloat
        val ycmodel_initial_nonlinear2 = elms(933).toFloat
        val ycmodel_initial_fixed0 = elms(934).toFloat
        val ycmodel_initial_fixed1 = elms(935).toFloat
        val ycmodel_initial_niter = elms(936).toInt
        val ycmodel_initial_time = elms(937).toFloat
        val ycmodel_exp_flux = elms(938).toDouble
        val ycmodel_exp_mag = elms(939).toFloat
        val ycmodel_exp_flux_err = elms(940).toDouble
        val ycmodel_exp_mag_err = elms(941).toFloat
        val ycmodel_exp_flux_inner = elms(942).toDouble
        val ycmodel_exp_mag_inner = elms(943).toFloat
        val ycmodel_exp_ellipse_11 = elms(944).toFloat
        val ycmodel_exp_ellipse_22 = elms(945).toFloat
        val ycmodel_exp_ellipse_12 = elms(946).toFloat
        val ycmodel_exp_objective = elms(947).toFloat
        val ycmodel_exp_nonlinear0 = elms(948).toFloat
        val ycmodel_exp_nonlinear1 = elms(949).toFloat
        val ycmodel_exp_nonlinear2 = elms(950).toFloat
        val ycmodel_exp_fixed0 = elms(951).toFloat
        val ycmodel_exp_fixed1 = elms(952).toFloat
        val ycmodel_exp_niter = elms(953).toInt
        val ycmodel_exp_time = elms(954).toFloat
        val ycmodel_dev_flux = elms(955).toDouble
        val ycmodel_dev_mag = elms(956).toFloat
        val ycmodel_dev_flux_err = elms(957).toDouble
        val ycmodel_dev_mag_err = elms(958).toFloat
        val ycmodel_dev_flux_inner = elms(959).toDouble
        val ycmodel_dev_mag_inner = elms(960).toFloat
        val ycmodel_dev_ellipse_11 = elms(961).toFloat
        val ycmodel_dev_ellipse_22 = elms(962).toFloat
        val ycmodel_dev_ellipse_12 = elms(963).toFloat
        val ycmodel_dev_objective = elms(964).toFloat
        val ycmodel_dev_nonlinear0 = elms(965).toFloat
        val ycmodel_dev_nonlinear1 = elms(966).toFloat
        val ycmodel_dev_nonlinear2 = elms(967).toFloat
        val ycmodel_dev_fixed0 = elms(968).toFloat
        val ycmodel_dev_fixed1 = elms(969).toFloat
        val ycmodel_dev_niter = elms(970).toInt
        val ycmodel_dev_time = elms(971).toFloat
        val ycmodel_center_ra = elms(972).toDouble
        val ycmodel_center_dec = elms(973).toDouble
        val ycmodel_flux = elms(974).toDouble
        val ycmodel_mag = elms(975).toFloat
        val ycmodel_flux_err = elms(976).toDouble
        val ycmodel_mag_err = elms(977).toFloat
        val ycmodel_flux_inner = elms(978).toDouble
        val ycmodel_mag_inner = elms(979).toFloat
        val ycmodel_fracdev = elms(980).toFloat
        val ycmodel_objective = elms(981).toFloat
        val ycmodel_ellipse_11 = elms(982).toFloat
        val ycmodel_ellipse_22 = elms(983).toFloat
        val ycmodel_ellipse_12 = elms(984).toFloat
        val ycmodel_region_initial_ellipse_11 = elms(985).toFloat
        val ycmodel_region_initial_ellipse_22 = elms(986).toFloat
        val ycmodel_region_initial_ellipse_12 = elms(987).toFloat
        val ycmodel_region_final_ellipse_11 = elms(988).toFloat
        val ycmodel_region_final_ellipse_22 = elms(989).toFloat
        val ycmodel_region_final_ellipse_12 = elms(990).toFloat
        val ycmodel_dev_flux_apcorr = elms(991).toFloat
        val ycmodel_dev_flux_apcorr_err = elms(992).toFloat
        val ycmodel_exp_flux_apcorr = elms(993).toFloat
        val ycmodel_exp_flux_apcorr_err = elms(994).toFloat
        val ycmodel_flux_apcorr = elms(995).toFloat
        val ycmodel_flux_apcorr_err = elms(996).toFloat
        val ycmodel_initial_flux_flags = elms(997).toString
        val ycmodel_initial_flags_trsmall = elms(998).toString
        val ycmodel_initial_flags_maxiter = elms(999).toString
        val ycmodel_initial_flags_numericerror = elms(1000).toString
        val ycmodel_exp_flux_flags = elms(1001).toString
        val ycmodel_exp_flags_trsmall = elms(1002).toString
        val ycmodel_exp_flags_maxiter = elms(1003).toString
        val ycmodel_exp_flags_numericerror = elms(1004).toString
        val ycmodel_dev_flux_flags = elms(1005).toString
        val ycmodel_dev_flags_trsmall = elms(1006).toString
        val ycmodel_dev_flags_maxiter = elms(1007).toString
        val ycmodel_dev_flags_numericerror = elms(1008).toString
        val ycmodel_flux_flags = elms(1009).toString
        val ycmodel_flags_region_maxarea = elms(1010).toString
        val ycmodel_flags_region_maxbadpixelfraction = elms(1011).toString
        val ycmodel_flags_region_usedfootprIntarea = elms(1012).toString
        val ycmodel_flags_region_usedpsfarea = elms(1013).toString
        val ycmodel_flags_region_usedinitialellipsemin = elms(1014).toString
        val ycmodel_flags_region_usedinitialellipsemax = elms(1015).toString
        val ycmodel_flags_noshape = elms(1016).toString
        val ycmodel_flags_smallshape = elms(1017).toString
        val ycmodel_flags_nopsf = elms(1018).toString
        val ycmodel_flags_nowcs = elms(1019).toString
        val ycmodel_flags_nocalib = elms(1020).toString
        val ycmodel_flags_badcentroid = elms(1021).toString
        val ycmodel_dev_flux_flags_apcorr = elms(1022).toString
        val ycmodel_exp_flux_flags_apcorr = elms(1023).toString
        val ycmodel_flux_flags_apcorr = elms(1024).toString
        val ydeblend_psf_center_ra = elms(1025).toDouble
        val ydeblend_psf_center_dec = elms(1026).toDouble
        val ydeblend_psf_flux = elms(1027).toDouble
        val ydeblend_psf_mag = elms(1028).toFloat
        val yblendedness_old = elms(1029).toFloat
        val yblendedness_raw_flux = elms(1030).toFloat
        val yblendedness_raw_flux_child = elms(1031).toDouble
        val yblendedness_raw_mag_child = elms(1032).toFloat
        val yblendedness_raw_flux_parent = elms(1033).toDouble
        val yblendedness_raw_mag_parent = elms(1034).toFloat
        val yblendedness_abs_flux = elms(1035).toFloat
        val yblendedness_abs_flux_child = elms(1036).toDouble
        val yblendedness_abs_mag_child = elms(1037).toFloat
        val yblendedness_abs_flux_parent = elms(1038).toDouble
        val yblendedness_abs_mag_parent = elms(1039).toFloat
        val yblendedness_raw_shape_child_11 = elms(1040).toFloat
        val yblendedness_raw_shape_child_22 = elms(1041).toFloat
        val yblendedness_raw_shape_child_12 = elms(1042).toFloat
        val yblendedness_raw_shape_parent_11 = elms(1043).toFloat
        val yblendedness_raw_shape_parent_22 = elms(1044).toFloat
        val yblendedness_raw_shape_parent_12 = elms(1045).toFloat
        val yblendedness_abs_shape_child_11 = elms(1046).toFloat
        val yblendedness_abs_shape_child_22 = elms(1047).toFloat
        val yblendedness_abs_shape_child_12 = elms(1048).toFloat
        val yblendedness_abs_shape_parent_11 = elms(1049).toFloat
        val yblendedness_abs_shape_parent_22 = elms(1050).toFloat
        val yblendedness_abs_shape_parent_12 = elms(1051).toFloat
        val ydeblend_deblended_as_psf = elms(1052).toString
        val ydeblend_too_many_peaks = elms(1053).toString
        val ydeblend_parent_too_big = elms(1054).toString
        val ydeblend_masked = elms(1055).toString
        val ydeblend_skipped = elms(1056).toString
        val ydeblend_ramped_template = elms(1057).toString
        val ydeblend_patched_template = elms(1058).toString
        val ydeblend_has_stray_flux = elms(1059).toString
        val yblendedness_flags = elms(1060).toString
        val yblendedness_flags_nocentroid = elms(1061).toString
        val yblendedness_flags_noshape = elms(1062).toString
        val ycountinputs = elms(1063).toInt
        val yclassification_extendedness = elms(1064).toFloat
        val yflags_negative = elms(1065).toString
        val yflags_badcentroid = elms(1066).toString
        val yflags_pixel_edge = elms(1067).toString
        val yflags_pixel_Interpolated_any = elms(1068).toString
        val yflags_pixel_Interpolated_center = elms(1069).toString
        val yflags_pixel_saturated_any = elms(1070).toString
        val yflags_pixel_saturated_center = elms(1071).toString
        val yflags_pixel_cr_any = elms(1072).toString
        val yflags_pixel_cr_center = elms(1073).toString
        val yflags_pixel_bad = elms(1074).toString
        val yflags_pixel_suspect_any = elms(1075).toString
        val yflags_pixel_suspect_center = elms(1076).toString
        val yflags_pixel_offimage = elms(1077).toString
        val yflags_pixel_bright_object_center = elms(1078).toString
        val yflags_pixel_clipped_any = elms(1079).toString
        val yflags_pixel_bright_object_any = elms(1080).toString
        val ydetect_is_patch_inner = elms(1081).toString
        val ydetect_is_tract_inner = elms(1082).toString
        val ydetect_is_primary = elms(1083).toString
        val ycalib_psf_candidate = elms(1084).toString
        val ycalib_psf_used = elms(1085).toString
        (
          object_id
          , gra
          , gdec
          , gcoord
          , rra
          , rdec
          , rcoord
          , ira
          , idec
          , icoord
          , zra
          , zdec
          , zcoord
          , yra
          , ydec
          , ycoord
          , skymap_id
          , tract
          , patch
          , patch_s
          , parent_id bigint
          , deblend_nchild
          , merge_footprint_i2
          , merge_footprint_i
          , merge_footprint_r
          , merge_footprint_z
          , merge_footprint_y
          , merge_footprint_g
          , merge_footprint_n921
          , merge_footprint_n816
          , merge_footprint_n1010
          , merge_footprint_n387
          , merge_footprint_n515
          , merge_footprint_sky
          , merge_peak_i2
          , merge_peak_i
          , merge_peak_r
          , merge_peak_z
          , merge_peak_y
          , merge_peak_g
          , merge_peak_n921
          , merge_peak_n816
          , merge_peak_n1010
          , merge_peak_n387
          , merge_peak_n515
          , merge_peak_sky
          , gflux_naive
          , gmag_naive
          , gflux_naive_err
          , gmag_naive_err
          , gflux_naive_flags
          , gflux_sinc
          , gmag_sinc
          , gflux_sinc_err
          , gmag_sinc_err
          , gflux_sinc_flags
          , gflux_psf
          , gmag_psf
          , gflux_psf_err
          , gmag_psf_err
          , gflux_psf_apcorr
          , gflux_psf_apcorr_err
          , gflux_psf_flags
          , gflux_psf_flags_apcorr
          , gflux_kron
          , gmag_kron
          , gflux_kron_err
          , gmag_kron_err
          , gflux_kron_radius
          , gflux_kron_radiusforradius
          , gflux_kron_psfradius
          , gflux_kron_apcorr
          , gflux_kron_apcorr_err
          , gflux_kron_flags
          , gflux_kron_flags_edge
          , gflux_kron_flags_radius
          , gflux_kron_flags_smallradius
          , gflux_kron_flags_usedminimumradius
          , gflux_kron_flags_usedpsfradius
          , gflux_kron_flags_badshape
          , gflux_kron_flags_apcorr
          , gflux_gaussian
          , gmag_gaussian
          , gflux_gaussian_err
          , gmag_gaussian_err
          , gflux_gaussian_apcorr
          , gflux_gaussian_apcorr_err
          , gflux_gaussian_flags
          , gflux_gaussian_flags_apcorr
          , gcmodel_initial_flux
          , gcmodel_initial_mag
          , gcmodel_initial_flux_err
          , gcmodel_initial_mag_err
          , gcmodel_initial_flux_inner
          , gcmodel_initial_mag_inner
          , gcmodel_initial_ellipse_11
          , gcmodel_initial_ellipse_22
          , gcmodel_initial_ellipse_12
          , gcmodel_initial_objective
          , gcmodel_initial_nonlinear0
          , gcmodel_initial_nonlinear1
          , gcmodel_initial_nonlinear2
          , gcmodel_initial_fixed0
          , gcmodel_initial_fixed1
          , gcmodel_initial_niter
          , gcmodel_initial_time
          , gcmodel_exp_flux
          , gcmodel_exp_mag
          , gcmodel_exp_flux_err
          , gcmodel_exp_mag_err
          , gcmodel_exp_flux_inner
          , gcmodel_exp_mag_inner
          , gcmodel_exp_ellipse_11
          , gcmodel_exp_ellipse_22
          , gcmodel_exp_ellipse_12
          , gcmodel_exp_objective
          , gcmodel_exp_nonlinear0
          , gcmodel_exp_nonlinear1
          , gcmodel_exp_nonlinear2
          , gcmodel_exp_fixed0
          , gcmodel_exp_fixed1
          , gcmodel_exp_niter
          , gcmodel_exp_time
          , gcmodel_dev_flux
          , gcmodel_dev_mag
          , gcmodel_dev_flux_err
          , gcmodel_dev_mag_err
          , gcmodel_dev_flux_inner
          , gcmodel_dev_mag_inner
          , gcmodel_dev_ellipse_11
          , gcmodel_dev_ellipse_22
          , gcmodel_dev_ellipse_12
          , gcmodel_dev_objective
          , gcmodel_dev_nonlinear0
          , gcmodel_dev_nonlinear1
          , gcmodel_dev_nonlinear2
          , gcmodel_dev_fixed0
          , gcmodel_dev_fixed1
          , gcmodel_dev_niter
          , gcmodel_dev_time
          , gcmodel_center_ra
          , gcmodel_center_dec
          , gcmodel_flux
          , gcmodel_mag
          , gcmodel_flux_err
          , gcmodel_mag_err
          , gcmodel_flux_inner
          , gcmodel_mag_inner
          , gcmodel_fracdev
          , gcmodel_objective
          , gcmodel_ellipse_11
          , gcmodel_ellipse_22
          , gcmodel_ellipse_12
          , gcmodel_region_initial_ellipse_11
          , gcmodel_region_initial_ellipse_22
          , gcmodel_region_initial_ellipse_12
          , gcmodel_region_final_ellipse_11
          , gcmodel_region_final_ellipse_22
          , gcmodel_region_final_ellipse_12
          , gcmodel_dev_flux_apcorr
          , gcmodel_dev_flux_apcorr_err
          , gcmodel_exp_flux_apcorr
          , gcmodel_exp_flux_apcorr_err
          , gcmodel_flux_apcorr
          , gcmodel_flux_apcorr_err
          , gcmodel_initial_flux_flags
          , gcmodel_initial_flags_trsmall
          , gcmodel_initial_flags_maxiter
          , gcmodel_initial_flags_numericerror
          , gcmodel_exp_flux_flags
          , gcmodel_exp_flags_trsmall
          , gcmodel_exp_flags_maxiter
          , gcmodel_exp_flags_numericerror
          , gcmodel_dev_flux_flags
          , gcmodel_dev_flags_trsmall
          , gcmodel_dev_flags_maxiter
          , gcmodel_dev_flags_numericerror
          , gcmodel_flux_flags
          , gcmodel_flags_region_maxarea
          , gcmodel_flags_region_maxbadpixelfraction
          , gcmodel_flags_region_usedfootprintarea
          , gcmodel_flags_region_usedpsfarea
          , gcmodel_flags_region_usedinitialellipsemin
          , gcmodel_flags_region_usedinitialellipsemax
          , gcmodel_flags_noshape
          , gcmodel_flags_smallshape
          , gcmodel_flags_nopsf
          , gcmodel_flags_nowcs
          , gcmodel_flags_nocalib
          , gcmodel_flags_badcentroid
          , gcmodel_dev_flux_flags_apcorr
          , gcmodel_exp_flux_flags_apcorr
          , gcmodel_flux_flags_apcorr
          , gdeblend_psf_center_ra
          , gdeblend_psf_center_dec
          , gdeblend_psf_flux
          , gdeblend_psf_mag
          , gblendedness_old
          , gblendedness_raw_flux
          , gblendedness_raw_flux_child
          , gblendedness_raw_mag_child
          , gblendedness_raw_flux_parent
          , gblendedness_raw_mag_parent
          , gblendedness_abs_flux
          , gblendedness_abs_flux_child
          , gblendedness_abs_mag_child
          , gblendedness_abs_flux_parent
          , gblendedness_abs_mag_parent
          , gblendedness_raw_shape_child_11
          , gblendedness_raw_shape_child_22
          , gblendedness_raw_shape_child_12
          , gblendedness_raw_shape_parent_11
          , gblendedness_raw_shape_parent_22
          , gblendedness_raw_shape_parent_12
          , gblendedness_abs_shape_child_11
          , gblendedness_abs_shape_child_22
          , gblendedness_abs_shape_child_12
          , gblendedness_abs_shape_parent_11
          , gblendedness_abs_shape_parent_22
          , gblendedness_abs_shape_parent_12
          , gdeblend_deblended_as_psf
          , gdeblend_too_many_peaks
          , gdeblend_parent_too_big
          , gdeblend_masked
          , gdeblend_skipped
          , gdeblend_ramped_template
          , gdeblend_patched_template
          , gdeblend_has_stray_flux
          , gblendedness_flags
          , gblendedness_flags_nocentroid
          , gblendedness_flags_noshape
          , gcountinputs smallint
          , gclassification_extendedness
          , gflags_negative
          , gflags_badcentroid
          , gflags_pixel_edge
          , gflags_pixel_interpolated_any
          , gflags_pixel_interpolated_center
          , gflags_pixel_saturated_any
          , gflags_pixel_saturated_center
          , gflags_pixel_cr_any
          , gflags_pixel_cr_center
          , gflags_pixel_bad
          , gflags_pixel_suspect_any
          , gflags_pixel_suspect_center
          , gflags_pixel_offimage
          , gflags_pixel_bright_object_center
          , gflags_pixel_clipped_any
          , gflags_pixel_bright_object_any
          , gdetect_is_patch_inner
          , gdetect_is_tract_inner
          , gdetect_is_primary
          , gcalib_psf_candidate
          , gcalib_psf_used
          , rflux_naive
          , rmag_naive
          , rflux_naive_err
          , rmag_naive_err
          , rflux_naive_flags
          , rflux_sinc
          , rmag_sinc
          , rflux_sinc_err
          , rmag_sinc_err
          , rflux_sinc_flags
          , rflux_psf
          , rmag_psf
          , rflux_psf_err
          , rmag_psf_err
          , rflux_psf_apcorr
          , rflux_psf_apcorr_err
          , rflux_psf_flags
          , rflux_psf_flags_apcorr
          , rflux_kron
          , rmag_kron
          , rflux_kron_err
          , rmag_kron_err
          , rflux_kron_radius
          , rflux_kron_radiusforradius
          , rflux_kron_psfradius
          , rflux_kron_apcorr
          , rflux_kron_apcorr_err
          , rflux_kron_flags
          , rflux_kron_flags_edge
          , rflux_kron_flags_radius
          , rflux_kron_flags_smallradius
          , rflux_kron_flags_usedminimumradius
          , rflux_kron_flags_usedpsfradius
          , rflux_kron_flags_badshape
          , rflux_kron_flags_apcorr
          , rflux_gaussian
          , rmag_gaussian
          , rflux_gaussian_err
          , rmag_gaussian_err
          , rflux_gaussian_apcorr
          , rflux_gaussian_apcorr_err
          , rflux_gaussian_flags
          , rflux_gaussian_flags_apcorr
          , rcmodel_initial_flux
          , rcmodel_initial_mag
          , rcmodel_initial_flux_err
          , rcmodel_initial_mag_err
          , rcmodel_initial_flux_inner
          , rcmodel_initial_mag_inner
          , rcmodel_initial_ellipse_11
          , rcmodel_initial_ellipse_22
          , rcmodel_initial_ellipse_12
          , rcmodel_initial_objective
          , rcmodel_initial_nonlinear0
          , rcmodel_initial_nonlinear1
          , rcmodel_initial_nonlinear2
          , rcmodel_initial_fixed0
          , rcmodel_initial_fixed1
          , rcmodel_initial_niter
          , rcmodel_initial_time
          , rcmodel_exp_flux
          , rcmodel_exp_mag
          , rcmodel_exp_flux_err
          , rcmodel_exp_mag_err
          , rcmodel_exp_flux_inner
          , rcmodel_exp_mag_inner
          , rcmodel_exp_ellipse_11
          , rcmodel_exp_ellipse_22
          , rcmodel_exp_ellipse_12
          , rcmodel_exp_objective
          , rcmodel_exp_nonlinear0
          , rcmodel_exp_nonlinear1
          , rcmodel_exp_nonlinear2
          , rcmodel_exp_fixed0
          , rcmodel_exp_fixed1
          , rcmodel_exp_niter
          , rcmodel_exp_time
          , rcmodel_dev_flux
          , rcmodel_dev_mag
          , rcmodel_dev_flux_err
          , rcmodel_dev_mag_err
          , rcmodel_dev_flux_inner
          , rcmodel_dev_mag_inner
          , rcmodel_dev_ellipse_11
          , rcmodel_dev_ellipse_22
          , rcmodel_dev_ellipse_12
          , rcmodel_dev_objective
          , rcmodel_dev_nonlinear0
          , rcmodel_dev_nonlinear1
          , rcmodel_dev_nonlinear2
          , rcmodel_dev_fixed0
          , rcmodel_dev_fixed1
          , rcmodel_dev_niter
          , rcmodel_dev_time
          , rcmodel_center_ra
          , rcmodel_center_dec
          , rcmodel_flux
          , rcmodel_mag
          , rcmodel_flux_err
          , rcmodel_mag_err
          , rcmodel_flux_inner
          , rcmodel_mag_inner
          , rcmodel_fracdev
          , rcmodel_objective
          , rcmodel_ellipse_11
          , rcmodel_ellipse_22
          , rcmodel_ellipse_12
          , rcmodel_region_initial_ellipse_11
          , rcmodel_region_initial_ellipse_22
          , rcmodel_region_initial_ellipse_12
          , rcmodel_region_final_ellipse_11
          , rcmodel_region_final_ellipse_22
          , rcmodel_region_final_ellipse_12
          , rcmodel_dev_flux_apcorr
          , rcmodel_dev_flux_apcorr_err
          , rcmodel_exp_flux_apcorr
          , rcmodel_exp_flux_apcorr_err
          , rcmodel_flux_apcorr
          , rcmodel_flux_apcorr_err
          , rcmodel_initial_flux_flags
          , rcmodel_initial_flags_trsmall
          , rcmodel_initial_flags_maxiter
          , rcmodel_initial_flags_numericerror
          , rcmodel_exp_flux_flags
          , rcmodel_exp_flags_trsmall
          , rcmodel_exp_flags_maxiter
          , rcmodel_exp_flags_numericerror
          , rcmodel_dev_flux_flags
          , rcmodel_dev_flags_trsmall
          , rcmodel_dev_flags_maxiter
          , rcmodel_dev_flags_numericerror
          , rcmodel_flux_flags
          , rcmodel_flags_region_maxarea
          , rcmodel_flags_region_maxbadpixelfraction
          , rcmodel_flags_region_usedfootprintarea
          , rcmodel_flags_region_usedpsfarea
          , rcmodel_flags_region_usedinitialellipsemin
          , rcmodel_flags_region_usedinitialellipsemax
          , rcmodel_flags_noshape
          , rcmodel_flags_smallshape
          , rcmodel_flags_nopsf
          , rcmodel_flags_nowcs
          , rcmodel_flags_nocalib
          , rcmodel_flags_badcentroid
          , rcmodel_dev_flux_flags_apcorr
          , rcmodel_exp_flux_flags_apcorr
          , rcmodel_flux_flags_apcorr
          , rdeblend_psf_center_ra
          , rdeblend_psf_center_dec
          , rdeblend_psf_flux
          , rdeblend_psf_mag
          , rblendedness_old
          , rblendedness_raw_flux
          , rblendedness_raw_flux_child
          , rblendedness_raw_mag_child
          , rblendedness_raw_flux_parent
          , rblendedness_raw_mag_parent
          , rblendedness_abs_flux
          , rblendedness_abs_flux_child
          , rblendedness_abs_mag_child
          , rblendedness_abs_flux_parent
          , rblendedness_abs_mag_parent
          , rblendedness_raw_shape_child_11
          , rblendedness_raw_shape_child_22
          , rblendedness_raw_shape_child_12
          , rblendedness_raw_shape_parent_11
          , rblendedness_raw_shape_parent_22
          , rblendedness_raw_shape_parent_12
          , rblendedness_abs_shape_child_11
          , rblendedness_abs_shape_child_22
          , rblendedness_abs_shape_child_12
          , rblendedness_abs_shape_parent_11
          , rblendedness_abs_shape_parent_22
          , rblendedness_abs_shape_parent_12
          , rdeblend_deblended_as_psf
          , rdeblend_too_many_peaks
          , rdeblend_parent_too_big
          , rdeblend_masked
          , rdeblend_skipped
          , rdeblend_ramped_template
          , rdeblend_patched_template
          , rdeblend_has_stray_flux
          , rblendedness_flags
          , rblendedness_flags_nocentroid
          , rblendedness_flags_noshape
          , rcountinputs smallint
          , rclassification_extendedness
          , rflags_negative
          , rflags_badcentroid
          , rflags_pixel_edge
          , rflags_pixel_interpolated_any
          , rflags_pixel_interpolated_center
          , rflags_pixel_saturated_any
          , rflags_pixel_saturated_center
          , rflags_pixel_cr_any
          , rflags_pixel_cr_center
          , rflags_pixel_bad
          , rflags_pixel_suspect_any
          , rflags_pixel_suspect_center
          , rflags_pixel_offimage
          , rflags_pixel_bright_object_center
          , rflags_pixel_clipped_any
          , rflags_pixel_bright_object_any
          , rdetect_is_patch_inner
          , rdetect_is_tract_inner
          , rdetect_is_primary
          , rcalib_psf_candidate
          , rcalib_psf_used
          , iflux_naive
          , imag_naive
          , iflux_naive_err
          , imag_naive_err
          , iflux_naive_flags
          , iflux_sinc
          , imag_sinc
          , iflux_sinc_err
          , imag_sinc_err
          , iflux_sinc_flags
          , iflux_psf
          , imag_psf
          , iflux_psf_err
          , imag_psf_err
          , iflux_psf_apcorr
          , iflux_psf_apcorr_err
          , iflux_psf_flags
          , iflux_psf_flags_apcorr
          , iflux_kron
          , imag_kron
          , iflux_kron_err
          , imag_kron_err
          , iflux_kron_radius
          , iflux_kron_radiusforradius
          , iflux_kron_psfradius
          , iflux_kron_apcorr
          , iflux_kron_apcorr_err
          , iflux_kron_flags
          , iflux_kron_flags_edge
          , iflux_kron_flags_radius
          , iflux_kron_flags_smallradius
          , iflux_kron_flags_usedminimumradius
          , iflux_kron_flags_usedpsfradius
          , iflux_kron_flags_badshape
          , iflux_kron_flags_apcorr
          , iflux_gaussian
          , imag_gaussian
          , iflux_gaussian_err
          , imag_gaussian_err
          , iflux_gaussian_apcorr
          , iflux_gaussian_apcorr_err
          , iflux_gaussian_flags
          , iflux_gaussian_flags_apcorr
          , icmodel_initial_flux
          , icmodel_initial_mag
          , icmodel_initial_flux_err
          , icmodel_initial_mag_err
          , icmodel_initial_flux_inner
          , icmodel_initial_mag_inner
          , icmodel_initial_ellipse_11
          , icmodel_initial_ellipse_22
          , icmodel_initial_ellipse_12
          , icmodel_initial_objective
          , icmodel_initial_nonlinear0
          , icmodel_initial_nonlinear1
          , icmodel_initial_nonlinear2
          , icmodel_initial_fixed0
          , icmodel_initial_fixed1
          , icmodel_initial_niter
          , icmodel_initial_time
          , icmodel_exp_flux
          , icmodel_exp_mag
          , icmodel_exp_flux_err
          , icmodel_exp_mag_err
          , icmodel_exp_flux_inner
          , icmodel_exp_mag_inner
          , icmodel_exp_ellipse_11
          , icmodel_exp_ellipse_22
          , icmodel_exp_ellipse_12
          , icmodel_exp_objective
          , icmodel_exp_nonlinear0
          , icmodel_exp_nonlinear1
          , icmodel_exp_nonlinear2
          , icmodel_exp_fixed0
          , icmodel_exp_fixed1
          , icmodel_exp_niter
          , icmodel_exp_time
          , icmodel_dev_flux
          , icmodel_dev_mag
          , icmodel_dev_flux_err
          , icmodel_dev_mag_err
          , icmodel_dev_flux_inner
          , icmodel_dev_mag_inner
          , icmodel_dev_ellipse_11
          , icmodel_dev_ellipse_22
          , icmodel_dev_ellipse_12
          , icmodel_dev_objective
          , icmodel_dev_nonlinear0
          , icmodel_dev_nonlinear1
          , icmodel_dev_nonlinear2
          , icmodel_dev_fixed0
          , icmodel_dev_fixed1
          , icmodel_dev_niter
          , icmodel_dev_time
          , icmodel_center_ra
          , icmodel_center_dec
          , icmodel_flux
          , icmodel_mag
          , icmodel_flux_err
          , icmodel_mag_err
          , icmodel_flux_inner
          , icmodel_mag_inner
          , icmodel_fracdev
          , icmodel_objective
          , icmodel_ellipse_11
          , icmodel_ellipse_22
          , icmodel_ellipse_12
          , icmodel_region_initial_ellipse_11
          , icmodel_region_initial_ellipse_22
          , icmodel_region_initial_ellipse_12
          , icmodel_region_final_ellipse_11
          , icmodel_region_final_ellipse_22
          , icmodel_region_final_ellipse_12
          , icmodel_dev_flux_apcorr
          , icmodel_dev_flux_apcorr_err
          , icmodel_exp_flux_apcorr
          , icmodel_exp_flux_apcorr_err
          , icmodel_flux_apcorr
          , icmodel_flux_apcorr_err
          , icmodel_initial_flux_flags
          , icmodel_initial_flags_trsmall
          , icmodel_initial_flags_maxiter
          , icmodel_initial_flags_numericerror
          , icmodel_exp_flux_flags
          , icmodel_exp_flags_trsmall
          , icmodel_exp_flags_maxiter
          , icmodel_exp_flags_numericerror
          , icmodel_dev_flux_flags
          , icmodel_dev_flags_trsmall
          , icmodel_dev_flags_maxiter
          , icmodel_dev_flags_numericerror
          , icmodel_flux_flags
          , icmodel_flags_region_maxarea
          , icmodel_flags_region_maxbadpixelfraction
          , icmodel_flags_region_usedfootprintarea
          , icmodel_flags_region_usedpsfarea
          , icmodel_flags_region_usedinitialellipsemin
          , icmodel_flags_region_usedinitialellipsemax
          , icmodel_flags_noshape
          , icmodel_flags_smallshape
          , icmodel_flags_nopsf
          , icmodel_flags_nowcs
          , icmodel_flags_nocalib
          , icmodel_flags_badcentroid
          , icmodel_dev_flux_flags_apcorr
          , icmodel_exp_flux_flags_apcorr
          , icmodel_flux_flags_apcorr
          , ideblend_psf_center_ra
          , ideblend_psf_center_dec
          , ideblend_psf_flux
          , ideblend_psf_mag
          , iblendedness_old
          , iblendedness_raw_flux
          , iblendedness_raw_flux_child
          , iblendedness_raw_mag_child
          , iblendedness_raw_flux_parent
          , iblendedness_raw_mag_parent
          , iblendedness_abs_flux
          , iblendedness_abs_flux_child
          , iblendedness_abs_mag_child
          , iblendedness_abs_flux_parent
          , iblendedness_abs_mag_parent
          , iblendedness_raw_shape_child_11
          , iblendedness_raw_shape_child_22
          , iblendedness_raw_shape_child_12
          , iblendedness_raw_shape_parent_11
          , iblendedness_raw_shape_parent_22
          , iblendedness_raw_shape_parent_12
          , iblendedness_abs_shape_child_11
          , iblendedness_abs_shape_child_22
          , iblendedness_abs_shape_child_12
          , iblendedness_abs_shape_parent_11
          , iblendedness_abs_shape_parent_22
          , iblendedness_abs_shape_parent_12
          , ideblend_deblended_as_psf
          , ideblend_too_many_peaks
          , ideblend_parent_too_big
          , ideblend_masked
          , ideblend_skipped
          , ideblend_ramped_template
          , ideblend_patched_template
          , ideblend_has_stray_flux
          , iblendedness_flags
          , iblendedness_flags_nocentroid
          , iblendedness_flags_noshape
          , icountinputs smallint
          , iclassification_extendedness
          , iflags_negative
          , iflags_badcentroid
          , iflags_pixel_edge
          , iflags_pixel_interpolated_any
          , iflags_pixel_interpolated_center
          , iflags_pixel_saturated_any
          , iflags_pixel_saturated_center
          , iflags_pixel_cr_any
          , iflags_pixel_cr_center
          , iflags_pixel_bad
          , iflags_pixel_suspect_any
          , iflags_pixel_suspect_center
          , iflags_pixel_offimage
          , iflags_pixel_bright_object_center
          , iflags_pixel_clipped_any
          , iflags_pixel_bright_object_any
          , idetect_is_patch_inner
          , idetect_is_tract_inner
          , idetect_is_primary
          , icalib_psf_candidate
          , icalib_psf_used
          , zflux_naive
          , zmag_naive
          , zflux_naive_err
          , zmag_naive_err
          , zflux_naive_flags
          , zflux_sinc
          , zmag_sinc
          , zflux_sinc_err
          , zmag_sinc_err
          , zflux_sinc_flags
          , zflux_psf
          , zmag_psf
          , zflux_psf_err
          , zmag_psf_err
          , zflux_psf_apcorr
          , zflux_psf_apcorr_err
          , zflux_psf_flags
          , zflux_psf_flags_apcorr
          , zflux_kron
          , zmag_kron
          , zflux_kron_err
          , zmag_kron_err
          , zflux_kron_radius
          , zflux_kron_radiusforradius
          , zflux_kron_psfradius
          , zflux_kron_apcorr
          , zflux_kron_apcorr_err
          , zflux_kron_flags
          , zflux_kron_flags_edge
          , zflux_kron_flags_radius
          , zflux_kron_flags_smallradius
          , zflux_kron_flags_usedminimumradius
          , zflux_kron_flags_usedpsfradius
          , zflux_kron_flags_badshape
          , zflux_kron_flags_apcorr
          , zflux_gaussian
          , zmag_gaussian
          , zflux_gaussian_err
          , zmag_gaussian_err
          , zflux_gaussian_apcorr
          , zflux_gaussian_apcorr_err
          , zflux_gaussian_flags
          , zflux_gaussian_flags_apcorr
          , zcmodel_initial_flux
          , zcmodel_initial_mag
          , zcmodel_initial_flux_err
          , zcmodel_initial_mag_err
          , zcmodel_initial_flux_inner
          , zcmodel_initial_mag_inner
          , zcmodel_initial_ellipse_11
          , zcmodel_initial_ellipse_22
          , zcmodel_initial_ellipse_12
          , zcmodel_initial_objective
          , zcmodel_initial_nonlinear0
          , zcmodel_initial_nonlinear1
          , zcmodel_initial_nonlinear2
          , zcmodel_initial_fixed0
          , zcmodel_initial_fixed1
          , zcmodel_initial_niter
          , zcmodel_initial_time
          , zcmodel_exp_flux
          , zcmodel_exp_mag
          , zcmodel_exp_flux_err
          , zcmodel_exp_mag_err
          , zcmodel_exp_flux_inner
          , zcmodel_exp_mag_inner
          , zcmodel_exp_ellipse_11
          , zcmodel_exp_ellipse_22
          , zcmodel_exp_ellipse_12
          , zcmodel_exp_objective
          , zcmodel_exp_nonlinear0
          , zcmodel_exp_nonlinear1
          , zcmodel_exp_nonlinear2
          , zcmodel_exp_fixed0
          , zcmodel_exp_fixed1
          , zcmodel_exp_niter
          , zcmodel_exp_time
          , zcmodel_dev_flux
          , zcmodel_dev_mag
          , zcmodel_dev_flux_err
          , zcmodel_dev_mag_err
          , zcmodel_dev_flux_inner
          , zcmodel_dev_mag_inner
          , zcmodel_dev_ellipse_11
          , zcmodel_dev_ellipse_22
          , zcmodel_dev_ellipse_12
          , zcmodel_dev_objective
          , zcmodel_dev_nonlinear0
          , zcmodel_dev_nonlinear1
          , zcmodel_dev_nonlinear2
          , zcmodel_dev_fixed0
          , zcmodel_dev_fixed1
          , zcmodel_dev_niter
          , zcmodel_dev_time
          , zcmodel_center_ra
          , zcmodel_center_dec
          , zcmodel_flux
          , zcmodel_mag
          , zcmodel_flux_err
          , zcmodel_mag_err
          , zcmodel_flux_inner
          , zcmodel_mag_inner
          , zcmodel_fracdev
          , zcmodel_objective
          , zcmodel_ellipse_11
          , zcmodel_ellipse_22
          , zcmodel_ellipse_12
          , zcmodel_region_initial_ellipse_11
          , zcmodel_region_initial_ellipse_22
          , zcmodel_region_initial_ellipse_12
          , zcmodel_region_final_ellipse_11
          , zcmodel_region_final_ellipse_22
          , zcmodel_region_final_ellipse_12
          , zcmodel_dev_flux_apcorr
          , zcmodel_dev_flux_apcorr_err
          , zcmodel_exp_flux_apcorr
          , zcmodel_exp_flux_apcorr_err
          , zcmodel_flux_apcorr
          , zcmodel_flux_apcorr_err
          , zcmodel_initial_flux_flags
          , zcmodel_initial_flags_trsmall
          , zcmodel_initial_flags_maxiter
          , zcmodel_initial_flags_numericerror
          , zcmodel_exp_flux_flags
          , zcmodel_exp_flags_trsmall
          , zcmodel_exp_flags_maxiter
          , zcmodel_exp_flags_numericerror
          , zcmodel_dev_flux_flags
          , zcmodel_dev_flags_trsmall
          , zcmodel_dev_flags_maxiter
          , zcmodel_dev_flags_numericerror
          , zcmodel_flux_flags
          , zcmodel_flags_region_maxarea
          , zcmodel_flags_region_maxbadpixelfraction
          , zcmodel_flags_region_usedfootprintarea
          , zcmodel_flags_region_usedpsfarea
          , zcmodel_flags_region_usedinitialellipsemin
          , zcmodel_flags_region_usedinitialellipsemax
          , zcmodel_flags_noshape
          , zcmodel_flags_smallshape
          , zcmodel_flags_nopsf
          , zcmodel_flags_nowcs
          , zcmodel_flags_nocalib
          , zcmodel_flags_badcentroid
          , zcmodel_dev_flux_flags_apcorr
          , zcmodel_exp_flux_flags_apcorr
          , zcmodel_flux_flags_apcorr
          , zdeblend_psf_center_ra
          , zdeblend_psf_center_dec
          , zdeblend_psf_flux
          , zdeblend_psf_mag
          , zblendedness_old
          , zblendedness_raw_flux
          , zblendedness_raw_flux_child
          , zblendedness_raw_mag_child
          , zblendedness_raw_flux_parent
          , zblendedness_raw_mag_parent
          , zblendedness_abs_flux
          , zblendedness_abs_flux_child
          , zblendedness_abs_mag_child
          , zblendedness_abs_flux_parent
          , zblendedness_abs_mag_parent
          , zblendedness_raw_shape_child_11
          , zblendedness_raw_shape_child_22
          , zblendedness_raw_shape_child_12
          , zblendedness_raw_shape_parent_11
          , zblendedness_raw_shape_parent_22
          , zblendedness_raw_shape_parent_12
          , zblendedness_abs_shape_child_11
          , zblendedness_abs_shape_child_22
          , zblendedness_abs_shape_child_12
          , zblendedness_abs_shape_parent_11
          , zblendedness_abs_shape_parent_22
          , zblendedness_abs_shape_parent_12
          , zdeblend_deblended_as_psf
          , zdeblend_too_many_peaks
          , zdeblend_parent_too_big
          , zdeblend_masked
          , zdeblend_skipped
          , zdeblend_ramped_template
          , zdeblend_patched_template
          , zdeblend_has_stray_flux
          , zblendedness_flags
          , zblendedness_flags_nocentroid
          , zblendedness_flags_noshape
          , zcountinputs smallint
          , zclassification_extendedness
          , zflags_negative
          , zflags_badcentroid
          , zflags_pixel_edge
          , zflags_pixel_interpolated_any
          , zflags_pixel_interpolated_center
          , zflags_pixel_saturated_any
          , zflags_pixel_saturated_center
          , zflags_pixel_cr_any
          , zflags_pixel_cr_center
          , zflags_pixel_bad
          , zflags_pixel_suspect_any
          , zflags_pixel_suspect_center
          , zflags_pixel_offimage
          , zflags_pixel_bright_object_center
          , zflags_pixel_clipped_any
          , zflags_pixel_bright_object_any
          , zdetect_is_patch_inner
          , zdetect_is_tract_inner
          , zdetect_is_primary
          , zcalib_psf_candidate
          , zcalib_psf_used
          , yflux_naive
          , ymag_naive
          , yflux_naive_err
          , ymag_naive_err
          , yflux_naive_flags
          , yflux_sinc
          , ymag_sinc
          , yflux_sinc_err
          , ymag_sinc_err
          , yflux_sinc_flags
          , yflux_psf
          , ymag_psf
          , yflux_psf_err
          , ymag_psf_err
          , yflux_psf_apcorr
          , yflux_psf_apcorr_err
          , yflux_psf_flags
          , yflux_psf_flags_apcorr
          , yflux_kron
          , ymag_kron
          , yflux_kron_err
          , ymag_kron_err
          , yflux_kron_radius
          , yflux_kron_radiusforradius
          , yflux_kron_psfradius
          , yflux_kron_apcorr
          , yflux_kron_apcorr_err
          , yflux_kron_flags
          , yflux_kron_flags_edge
          , yflux_kron_flags_radius
          , yflux_kron_flags_smallradius
          , yflux_kron_flags_usedminimumradius
          , yflux_kron_flags_usedpsfradius
          , yflux_kron_flags_badshape
          , yflux_kron_flags_apcorr
          , yflux_gaussian
          , ymag_gaussian
          , yflux_gaussian_err
          , ymag_gaussian_err
          , yflux_gaussian_apcorr
          , yflux_gaussian_apcorr_err
          , yflux_gaussian_flags
          , yflux_gaussian_flags_apcorr
          , ycmodel_initial_flux
          , ycmodel_initial_mag
          , ycmodel_initial_flux_err
          , ycmodel_initial_mag_err
          , ycmodel_initial_flux_inner
          , ycmodel_initial_mag_inner
          , ycmodel_initial_ellipse_11
          , ycmodel_initial_ellipse_22
          , ycmodel_initial_ellipse_12
          , ycmodel_initial_objective
          , ycmodel_initial_nonlinear0
          , ycmodel_initial_nonlinear1
          , ycmodel_initial_nonlinear2
          , ycmodel_initial_fixed0
          , ycmodel_initial_fixed1
          , ycmodel_initial_niter
          , ycmodel_initial_time
          , ycmodel_exp_flux
          , ycmodel_exp_mag
          , ycmodel_exp_flux_err
          , ycmodel_exp_mag_err
          , ycmodel_exp_flux_inner
          , ycmodel_exp_mag_inner
          , ycmodel_exp_ellipse_11
          , ycmodel_exp_ellipse_22
          , ycmodel_exp_ellipse_12
          , ycmodel_exp_objective
          , ycmodel_exp_nonlinear0
          , ycmodel_exp_nonlinear1
          , ycmodel_exp_nonlinear2
          , ycmodel_exp_fixed0
          , ycmodel_exp_fixed1
          , ycmodel_exp_niter
          , ycmodel_exp_time
          , ycmodel_dev_flux
          , ycmodel_dev_mag
          , ycmodel_dev_flux_err
          , ycmodel_dev_mag_err
          , ycmodel_dev_flux_inner
          , ycmodel_dev_mag_inner
          , ycmodel_dev_ellipse_11
          , ycmodel_dev_ellipse_22
          , ycmodel_dev_ellipse_12
          , ycmodel_dev_objective
          , ycmodel_dev_nonlinear0
          , ycmodel_dev_nonlinear1
          , ycmodel_dev_nonlinear2
          , ycmodel_dev_fixed0
          , ycmodel_dev_fixed1
          , ycmodel_dev_niter
          , ycmodel_dev_time
          , ycmodel_center_ra
          , ycmodel_center_dec
          , ycmodel_flux
          , ycmodel_mag
          , ycmodel_flux_err
          , ycmodel_mag_err
          , ycmodel_flux_inner
          , ycmodel_mag_inner
          , ycmodel_fracdev
          , ycmodel_objective
          , ycmodel_ellipse_11
          , ycmodel_ellipse_22
          , ycmodel_ellipse_12
          , ycmodel_region_initial_ellipse_11
          , ycmodel_region_initial_ellipse_22
          , ycmodel_region_initial_ellipse_12
          , ycmodel_region_final_ellipse_11
          , ycmodel_region_final_ellipse_22
          , ycmodel_region_final_ellipse_12
          , ycmodel_dev_flux_apcorr
          , ycmodel_dev_flux_apcorr_err
          , ycmodel_exp_flux_apcorr
          , ycmodel_exp_flux_apcorr_err
          , ycmodel_flux_apcorr
          , ycmodel_flux_apcorr_err
          , ycmodel_initial_flux_flags
          , ycmodel_initial_flags_trsmall
          , ycmodel_initial_flags_maxiter
          , ycmodel_initial_flags_numericerror
          , ycmodel_exp_flux_flags
          , ycmodel_exp_flags_trsmall
          , ycmodel_exp_flags_maxiter
          , ycmodel_exp_flags_numericerror
          , ycmodel_dev_flux_flags
          , ycmodel_dev_flags_trsmall
          , ycmodel_dev_flags_maxiter
          , ycmodel_dev_flags_numericerror
          , ycmodel_flux_flags
          , ycmodel_flags_region_maxarea
          , ycmodel_flags_region_maxbadpixelfraction
          , ycmodel_flags_region_usedfootprintarea
          , ycmodel_flags_region_usedpsfarea
          , ycmodel_flags_region_usedinitialellipsemin
          , ycmodel_flags_region_usedinitialellipsemax
          , ycmodel_flags_noshape
          , ycmodel_flags_smallshape
          , ycmodel_flags_nopsf
          , ycmodel_flags_nowcs
          , ycmodel_flags_nocalib
          , ycmodel_flags_badcentroid
          , ycmodel_dev_flux_flags_apcorr
          , ycmodel_exp_flux_flags_apcorr
          , ycmodel_flux_flags_apcorr
          , ydeblend_psf_center_ra
          , ydeblend_psf_center_dec
          , ydeblend_psf_flux
          , ydeblend_psf_mag
          , yblendedness_old
          , yblendedness_raw_flux
          , yblendedness_raw_flux_child
          , yblendedness_raw_mag_child
          , yblendedness_raw_flux_parent
          , yblendedness_raw_mag_parent
          , yblendedness_abs_flux
          , yblendedness_abs_flux_child
          , yblendedness_abs_mag_child
          , yblendedness_abs_flux_parent
          , yblendedness_abs_mag_parent
          , yblendedness_raw_shape_child_11
          , yblendedness_raw_shape_child_22
          , yblendedness_raw_shape_child_12
          , yblendedness_raw_shape_parent_11
          , yblendedness_raw_shape_parent_22
          , yblendedness_raw_shape_parent_12
          , yblendedness_abs_shape_child_11
          , yblendedness_abs_shape_child_22
          , yblendedness_abs_shape_child_12
          , yblendedness_abs_shape_parent_11
          , yblendedness_abs_shape_parent_22
          , yblendedness_abs_shape_parent_12
          , ydeblend_deblended_as_psf
          , ydeblend_too_many_peaks
          , ydeblend_parent_too_big
          , ydeblend_masked
          , ydeblend_skipped
          , ydeblend_ramped_template
          , ydeblend_patched_template
          , ydeblend_has_stray_flux
          , yblendedness_flags
          , yblendedness_flags_nocentroid
          , yblendedness_flags_noshape
          , ycountinputs smallint
          , yclassification_extendedness
          , yflags_negative
          , yflags_badcentroid
          , yflags_pixel_edge
          , yflags_pixel_interpolated_any
          , yflags_pixel_interpolated_center
          , yflags_pixel_saturated_any
          , yflags_pixel_saturated_center
          , yflags_pixel_cr_any
          , yflags_pixel_cr_center
          , yflags_pixel_bad
          , yflags_pixel_suspect_any
          , yflags_pixel_suspect_center
          , yflags_pixel_offimage
          , yflags_pixel_bright_object_center
          , yflags_pixel_clipped_any
          , yflags_pixel_bright_object_any
          , ydetect_is_patch_inner
          , ydetect_is_tract_inner
          , ydetect_is_primary
          , ycalib_psf_candidate
          , ycalib_psf_used
        )
      }

  }

}