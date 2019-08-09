package udafApp

import org.apache.spark.SparkContext

object ReadPDR1 {

  case class force(
                    object_id: BigInt
                    , ra: Double
                    , dec: Double
                    , coord: String
                    , skymap_id: Int
                    , tract: Int
                    , patch: Int
                    , patch_s: String
                    , parent_id: BigInt
                    , deblend_nchild: Int
                    , a_g: Float
                    , a_r: Float
                    , a_i: Float
                    , a_z: Float
                    , a_y: Float
                    , detect_is_primary: Boolean
                    , merge_footprint_i2: Boolean
                    , merge_footprint_i: Boolean
                    , merge_footprint_r: Boolean
                    , merge_footprint_z: Boolean
                    , merge_footprint_y: Boolean
                    , merge_footprint_g: Boolean
                    , merge_footprint_n921: Boolean
                    , merge_footprint_n816: Boolean
                    , merge_footprint_n1010: Boolean
                    , merge_footprint_n387: Boolean
                    , merge_footprint_n515: Boolean
                    , merge_footprint_sky: Boolean
                    , merge_peak_i2: Boolean
                    , merge_peak_i: Boolean
                    , merge_peak_r: Boolean
                    , merge_peak_z: Boolean
                    , merge_peak_y: Boolean
                    , merge_peak_g: Boolean
                    , merge_peak_n921: Boolean
                    , merge_peak_n816: Boolean
                    , merge_peak_n1010: Boolean
                    , merge_peak_n387: Boolean
                    , merge_peak_n515: Boolean
                    , merge_peak_sky: Boolean
                    , detect_is_patch_inner: Boolean
                    , detect_is_tract_inner: Boolean
                    , merge_measurement_i2: Boolean
                    , merge_measurement_i: Boolean
                    , merge_measurement_r: Boolean
                    , merge_measurement_z: Boolean
                    , merge_measurement_y: Boolean
                    , merge_measurement_g: Boolean
                    , merge_measurement_n921: Boolean
                    , merge_measurement_n816: Boolean
                    , merge_measurement_n1010: Boolean
                    , merge_measurement_n387: Boolean
                    , merge_measurement_n515: Boolean
                    , gflux_naive: Double
                    , gmag_naive: Float
                    , gflux_naive_err: Double
                    , gmag_naive_err: Float
                    , gflux_naive_flags: Boolean
                    , gflux_sinc: Double
                    , gmag_sinc: Float
                    , gflux_sinc_err: Double
                    , gmag_sinc_err: Float
                    , gflux_sinc_flags: Boolean
                    , gflux_psf: Double
                    , gmag_psf: Float
                    , gflux_psf_err: Double
                    , gmag_psf_err: Float
                    , gflux_psf_apcorr: Float
                    , gflux_psf_apcorr_err: Float
                    , gflux_psf_flags: Boolean
                    , gflux_psf_flags_apcorr: Boolean
                    , gflux_kron: Double
                    , gmag_kron: Float
                    , gflux_kron_err: Double
                    , gmag_kron_err: Float
                    , gflux_kron_radius: Float
                    , gflux_kron_radiusforradius: Float
                    , gflux_kron_psfradius: Float
                    , gflux_kron_apcorr: Float
                    , gflux_kron_apcorr_err: Float
                    , gflux_kron_flags: Boolean
                    , gflux_kron_flags_edge: Boolean
                    , gflux_kron_flags_radius: Boolean
                    , gflux_kron_flags_smallradius: Boolean
                    , gflux_kron_flags_usedminimumradius: Boolean
                    , gflux_kron_flags_usedpsfradius: Boolean
                    , gflux_kron_flags_badshape: Boolean
                    , gflux_kron_flags_apcorr: Boolean
                    , gflux_aperture10: Double
                    , gmag_aperture10: Float
                    , gflux_aperture15: Double
                    , gmag_aperture15: Float
                    , gflux_aperture20: Double
                    , gmag_aperture20: Float
                    , gflux_aperture30: Double
                    , gmag_aperture30: Float
                    , gflux_aperture40: Double
                    , gmag_aperture40: Float
                    , gflux_aperture57: Double
                    , gmag_aperture57: Float
                    , gflux_aperture84: Double
                    , gmag_aperture84: Float
                    , gflux_aperture118: Double
                    , gmag_aperture118: Float
                    , gflux_aperture168: Double
                    , gmag_aperture168: Float
                    , gflux_aperture235: Double
                    , gmag_aperture235: Float
                    , gflux_aperture10_err: Double
                    , gmag_aperture10_err: Float
                    , gflux_aperture15_err: Double
                    , gmag_aperture15_err: Float
                    , gflux_aperture20_err: Double
                    , gmag_aperture20_err: Float
                    , gflux_aperture30_err: Double
                    , gmag_aperture30_err: Float
                    , gflux_aperture40_err: Double
                    , gmag_aperture40_err: Float
                    , gflux_aperture57_err: Double
                    , gmag_aperture57_err: Float
                    , gflux_aperture84_err: Double
                    , gmag_aperture84_err: Float
                    , gflux_aperture118_err: Double
                    , gmag_aperture118_err: Float
                    , gflux_aperture168_err: Double
                    , gmag_aperture168_err: Float
                    , gflux_aperture235_err: Double
                    , gmag_aperture235_err: Float
                    , gflux_aperture10_ninterpolatedpixel: Int
                    , gflux_aperture15_ninterpolatedpixel: Int
                    , gflux_aperture20_ninterpolatedpixel: Int
                    , gflux_aperture30_ninterpolatedpixel: Int
                    , gflux_aperture40_ninterpolatedpixel: Int
                    , gflux_aperture57_ninterpolatedpixel: Int
                    , gflux_aperture84_ninterpolatedpixel: Int
                    , gflux_aperture118_ninterpolatedpixel: Int
                    , gflux_aperture168_ninterpolatedpixel: Int
                    , gflux_aperture235_ninterpolatedpixel: Int
                    , gflux_aperture_nprofile: Int
                    , gflux_aperture_flags: Boolean
                    , gcentroid_naive_ra: Double
                    , gcentroid_naive_dec: Double
                    , gcentroid_naive_flags: Boolean
                    , gcentroid_sdss_ra: Double
                    , gcentroid_sdss_dec: Double
                    , gcentroid_sdss_err_11: Float
                    , gcentroid_sdss_err_22: Float
                    , gcentroid_sdss_flags: Boolean
                    , gmultishapelet_psf_inner0: Float
                    , gmultishapelet_psf_inner1: Float
                    , gmultishapelet_psf_inner2: Float
                    , gmultishapelet_psf_inner3: Float
                    , gmultishapelet_psf_inner4: Float
                    , gmultishapelet_psf_inner5: Float
                    , gmultishapelet_psf_outer0: Float
                    , gmultishapelet_psf_outer1: Float
                    , gmultishapelet_psf_outer2: Float
                    , gmultishapelet_psf_ellipse_11: Float
                    , gmultishapelet_psf_ellipse_22: Float
                    , gmultishapelet_psf_ellipse_12: Float
                    , gmultishapelet_psf_chisq: Float
                    , gmultishapelet_psf_integral: Float
                    , gmultishapelet_psf_flags: Boolean
                    , gmultishapelet_psf_flags_maxiter: Boolean
                    , gmultishapelet_psf_flags_tinystep: Boolean
                    , gmultishapelet_psf_flags_constraint_r: Boolean
                    , gmultishapelet_psf_flags_constraint_q: Boolean
                    , gshape_sdss_11: Float
                    , gshape_sdss_22: Float
                    , gshape_sdss_12: Float
                    , gshape_sdss_err_11_11: Float
                    , gshape_sdss_err_22_22: Float
                    , gshape_sdss_err_12_12: Float
                    , gshape_sdss_centroid_ra: Double
                    , gshape_sdss_centroid_dec: Double
                    , gshape_sdss_psf_11: Float
                    , gshape_sdss_psf_22: Float
                    , gshape_sdss_psf_12: Float
                    , gshape_sdss_flags: Boolean
                    , gshape_sdss_centroid_flags: Boolean
                    , gshape_sdss_flags_unweightedbad: Boolean
                    , gshape_sdss_flags_unweighted: Boolean
                    , gshape_sdss_flags_shift: Boolean
                    , gshape_sdss_flags_maxiter: Boolean
                    , gshape_sdss_flags_psf: Boolean
                    , gcmodel_initial_flux: Double
                    , gcmodel_initial_mag: Float
                    , gcmodel_initial_flux_err: Double
                    , gcmodel_initial_mag_err: Float
                    , gcmodel_initial_flux_inner: Double
                    , gcmodel_initial_mag_inner: Float
                    , gcmodel_exp_flux: Double
                    , gcmodel_exp_mag: Float
                    , gcmodel_exp_flux_err: Double
                    , gcmodel_exp_mag_err: Float
                    , gcmodel_exp_flux_inner: Double
                    , gcmodel_exp_mag_inner: Float
                    , gcmodel_dev_flux: Double
                    , gcmodel_dev_mag: Float
                    , gcmodel_dev_flux_err: Double
                    , gcmodel_dev_mag_err: Float
                    , gcmodel_dev_flux_inner: Double
                    , gcmodel_dev_mag_inner: Float
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
                    , gcmodel_dev_flux_apcorr: Float
                    , gcmodel_dev_flux_apcorr_err: Float
                    , gcmodel_exp_flux_apcorr: Float
                    , gcmodel_exp_flux_apcorr_err: Float
                    , gcmodel_flux_apcorr: Float
                    , gcmodel_flux_apcorr_err: Float
                    , gcmodel_initial_flux_flags: Boolean
                    , gcmodel_initial_flags_badreference: Boolean
                    , gcmodel_initial_flags_numericerror: Boolean
                    , gcmodel_exp_flux_flags: Boolean
                    , gcmodel_exp_flags_badreference: Boolean
                    , gcmodel_exp_flags_numericerror: Boolean
                    , gcmodel_dev_flux_flags: Boolean
                    , gcmodel_dev_flags_badreference: Boolean
                    , gcmodel_dev_flags_numericerror: Boolean
                    , gcmodel_flux_flags: Boolean
                    , gcmodel_flags_region_maxarea: Boolean
                    , gcmodel_flags_region_maxbadpixelfraction: Boolean
                    , gcmodel_flags_badreference: Boolean
                    , gcmodel_flags_nopsf: Boolean
                    , gcmodel_flags_nowcs: Boolean
                    , gcmodel_flags_nocalib: Boolean
                    , gcmodel_flags_badcentroid: Boolean
                    , gcmodel_dev_flux_flags_apcorr: Boolean
                    , gcmodel_exp_flux_flags_apcorr: Boolean
                    , gcmodel_flux_flags_apcorr: Boolean
                    , gcountinputs: Int
                    , gvariance: Float
                    , gclassification_extendedness: Float
                    , gflags_pixel_edge: Boolean
                    , gflags_pixel_interpolated_any: Boolean
                    , gflags_pixel_interpolated_center: Boolean
                    , gflags_pixel_saturated_any: Boolean
                    , gflags_pixel_saturated_center: Boolean
                    , gflags_pixel_cr_any: Boolean
                    , gflags_pixel_cr_center: Boolean
                    , gflags_pixel_bad: Boolean
                    , gflags_pixel_suspect_any: Boolean
                    , gflags_pixel_suspect_center: Boolean
                    , gflags_pixel_offimage: Boolean
                    , gflags_pixel_bright_object_center: Boolean
                    , gflags_pixel_clipped_any: Boolean
                    , gflags_pixel_bright_object_any: Boolean
                    , rflux_naive: Double
                    , rmag_naive: Float
                    , rflux_naive_err: Double
                    , rmag_naive_err: Float
                    , rflux_naive_flags: Boolean
                    , rflux_sinc: Double
                    , rmag_sinc: Float
                    , rflux_sinc_err: Double
                    , rmag_sinc_err: Float
                    , rflux_sinc_flags: Boolean
                    , rflux_psf: Double
                    , rmag_psf: Float
                    , rflux_psf_err: Double
                    , rmag_psf_err: Float
                    , rflux_psf_apcorr: Float
                    , rflux_psf_apcorr_err: Float
                    , rflux_psf_flags: Boolean
                    , rflux_psf_flags_apcorr: Boolean
                    , rflux_kron: Double
                    , rmag_kron: Float
                    , rflux_kron_err: Double
                    , rmag_kron_err: Float
                    , rflux_kron_radius: Float
                    , rflux_kron_radiusforradius: Float
                    , rflux_kron_psfradius: Float
                    , rflux_kron_apcorr: Float
                    , rflux_kron_apcorr_err: Float
                    , rflux_kron_flags: Boolean
                    , rflux_kron_flags_edge: Boolean
                    , rflux_kron_flags_radius: Boolean
                    , rflux_kron_flags_smallradius: Boolean
                    , rflux_kron_flags_usedminimumradius: Boolean
                    , rflux_kron_flags_usedpsfradius: Boolean
                    , rflux_kron_flags_badshape: Boolean
                    , rflux_kron_flags_apcorr: Boolean
                    , rflux_aperture10: Double
                    , rmag_aperture10: Float
                    , rflux_aperture15: Double
                    , rmag_aperture15: Float
                    , rflux_aperture20: Double
                    , rmag_aperture20: Float
                    , rflux_aperture30: Double
                    , rmag_aperture30: Float
                    , rflux_aperture40: Double
                    , rmag_aperture40: Float
                    , rflux_aperture57: Double
                    , rmag_aperture57: Float
                    , rflux_aperture84: Double
                    , rmag_aperture84: Float
                    , rflux_aperture118: Double
                    , rmag_aperture118: Float
                    , rflux_aperture168: Double
                    , rmag_aperture168: Float
                    , rflux_aperture235: Double
                    , rmag_aperture235: Float
                    , rflux_aperture10_err: Double
                    , rmag_aperture10_err: Float
                    , rflux_aperture15_err: Double
                    , rmag_aperture15_err: Float
                    , rflux_aperture20_err: Double
                    , rmag_aperture20_err: Float
                    , rflux_aperture30_err: Double
                    , rmag_aperture30_err: Float
                    , rflux_aperture40_err: Double
                    , rmag_aperture40_err: Float
                    , rflux_aperture57_err: Double
                    , rmag_aperture57_err: Float
                    , rflux_aperture84_err: Double
                    , rmag_aperture84_err: Float
                    , rflux_aperture118_err: Double
                    , rmag_aperture118_err: Float
                    , rflux_aperture168_err: Double
                    , rmag_aperture168_err: Float
                    , rflux_aperture235_err: Double
                    , rmag_aperture235_err: Float
                    , rflux_aperture10_ninterpolatedpixel: Int
                    , rflux_aperture15_ninterpolatedpixel: Int
                    , rflux_aperture20_ninterpolatedpixel: Int
                    , rflux_aperture30_ninterpolatedpixel: Int
                    , rflux_aperture40_ninterpolatedpixel: Int
                    , rflux_aperture57_ninterpolatedpixel: Int
                    , rflux_aperture84_ninterpolatedpixel: Int
                    , rflux_aperture118_ninterpolatedpixel: Int
                    , rflux_aperture168_ninterpolatedpixel: Int
                    , rflux_aperture235_ninterpolatedpixel: Int
                    , rflux_aperture_nprofile: Int
                    , rflux_aperture_flags: Boolean
                    , rcentroid_naive_ra: Double
                    , rcentroid_naive_dec: Double
                    , rcentroid_naive_flags: Boolean
                    , rcentroid_sdss_ra: Double
                    , rcentroid_sdss_dec: Double
                    , rcentroid_sdss_err_11: Float
                    , rcentroid_sdss_err_22: Float
                    , rcentroid_sdss_flags: Boolean
                    , rmultishapelet_psf_inner0: Float
                    , rmultishapelet_psf_inner1: Float
                    , rmultishapelet_psf_inner2: Float
                    , rmultishapelet_psf_inner3: Float
                    , rmultishapelet_psf_inner4: Float
                    , rmultishapelet_psf_inner5: Float
                    , rmultishapelet_psf_outer0: Float
                    , rmultishapelet_psf_outer1: Float
                    , rmultishapelet_psf_outer2: Float
                    , rmultishapelet_psf_ellipse_11: Float
                    , rmultishapelet_psf_ellipse_22: Float
                    , rmultishapelet_psf_ellipse_12: Float
                    , rmultishapelet_psf_chisq: Float
                    , rmultishapelet_psf_integral: Float
                    , rmultishapelet_psf_flags: Boolean
                    , rmultishapelet_psf_flags_maxiter: Boolean
                    , rmultishapelet_psf_flags_tinystep: Boolean
                    , rmultishapelet_psf_flags_constraint_r: Boolean
                    , rmultishapelet_psf_flags_constraint_q: Boolean
                    , rshape_sdss_11: Float
                    , rshape_sdss_22: Float
                    , rshape_sdss_12: Float
                    , rshape_sdss_err_11_11: Float
                    , rshape_sdss_err_22_22: Float
                    , rshape_sdss_err_12_12: Float
                    , rshape_sdss_centroid_ra: Double
                    , rshape_sdss_centroid_dec: Double
                    , rshape_sdss_psf_11: Float
                    , rshape_sdss_psf_22: Float
                    , rshape_sdss_psf_12: Float
                    , rshape_sdss_flags: Boolean
                    , rshape_sdss_centroid_flags: Boolean
                    , rshape_sdss_flags_unweightedbad: Boolean
                    , rshape_sdss_flags_unweighted: Boolean
                    , rshape_sdss_flags_shift: Boolean
                    , rshape_sdss_flags_maxiter: Boolean
                    , rshape_sdss_flags_psf: Boolean
                    , rcmodel_initial_flux: Double
                    , rcmodel_initial_mag: Float
                    , rcmodel_initial_flux_err: Double
                    , rcmodel_initial_mag_err: Float
                    , rcmodel_initial_flux_inner: Double
                    , rcmodel_initial_mag_inner: Float
                    , rcmodel_exp_flux: Double
                    , rcmodel_exp_mag: Float
                    , rcmodel_exp_flux_err: Double
                    , rcmodel_exp_mag_err: Float
                    , rcmodel_exp_flux_inner: Double
                    , rcmodel_exp_mag_inner: Float
                    , rcmodel_dev_flux: Double
                    , rcmodel_dev_mag: Float
                    , rcmodel_dev_flux_err: Double
                    , rcmodel_dev_mag_err: Float
                    , rcmodel_dev_flux_inner: Double
                    , rcmodel_dev_mag_inner: Float
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
                    , rcmodel_dev_flux_apcorr: Float
                    , rcmodel_dev_flux_apcorr_err: Float
                    , rcmodel_exp_flux_apcorr: Float
                    , rcmodel_exp_flux_apcorr_err: Float
                    , rcmodel_flux_apcorr: Float
                    , rcmodel_flux_apcorr_err: Float
                    , rcmodel_initial_flux_flags: Boolean
                    , rcmodel_initial_flags_badreference: Boolean
                    , rcmodel_initial_flags_numericerror: Boolean
                    , rcmodel_exp_flux_flags: Boolean
                    , rcmodel_exp_flags_badreference: Boolean
                    , rcmodel_exp_flags_numericerror: Boolean
                    , rcmodel_dev_flux_flags: Boolean
                    , rcmodel_dev_flags_badreference: Boolean
                    , rcmodel_dev_flags_numericerror: Boolean
                    , rcmodel_flux_flags: Boolean
                    , rcmodel_flags_region_maxarea: Boolean
                    , rcmodel_flags_region_maxbadpixelfraction: Boolean
                    , rcmodel_flags_badreference: Boolean
                    , rcmodel_flags_nopsf: Boolean
                    , rcmodel_flags_nowcs: Boolean
                    , rcmodel_flags_nocalib: Boolean
                    , rcmodel_flags_badcentroid: Boolean
                    , rcmodel_dev_flux_flags_apcorr: Boolean
                    , rcmodel_exp_flux_flags_apcorr: Boolean
                    , rcmodel_flux_flags_apcorr: Boolean
                    , rcountinputs: Int
                    , rvariance: Float
                    , rclassification_extendedness: Float
                    , rflags_pixel_edge: Boolean
                    , rflags_pixel_interpolated_any: Boolean
                    , rflags_pixel_interpolated_center: Boolean
                    , rflags_pixel_saturated_any: Boolean
                    , rflags_pixel_saturated_center: Boolean
                    , rflags_pixel_cr_any: Boolean
                    , rflags_pixel_cr_center: Boolean
                    , rflags_pixel_bad: Boolean
                    , rflags_pixel_suspect_any: Boolean
                    , rflags_pixel_suspect_center: Boolean
                    , rflags_pixel_offimage: Boolean
                    , rflags_pixel_bright_object_center: Boolean
                    , rflags_pixel_clipped_any: Boolean
                    , rflags_pixel_bright_object_any: Boolean
                    , iflux_naive: Double
                    , imag_naive: Float
                    , iflux_naive_err: Double
                    , imag_naive_err: Float
                    , iflux_naive_flags: Boolean
                    , iflux_sinc: Double
                    , imag_sinc: Float
                    , iflux_sinc_err: Double
                    , imag_sinc_err: Float
                    , iflux_sinc_flags: Boolean
                    , iflux_psf: Double
                    , imag_psf: Float
                    , iflux_psf_err: Double
                    , imag_psf_err: Float
                    , iflux_psf_apcorr: Float
                    , iflux_psf_apcorr_err: Float
                    , iflux_psf_flags: Boolean
                    , iflux_psf_flags_apcorr: Boolean
                    , iflux_kron: Double
                    , imag_kron: Float
                    , iflux_kron_err: Double
                    , imag_kron_err: Float
                    , iflux_kron_radius: Float
                    , iflux_kron_radiusforradius: Float
                    , iflux_kron_psfradius: Float
                    , iflux_kron_apcorr: Float
                    , iflux_kron_apcorr_err: Float
                    , iflux_kron_flags: Boolean
                    , iflux_kron_flags_edge: Boolean
                    , iflux_kron_flags_radius: Boolean
                    , iflux_kron_flags_smallradius: Boolean
                    , iflux_kron_flags_usedminimumradius: Boolean
                    , iflux_kron_flags_usedpsfradius: Boolean
                    , iflux_kron_flags_badshape: Boolean
                    , iflux_kron_flags_apcorr: Boolean
                    , iflux_aperture10: Double
                    , imag_aperture10: Float
                    , iflux_aperture15: Double
                    , imag_aperture15: Float
                    , iflux_aperture20: Double
                    , imag_aperture20: Float
                    , iflux_aperture30: Double
                    , imag_aperture30: Float
                    , iflux_aperture40: Double
                    , imag_aperture40: Float
                    , iflux_aperture57: Double
                    , imag_aperture57: Float
                    , iflux_aperture84: Double
                    , imag_aperture84: Float
                    , iflux_aperture118: Double
                    , imag_aperture118: Float
                    , iflux_aperture168: Double
                    , imag_aperture168: Float
                    , iflux_aperture235: Double
                    , imag_aperture235: Float
                    , iflux_aperture10_err: Double
                    , imag_aperture10_err: Float
                    , iflux_aperture15_err: Double
                    , imag_aperture15_err: Float
                    , iflux_aperture20_err: Double
                    , imag_aperture20_err: Float
                    , iflux_aperture30_err: Double
                    , imag_aperture30_err: Float
                    , iflux_aperture40_err: Double
                    , imag_aperture40_err: Float
                    , iflux_aperture57_err: Double
                    , imag_aperture57_err: Float
                    , iflux_aperture84_err: Double
                    , imag_aperture84_err: Float
                    , iflux_aperture118_err: Double
                    , imag_aperture118_err: Float
                    , iflux_aperture168_err: Double
                    , imag_aperture168_err: Float
                    , iflux_aperture235_err: Double
                    , imag_aperture235_err: Float
                    , iflux_aperture10_ninterpolatedpixel: Int
                    , iflux_aperture15_ninterpolatedpixel: Int
                    , iflux_aperture20_ninterpolatedpixel: Int
                    , iflux_aperture30_ninterpolatedpixel: Int
                    , iflux_aperture40_ninterpolatedpixel: Int
                    , iflux_aperture57_ninterpolatedpixel: Int
                    , iflux_aperture84_ninterpolatedpixel: Int
                    , iflux_aperture118_ninterpolatedpixel: Int
                    , iflux_aperture168_ninterpolatedpixel: Int
                    , iflux_aperture235_ninterpolatedpixel: Int
                    , iflux_aperture_nprofile: Int
                    , iflux_aperture_flags: Boolean
                    , icentroid_naive_ra: Double
                    , icentroid_naive_dec: Double
                    , icentroid_naive_flags: Boolean
                    , icentroid_sdss_ra: Double
                    , icentroid_sdss_dec: Double
                    , icentroid_sdss_err_11: Float
                    , icentroid_sdss_err_22: Float
                    , icentroid_sdss_flags: Boolean
                    , imultishapelet_psf_inner0: Float
                    , imultishapelet_psf_inner1: Float
                    , imultishapelet_psf_inner2: Float
                    , imultishapelet_psf_inner3: Float
                    , imultishapelet_psf_inner4: Float
                    , imultishapelet_psf_inner5: Float
                    , imultishapelet_psf_outer0: Float
                    , imultishapelet_psf_outer1: Float
                    , imultishapelet_psf_outer2: Float
                    , imultishapelet_psf_ellipse_11: Float
                    , imultishapelet_psf_ellipse_22: Float
                    , imultishapelet_psf_ellipse_12: Float
                    , imultishapelet_psf_chisq: Float
                    , imultishapelet_psf_integral: Float
                    , imultishapelet_psf_flags: Boolean
                    , imultishapelet_psf_flags_maxiter: Boolean
                    , imultishapelet_psf_flags_tinystep: Boolean
                    , imultishapelet_psf_flags_constraint_r: Boolean
                    , imultishapelet_psf_flags_constraint_q: Boolean
                    , ishape_sdss_11: Float
                    , ishape_sdss_22: Float
                    , ishape_sdss_12: Float
                    , ishape_sdss_err_11_11: Float
                    , ishape_sdss_err_22_22: Float
                    , ishape_sdss_err_12_12: Float
                    , ishape_sdss_centroid_ra: Double
                    , ishape_sdss_centroid_dec: Double
                    , ishape_sdss_psf_11: Float
                    , ishape_sdss_psf_22: Float
                    , ishape_sdss_psf_12: Float
                    , ishape_sdss_flags: Boolean
                    , ishape_sdss_centroid_flags: Boolean
                    , ishape_sdss_flags_unweightedbad: Boolean
                    , ishape_sdss_flags_unweighted: Boolean
                    , ishape_sdss_flags_shift: Boolean
                    , ishape_sdss_flags_maxiter: Boolean
                    , ishape_sdss_flags_psf: Boolean
                    , icmodel_initial_flux: Double
                    , icmodel_initial_mag: Float
                    , icmodel_initial_flux_err: Double
                    , icmodel_initial_mag_err: Float
                    , icmodel_initial_flux_inner: Double
                    , icmodel_initial_mag_inner: Float
                    , icmodel_exp_flux: Double
                    , icmodel_exp_mag: Float
                    , icmodel_exp_flux_err: Double
                    , icmodel_exp_mag_err: Float
                    , icmodel_exp_flux_inner: Double
                    , icmodel_exp_mag_inner: Float
                    , icmodel_dev_flux: Double
                    , icmodel_dev_mag: Float
                    , icmodel_dev_flux_err: Double
                    , icmodel_dev_mag_err: Float
                    , icmodel_dev_flux_inner: Double
                    , icmodel_dev_mag_inner: Float
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
                    , icmodel_dev_flux_apcorr: Float
                    , icmodel_dev_flux_apcorr_err: Float
                    , icmodel_exp_flux_apcorr: Float
                    , icmodel_exp_flux_apcorr_err: Float
                    , icmodel_flux_apcorr: Float
                    , icmodel_flux_apcorr_err: Float
                    , icmodel_initial_flux_flags: Boolean
                    , icmodel_initial_flags_badreference: Boolean
                    , icmodel_initial_flags_numericerror: Boolean
                    , icmodel_exp_flux_flags: Boolean
                    , icmodel_exp_flags_badreference: Boolean
                    , icmodel_exp_flags_numericerror: Boolean
                    , icmodel_dev_flux_flags: Boolean
                    , icmodel_dev_flags_badreference: Boolean
                    , icmodel_dev_flags_numericerror: Boolean
                    , icmodel_flux_flags: Boolean
                    , icmodel_flags_region_maxarea: Boolean
                    , icmodel_flags_region_maxbadpixelfraction: Boolean
                    , icmodel_flags_badreference: Boolean
                    , icmodel_flags_nopsf: Boolean
                    , icmodel_flags_nowcs: Boolean
                    , icmodel_flags_nocalib: Boolean
                    , icmodel_flags_badcentroid: Boolean
                    , icmodel_dev_flux_flags_apcorr: Boolean
                    , icmodel_exp_flux_flags_apcorr: Boolean
                    , icmodel_flux_flags_apcorr: Boolean
                    , icountinputs: Int
                    , ivariance: Float
                    , iclassification_extendedness: Float
                    , iflags_pixel_edge: Boolean
                    , iflags_pixel_interpolated_any: Boolean
                    , iflags_pixel_interpolated_center: Boolean
                    , iflags_pixel_saturated_any: Boolean
                    , iflags_pixel_saturated_center: Boolean
                    , iflags_pixel_cr_any: Boolean
                    , iflags_pixel_cr_center: Boolean
                    , iflags_pixel_bad: Boolean
                    , iflags_pixel_suspect_any: Boolean
                    , iflags_pixel_suspect_center: Boolean
                    , iflags_pixel_offimage: Boolean
                    , iflags_pixel_bright_object_center: Boolean
                    , iflags_pixel_clipped_any: Boolean
                    , iflags_pixel_bright_object_any: Boolean
                    , zflux_naive: Double
                    , zmag_naive: Float
                    , zflux_naive_err: Double
                    , zmag_naive_err: Float
                    , zflux_naive_flags: Boolean
                    , zflux_sinc: Double
                    , zmag_sinc: Float
                    , zflux_sinc_err: Double
                    , zmag_sinc_err: Float
                    , zflux_sinc_flags: Boolean
                    , zflux_psf: Double
                    , zmag_psf: Float
                    , zflux_psf_err: Double
                    , zmag_psf_err: Float
                    , zflux_psf_apcorr: Float
                    , zflux_psf_apcorr_err: Float
                    , zflux_psf_flags: Boolean
                    , zflux_psf_flags_apcorr: Boolean
                    , zflux_kron: Double
                    , zmag_kron: Float
                    , zflux_kron_err: Double
                    , zmag_kron_err: Float
                    , zflux_kron_radius: Float
                    , zflux_kron_radiusforradius: Float
                    , zflux_kron_psfradius: Float
                    , zflux_kron_apcorr: Float
                    , zflux_kron_apcorr_err: Float
                    , zflux_kron_flags: Boolean
                    , zflux_kron_flags_edge: Boolean
                    , zflux_kron_flags_radius: Boolean
                    , zflux_kron_flags_smallradius: Boolean
                    , zflux_kron_flags_usedminimumradius: Boolean
                    , zflux_kron_flags_usedpsfradius: Boolean
                    , zflux_kron_flags_badshape: Boolean
                    , zflux_kron_flags_apcorr: Boolean
                    , zflux_aperture10: Double
                    , zmag_aperture10: Float
                    , zflux_aperture15: Double
                    , zmag_aperture15: Float
                    , zflux_aperture20: Double
                    , zmag_aperture20: Float
                    , zflux_aperture30: Double
                    , zmag_aperture30: Float
                    , zflux_aperture40: Double
                    , zmag_aperture40: Float
                    , zflux_aperture57: Double
                    , zmag_aperture57: Float
                    , zflux_aperture84: Double
                    , zmag_aperture84: Float
                    , zflux_aperture118: Double
                    , zmag_aperture118: Float
                    , zflux_aperture168: Double
                    , zmag_aperture168: Float
                    , zflux_aperture235: Double
                    , zmag_aperture235: Float
                    , zflux_aperture10_err: Double
                    , zmag_aperture10_err: Float
                    , zflux_aperture15_err: Double
                    , zmag_aperture15_err: Float
                    , zflux_aperture20_err: Double
                    , zmag_aperture20_err: Float
                    , zflux_aperture30_err: Double
                    , zmag_aperture30_err: Float
                    , zflux_aperture40_err: Double
                    , zmag_aperture40_err: Float
                    , zflux_aperture57_err: Double
                    , zmag_aperture57_err: Float
                    , zflux_aperture84_err: Double
                    , zmag_aperture84_err: Float
                    , zflux_aperture118_err: Double
                    , zmag_aperture118_err: Float
                    , zflux_aperture168_err: Double
                    , zmag_aperture168_err: Float
                    , zflux_aperture235_err: Double
                    , zmag_aperture235_err: Float
                    , zflux_aperture10_ninterpolatedpixel: Int
                    , zflux_aperture15_ninterpolatedpixel: Int
                    , zflux_aperture20_ninterpolatedpixel: Int
                    , zflux_aperture30_ninterpolatedpixel: Int
                    , zflux_aperture40_ninterpolatedpixel: Int
                    , zflux_aperture57_ninterpolatedpixel: Int
                    , zflux_aperture84_ninterpolatedpixel: Int
                    , zflux_aperture118_ninterpolatedpixel: Int
                    , zflux_aperture168_ninterpolatedpixel: Int
                    , zflux_aperture235_ninterpolatedpixel: Int
                    , zflux_aperture_nprofile: Int
                    , zflux_aperture_flags: Boolean
                    , zcentroid_naive_ra: Double
                    , zcentroid_naive_dec: Double
                    , zcentroid_naive_flags: Boolean
                    , zcentroid_sdss_ra: Double
                    , zcentroid_sdss_dec: Double
                    , zcentroid_sdss_err_11: Float
                    , zcentroid_sdss_err_22: Float
                    , zcentroid_sdss_flags: Boolean
                    , zmultishapelet_psf_inner0: Float
                    , zmultishapelet_psf_inner1: Float
                    , zmultishapelet_psf_inner2: Float
                    , zmultishapelet_psf_inner3: Float
                    , zmultishapelet_psf_inner4: Float
                    , zmultishapelet_psf_inner5: Float
                    , zmultishapelet_psf_outer0: Float
                    , zmultishapelet_psf_outer1: Float
                    , zmultishapelet_psf_outer2: Float
                    , zmultishapelet_psf_ellipse_11: Float
                    , zmultishapelet_psf_ellipse_22: Float
                    , zmultishapelet_psf_ellipse_12: Float
                    , zmultishapelet_psf_chisq: Float
                    , zmultishapelet_psf_integral: Float
                    , zmultishapelet_psf_flags: Boolean
                    , zmultishapelet_psf_flags_maxiter: Boolean
                    , zmultishapelet_psf_flags_tinystep: Boolean
                    , zmultishapelet_psf_flags_constraint_r: Boolean
                    , zmultishapelet_psf_flags_constraint_q: Boolean
                    , zshape_sdss_11: Float
                    , zshape_sdss_22: Float
                    , zshape_sdss_12: Float
                    , zshape_sdss_err_11_11: Float
                    , zshape_sdss_err_22_22: Float
                    , zshape_sdss_err_12_12: Float
                    , zshape_sdss_centroid_ra: Double
                    , zshape_sdss_centroid_dec: Double
                    , zshape_sdss_psf_11: Float
                    , zshape_sdss_psf_22: Float
                    , zshape_sdss_psf_12: Float
                    , zshape_sdss_flags: Boolean
                    , zshape_sdss_centroid_flags: Boolean
                    , zshape_sdss_flags_unweightedbad: Boolean
                    , zshape_sdss_flags_unweighted: Boolean
                    , zshape_sdss_flags_shift: Boolean
                    , zshape_sdss_flags_maxiter: Boolean
                    , zshape_sdss_flags_psf: Boolean
                    , zcmodel_initial_flux: Double
                    , zcmodel_initial_mag: Float
                    , zcmodel_initial_flux_err: Double
                    , zcmodel_initial_mag_err: Float
                    , zcmodel_initial_flux_inner: Double
                    , zcmodel_initial_mag_inner: Float
                    , zcmodel_exp_flux: Double
                    , zcmodel_exp_mag: Float
                    , zcmodel_exp_flux_err: Double
                    , zcmodel_exp_mag_err: Float
                    , zcmodel_exp_flux_inner: Double
                    , zcmodel_exp_mag_inner: Float
                    , zcmodel_dev_flux: Double
                    , zcmodel_dev_mag: Float
                    , zcmodel_dev_flux_err: Double
                    , zcmodel_dev_mag_err: Float
                    , zcmodel_dev_flux_inner: Double
                    , zcmodel_dev_mag_inner: Float
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
                    , zcmodel_dev_flux_apcorr: Float
                    , zcmodel_dev_flux_apcorr_err: Float
                    , zcmodel_exp_flux_apcorr: Float
                    , zcmodel_exp_flux_apcorr_err: Float
                    , zcmodel_flux_apcorr: Float
                    , zcmodel_flux_apcorr_err: Float
                    , zcmodel_initial_flux_flags: Boolean
                    , zcmodel_initial_flags_badreference: Boolean
                    , zcmodel_initial_flags_numericerror: Boolean
                    , zcmodel_exp_flux_flags: Boolean
                    , zcmodel_exp_flags_badreference: Boolean
                    , zcmodel_exp_flags_numericerror: Boolean
                    , zcmodel_dev_flux_flags: Boolean
                    , zcmodel_dev_flags_badreference: Boolean
                    , zcmodel_dev_flags_numericerror: Boolean
                    , zcmodel_flux_flags: Boolean
                    , zcmodel_flags_region_maxarea: Boolean
                    , zcmodel_flags_region_maxbadpixelfraction: Boolean
                    , zcmodel_flags_badreference: Boolean
                    , zcmodel_flags_nopsf: Boolean
                    , zcmodel_flags_nowcs: Boolean
                    , zcmodel_flags_nocalib: Boolean
                    , zcmodel_flags_badcentroid: Boolean
                    , zcmodel_dev_flux_flags_apcorr: Boolean
                    , zcmodel_exp_flux_flags_apcorr: Boolean
                    , zcmodel_flux_flags_apcorr: Boolean
                    , zcountinputs: Int
                    , zvariance: Float
                    , zclassification_extendedness: Float
                    , zflags_pixel_edge: Boolean
                    , zflags_pixel_interpolated_any: Boolean
                    , zflags_pixel_interpolated_center: Boolean
                    , zflags_pixel_saturated_any: Boolean
                    , zflags_pixel_saturated_center: Boolean
                    , zflags_pixel_cr_any: Boolean
                    , zflags_pixel_cr_center: Boolean
                    , zflags_pixel_bad: Boolean
                    , zflags_pixel_suspect_any: Boolean
                    , zflags_pixel_suspect_center: Boolean
                    , zflags_pixel_offimage: Boolean
                    , zflags_pixel_bright_object_center: Boolean
                    , zflags_pixel_clipped_any: Boolean
                    , zflags_pixel_bright_object_any: Boolean
                    , yflux_naive: Double
                    , ymag_naive: Float
                    , yflux_naive_err: Double
                    , ymag_naive_err: Float
                    , yflux_naive_flags: Boolean
                    , yflux_sinc: Double
                    , ymag_sinc: Float
                    , yflux_sinc_err: Double
                    , ymag_sinc_err: Float
                    , yflux_sinc_flags: Boolean
                    , yflux_psf: Double
                    , ymag_psf: Float
                    , yflux_psf_err: Double
                    , ymag_psf_err: Float
                    , yflux_psf_apcorr: Float
                    , yflux_psf_apcorr_err: Float
                    , yflux_psf_flags: Boolean
                    , yflux_psf_flags_apcorr: Boolean
                    , yflux_kron: Double
                    , ymag_kron: Float
                    , yflux_kron_err: Double
                    , ymag_kron_err: Float
                    , yflux_kron_radius: Float
                    , yflux_kron_radiusforradius: Float
                    , yflux_kron_psfradius: Float
                    , yflux_kron_apcorr: Float
                    , yflux_kron_apcorr_err: Float
                    , yflux_kron_flags: Boolean
                    , yflux_kron_flags_edge: Boolean
                    , yflux_kron_flags_radius: Boolean
                    , yflux_kron_flags_smallradius: Boolean
                    , yflux_kron_flags_usedminimumradius: Boolean
                    , yflux_kron_flags_usedpsfradius: Boolean
                    , yflux_kron_flags_badshape: Boolean
                    , yflux_kron_flags_apcorr: Boolean
                    , yflux_aperture10: Double
                    , ymag_aperture10: Float
                    , yflux_aperture15: Double
                    , ymag_aperture15: Float
                    , yflux_aperture20: Double
                    , ymag_aperture20: Float
                    , yflux_aperture30: Double
                    , ymag_aperture30: Float
                    , yflux_aperture40: Double
                    , ymag_aperture40: Float
                    , yflux_aperture57: Double
                    , ymag_aperture57: Float
                    , yflux_aperture84: Double
                    , ymag_aperture84: Float
                    , yflux_aperture118: Double
                    , ymag_aperture118: Float
                    , yflux_aperture168: Double
                    , ymag_aperture168: Float
                    , yflux_aperture235: Double
                    , ymag_aperture235: Float
                    , yflux_aperture10_err: Double
                    , ymag_aperture10_err: Float
                    , yflux_aperture15_err: Double
                    , ymag_aperture15_err: Float
                    , yflux_aperture20_err: Double
                    , ymag_aperture20_err: Float
                    , yflux_aperture30_err: Double
                    , ymag_aperture30_err: Float
                    , yflux_aperture40_err: Double
                    , ymag_aperture40_err: Float
                    , yflux_aperture57_err: Double
                    , ymag_aperture57_err: Float
                    , yflux_aperture84_err: Double
                    , ymag_aperture84_err: Float
                    , yflux_aperture118_err: Double
                    , ymag_aperture118_err: Float
                    , yflux_aperture168_err: Double
                    , ymag_aperture168_err: Float
                    , yflux_aperture235_err: Double
                    , ymag_aperture235_err: Float
                    , yflux_aperture10_ninterpolatedpixel: Int
                    , yflux_aperture15_ninterpolatedpixel: Int
                    , yflux_aperture20_ninterpolatedpixel: Int
                    , yflux_aperture30_ninterpolatedpixel: Int
                    , yflux_aperture40_ninterpolatedpixel: Int
                    , yflux_aperture57_ninterpolatedpixel: Int
                    , yflux_aperture84_ninterpolatedpixel: Int
                    , yflux_aperture118_ninterpolatedpixel: Int
                    , yflux_aperture168_ninterpolatedpixel: Int
                    , yflux_aperture235_ninterpolatedpixel: Int
                    , yflux_aperture_nprofile: Int
                    , yflux_aperture_flags: Boolean
                    , ycentroid_naive_ra: Double
                    , ycentroid_naive_dec: Double
                    , ycentroid_naive_flags: Boolean
                    , ycentroid_sdss_ra: Double
                    , ycentroid_sdss_dec: Double
                    , ycentroid_sdss_err_11: Float
                    , ycentroid_sdss_err_22: Float
                    , ycentroid_sdss_flags: Boolean
                    , ymultishapelet_psf_inner0: Float
                    , ymultishapelet_psf_inner1: Float
                    , ymultishapelet_psf_inner2: Float
                    , ymultishapelet_psf_inner3: Float
                    , ymultishapelet_psf_inner4: Float
                    , ymultishapelet_psf_inner5: Float
                    , ymultishapelet_psf_outer0: Float
                    , ymultishapelet_psf_outer1: Float
                    , ymultishapelet_psf_outer2: Float
                    , ymultishapelet_psf_ellipse_11: Float
                    , ymultishapelet_psf_ellipse_22: Float
                    , ymultishapelet_psf_ellipse_12: Float
                    , ymultishapelet_psf_chisq: Float
                    , ymultishapelet_psf_integral: Float
                    , ymultishapelet_psf_flags: Boolean
                    , ymultishapelet_psf_flags_maxiter: Boolean
                    , ymultishapelet_psf_flags_tinystep: Boolean
                    , ymultishapelet_psf_flags_constraint_r: Boolean
                    , ymultishapelet_psf_flags_constraint_q: Boolean
                    , yshape_sdss_11: Float
                    , yshape_sdss_22: Float
                    , yshape_sdss_12: Float
                    , yshape_sdss_err_11_11: Float
                    , yshape_sdss_err_22_22: Float
                    , yshape_sdss_err_12_12: Float
                    , yshape_sdss_centroid_ra: Double
                    , yshape_sdss_centroid_dec: Double
                    , yshape_sdss_psf_11: Float
                    , yshape_sdss_psf_22: Float
                    , yshape_sdss_psf_12: Float
                    , yshape_sdss_flags: Boolean
                    , yshape_sdss_centroid_flags: Boolean
                    , yshape_sdss_flags_unweightedbad: Boolean
                    , yshape_sdss_flags_unweighted: Boolean
                    , yshape_sdss_flags_shift: Boolean
                    , yshape_sdss_flags_maxiter: Boolean
                    , yshape_sdss_flags_psf: Boolean
                    , ycmodel_initial_flux: Double
                    , ycmodel_initial_mag: Float
                    , ycmodel_initial_flux_err: Double
                    , ycmodel_initial_mag_err: Float
                    , ycmodel_initial_flux_inner: Double
                    , ycmodel_initial_mag_inner: Float
                    , ycmodel_exp_flux: Double
                    , ycmodel_exp_mag: Float
                    , ycmodel_exp_flux_err: Double
                    , ycmodel_exp_mag_err: Float
                    , ycmodel_exp_flux_inner: Double
                    , ycmodel_exp_mag_inner: Float
                    , ycmodel_dev_flux: Double
                    , ycmodel_dev_mag: Float
                    , ycmodel_dev_flux_err: Double
                    , ycmodel_dev_mag_err: Float
                    , ycmodel_dev_flux_inner: Double
                    , ycmodel_dev_mag_inner: Float
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
                    , ycmodel_dev_flux_apcorr: Float
                    , ycmodel_dev_flux_apcorr_err: Float
                    , ycmodel_exp_flux_apcorr: Float
                    , ycmodel_exp_flux_apcorr_err: Float
                    , ycmodel_flux_apcorr: Float
                    , ycmodel_flux_apcorr_err: Float
                    , ycmodel_initial_flux_flags: Boolean
                    , ycmodel_initial_flags_badreference: Boolean
                    , ycmodel_initial_flags_numericerror: Boolean
                    , ycmodel_exp_flux_flags: Boolean
                    , ycmodel_exp_flags_badreference: Boolean
                    , ycmodel_exp_flags_numericerror: Boolean
                    , ycmodel_dev_flux_flags: Boolean
                    , ycmodel_dev_flags_badreference: Boolean
                    , ycmodel_dev_flags_numericerror: Boolean
                    , ycmodel_flux_flags: Boolean
                    , ycmodel_flags_region_maxarea: Boolean
                    , ycmodel_flags_region_maxbadpixelfraction: Boolean
                    , ycmodel_flags_badreference: Boolean
                    , ycmodel_flags_nopsf: Boolean
                    , ycmodel_flags_nowcs: Boolean
                    , ycmodel_flags_nocalib: Boolean
                    , ycmodel_flags_badcentroid: Boolean
                    , ycmodel_dev_flux_flags_apcorr: Boolean
                    , ycmodel_exp_flux_flags_apcorr: Boolean
                    , ycmodel_flux_flags_apcorr: Boolean
                    , ycountinputs: Int
                    , yvariance: Float
                    , yclassification_extendedness: Float
                    , yflags_pixel_edge: Boolean
                    , yflags_pixel_interpolated_any: Boolean
                    , yflags_pixel_interpolated_center: Boolean
                    , yflags_pixel_saturated_any: Boolean
                    , yflags_pixel_saturated_center: Boolean
                    , yflags_pixel_cr_any: Boolean
                    , yflags_pixel_cr_center: Boolean
                    , yflags_pixel_bad: Boolean
                    , yflags_pixel_suspect_any: Boolean
                    , yflags_pixel_suspect_center: Boolean
                    , yflags_pixel_offimage: Boolean
                    , yflags_pixel_bright_object_center: Boolean
                    , yflags_pixel_clipped_any: Boolean
                    , yflags_pixel_bright_object_any: Boolean
                  )

  def forced(sc: SparkContext) = {
    sc.textFile("hdfs:///user/matsumoto/sample_pdr1_wide.photoz_demp").
      map { lines =>
        val elms = lines.split(',')
        val object_id = elms(0).toLong
        val ra = elms(1).toDouble
        val dec = elms(2).toDouble
        val coord = elms(3) + ',' + elms(4) + ',' + elms(5)
        val skymap_id = elms(6).toInt
        val tract = elms(7).toInt
        val patch = elms(8).toInt
        val patch_s = elms(9).toString
        val parent_id = elms(10).toLong
        val deblend_nchild = elms(11).toInt
        val a_g = elms(12).toFloat
        val a_r = elms(13).toFloat
        val a_i = elms(14).toFloat
        val a_z = elms(15).toFloat
        val a_y = elms(16).toFloat
        val detect_is_primary = elms(17).toBoolean
        val merge_footprint_i2 = elms(18).toBoolean
        val merge_footprint_i = elms(19).toBoolean
        val merge_footprint_r = elms(20).toBoolean
        val merge_footprint_z = elms(21).toBoolean
        val merge_footprint_y = elms(22).toBoolean
        val merge_footprint_g = elms(23).toBoolean
        val merge_footprint_n921 = elms(24).toBoolean
        val merge_footprint_n816 = elms(25).toBoolean
        val merge_footprint_n1010 = elms(26).toBoolean
        val merge_footprint_n387 = elms(27).toBoolean
        val merge_footprint_n515 = elms(28).toBoolean
        val merge_footprint_sky = elms(29).toBoolean
        val merge_peak_i2 = elms(30).toBoolean
        val merge_peak_i = elms(31).toBoolean
        val merge_peak_r = elms(32).toBoolean
        val merge_peak_z = elms(33).toBoolean
        val merge_peak_y = elms(34).toBoolean
        val merge_peak_g = elms(35).toBoolean
        val merge_peak_n921 = elms(36).toBoolean
        val merge_peak_n816 = elms(37).toBoolean
        val merge_peak_n1010 = elms(38).toBoolean
        val merge_peak_n387 = elms(39).toBoolean
        val merge_peak_n515 = elms(40).toBoolean
        val merge_peak_sky = elms(41).toBoolean
        val detect_is_patch_inner = elms(42).toBoolean
        val detect_is_tract_inner = elms(43).toBoolean
        val merge_measurement_i2 = elms(44).toBoolean
        val merge_measurement_i = elms(45).toBoolean
        val merge_measurement_r = elms(46).toBoolean
        val merge_measurement_z = elms(47).toBoolean
        val merge_measurement_y = elms(48).toBoolean
        val merge_measurement_g = elms(49).toBoolean
        val merge_measurement_n921 = elms(50).toBoolean
        val merge_measurement_n816 = elms(51).toBoolean
        val merge_measurement_n1010 = elms(52).toBoolean
        val merge_measurement_n387 = elms(53).toBoolean
        val merge_measurement_n515 = elms(54).toBoolean
        val gflux_naive = elms(55).toDouble
        val gmag_naive = elms(56).toFloat
        val gflux_naive_err = elms(57).toDouble
        val gmag_naive_err = elms(58).toFloat
        val gflux_naive_flags = elms(59).toBoolean
        val gflux_sinc = elms(60).toDouble
        val gmag_sinc = elms(61).toFloat
        val gflux_sinc_err = elms(62).toDouble
        val gmag_sinc_err = elms(63).toFloat
        val gflux_sinc_flags = elms(64).toBoolean
        val gflux_psf = elms(65).toDouble
        val gmag_psf = elms(66).toFloat
        val gflux_psf_err = elms(67).toDouble
        val gmag_psf_err = elms(68).toFloat
        val gflux_psf_apcorr = elms(69).toFloat
        val gflux_psf_apcorr_err = elms(70).toFloat
        val gflux_psf_flags = elms(71).toBoolean
        val gflux_psf_flags_apcorr = elms(72).toBoolean
        val gflux_kron = elms(73).toDouble
        val gmag_kron = elms(74).toFloat
        val gflux_kron_err = elms(75).toDouble
        val gmag_kron_err = elms(76).toFloat
        val gflux_kron_radius = elms(77).toFloat
        val gflux_kron_radiusforradius = elms(78).toFloat
        val gflux_kron_psfradius = elms(79).toFloat
        val gflux_kron_apcorr = elms(80).toFloat
        val gflux_kron_apcorr_err = elms(81).toFloat
        val gflux_kron_flags = elms(82).toBoolean
        val gflux_kron_flags_edge = elms(83).toBoolean
        val gflux_kron_flags_radius = elms(84).toBoolean
        val gflux_kron_flags_smallradius = elms(85).toBoolean
        val gflux_kron_flags_usedminimumradius = elms(86).toBoolean
        val gflux_kron_flags_usedpsfradius = elms(87).toBoolean
        val gflux_kron_flags_badshape = elms(88).toBoolean
        val gflux_kron_flags_apcorr = elms(89).toBoolean
        val gflux_aperture10 = elms(90).toDouble
        val gmag_aperture10 = elms(91).toFloat
        val gflux_aperture15 = elms(92).toDouble
        val gmag_aperture15 = elms(93).toFloat
        val gflux_aperture20 = elms(94).toDouble
        val gmag_aperture20 = elms(95).toFloat
        val gflux_aperture30 = elms(96).toDouble
        val gmag_aperture30 = elms(97).toFloat
        val gflux_aperture40 = elms(98).toDouble
        val gmag_aperture40 = elms(99).toFloat
        val gflux_aperture57 = elms(100).toDouble
        val gmag_aperture57 = elms(101).toFloat
        val gflux_aperture84 = elms(102).toDouble
        val gmag_aperture84 = elms(103).toFloat
        val gflux_aperture118 = elms(104).toDouble
        val gmag_aperture118 = elms(105).toFloat
        val gflux_aperture168 = elms(106).toDouble
        val gmag_aperture168 = elms(107).toFloat
        val gflux_aperture235 = elms(108).toDouble
        val gmag_aperture235 = elms(109).toFloat
        val gflux_aperture10_err = elms(110).toDouble
        val gmag_aperture10_err = elms(111).toFloat
        val gflux_aperture15_err = elms(112).toDouble
        val gmag_aperture15_err = elms(113).toFloat
        val gflux_aperture20_err = elms(114).toDouble
        val gmag_aperture20_err = elms(115).toFloat
        val gflux_aperture30_err = elms(116).toDouble
        val gmag_aperture30_err = elms(117).toFloat
        val gflux_aperture40_err = elms(118).toDouble
        val gmag_aperture40_err = elms(119).toFloat
        val gflux_aperture57_err = elms(120).toDouble
        val gmag_aperture57_err = elms(121).toFloat
        val gflux_aperture84_err = elms(122).toDouble
        val gmag_aperture84_err = elms(123).toFloat
        val gflux_aperture118_err = elms(124).toDouble
        val gmag_aperture118_err = elms(125).toFloat
        val gflux_aperture168_err = elms(126).toDouble
        val gmag_aperture168_err = elms(127).toFloat
        val gflux_aperture235_err = elms(128).toDouble
        val gmag_aperture235_err = elms(129).toFloat
        val gflux_aperture10_ninterpolatedpixel = elms(130).toInt
        val gflux_aperture15_ninterpolatedpixel = elms(131).toInt
        val gflux_aperture20_ninterpolatedpixel = elms(132).toInt
        val gflux_aperture30_ninterpolatedpixel = elms(133).toInt
        val gflux_aperture40_ninterpolatedpixel = elms(134).toInt
        val gflux_aperture57_ninterpolatedpixel = elms(135).toInt
        val gflux_aperture84_ninterpolatedpixel = elms(136).toInt
        val gflux_aperture118_ninterpolatedpixel = elms(137).toInt
        val gflux_aperture168_ninterpolatedpixel = elms(138).toInt
        val gflux_aperture235_ninterpolatedpixel = elms(139).toInt
        val gflux_aperture_nprofile = elms(140).toInt
        val gflux_aperture_flags = elms(141).toBoolean
        val gcentroid_naive_ra = elms(142).toDouble
        val gcentroid_naive_dec = elms(143).toDouble
        val gcentroid_naive_flags = elms(144).toBoolean
        val gcentroid_sdss_ra = elms(145).toDouble
        val gcentroid_sdss_dec = elms(146).toDouble
        val gcentroid_sdss_err_11 = elms(147).toFloat
        val gcentroid_sdss_err_22 = elms(148).toFloat
        val gcentroid_sdss_flags = elms(149).toBoolean
        val gmultishapelet_psf_inner0 = elms(150).toFloat
        val gmultishapelet_psf_inner1 = elms(151).toFloat
        val gmultishapelet_psf_inner2 = elms(152).toFloat
        val gmultishapelet_psf_inner3 = elms(153).toFloat
        val gmultishapelet_psf_inner4 = elms(154).toFloat
        val gmultishapelet_psf_inner5 = elms(155).toFloat
        val gmultishapelet_psf_outer0 = elms(156).toFloat
        val gmultishapelet_psf_outer1 = elms(157).toFloat
        val gmultishapelet_psf_outer2 = elms(158).toFloat
        val gmultishapelet_psf_ellipse_11 = elms(159).toFloat
        val gmultishapelet_psf_ellipse_22 = elms(160).toFloat
        val gmultishapelet_psf_ellipse_12 = elms(161).toFloat
        val gmultishapelet_psf_chisq = elms(162).toFloat
        val gmultishapelet_psf_integral = elms(163).toFloat
        val gmultishapelet_psf_flags = elms(164).toBoolean
        val gmultishapelet_psf_flags_maxiter = elms(165).toBoolean
        val gmultishapelet_psf_flags_tinystep = elms(166).toBoolean
        val gmultishapelet_psf_flags_constraint_r = elms(167).toBoolean
        val gmultishapelet_psf_flags_constraint_q = elms(168).toBoolean
        val gshape_sdss_11 = elms(169).toFloat
        val gshape_sdss_22 = elms(170).toFloat
        val gshape_sdss_12 = elms(171).toFloat
        val gshape_sdss_err_11_11 = elms(172).toFloat
        val gshape_sdss_err_22_22 = elms(173).toFloat
        val gshape_sdss_err_12_12 = elms(174).toFloat
        val gshape_sdss_centroid_ra = elms(175).toDouble
        val gshape_sdss_centroid_dec = elms(176).toDouble
        val gshape_sdss_psf_11 = elms(177).toFloat
        val gshape_sdss_psf_22 = elms(178).toFloat
        val gshape_sdss_psf_12 = elms(179).toFloat
        val gshape_sdss_flags = elms(180).toBoolean
        val gshape_sdss_centroid_flags = elms(181).toBoolean
        val gshape_sdss_flags_unweightedbad = elms(182).toBoolean
        val gshape_sdss_flags_unweighted = elms(183).toBoolean
        val gshape_sdss_flags_shift = elms(184).toBoolean
        val gshape_sdss_flags_maxiter = elms(185).toBoolean
        val gshape_sdss_flags_psf = elms(186).toBoolean
        val gcmodel_initial_flux = elms(187).toDouble
        val gcmodel_initial_mag = elms(188).toFloat
        val gcmodel_initial_flux_err = elms(189).toDouble
        val gcmodel_initial_mag_err = elms(190).toFloat
        val gcmodel_initial_flux_inner = elms(191).toDouble
        val gcmodel_initial_mag_inner = elms(192).toFloat
        val gcmodel_exp_flux = elms(193).toDouble
        val gcmodel_exp_mag = elms(194).toFloat
        val gcmodel_exp_flux_err = elms(195).toDouble
        val gcmodel_exp_mag_err = elms(196).toFloat
        val gcmodel_exp_flux_inner = elms(197).toDouble
        val gcmodel_exp_mag_inner = elms(198).toFloat
        val gcmodel_dev_flux = elms(199).toDouble
        val gcmodel_dev_mag = elms(200).toFloat
        val gcmodel_dev_flux_err = elms(201).toDouble
        val gcmodel_dev_mag_err = elms(202).toFloat
        val gcmodel_dev_flux_inner = elms(203).toDouble
        val gcmodel_dev_mag_inner = elms(204).toFloat
        val gcmodel_center_ra = elms(205).toDouble
        val gcmodel_center_dec = elms(206).toDouble
        val gcmodel_flux = elms(207).toDouble
        val gcmodel_mag = elms(208).toFloat
        val gcmodel_flux_err = elms(209).toDouble
        val gcmodel_mag_err = elms(210).toFloat
        val gcmodel_flux_inner = elms(211).toDouble
        val gcmodel_mag_inner = elms(212).toFloat
        val gcmodel_fracdev = elms(213).toFloat
        val gcmodel_objective = elms(214).toFloat
        val gcmodel_dev_flux_apcorr = elms(215).toFloat
        val gcmodel_dev_flux_apcorr_err = elms(216).toFloat
        val gcmodel_exp_flux_apcorr = elms(217).toFloat
        val gcmodel_exp_flux_apcorr_err = elms(218).toFloat
        val gcmodel_flux_apcorr = elms(219).toFloat
        val gcmodel_flux_apcorr_err = elms(220).toFloat
        val gcmodel_initial_flux_flags = elms(221).toBoolean
        val gcmodel_initial_flags_badreference = elms(222).toBoolean
        val gcmodel_initial_flags_numericerror = elms(223).toBoolean
        val gcmodel_exp_flux_flags = elms(224).toBoolean
        val gcmodel_exp_flags_badreference = elms(225).toBoolean
        val gcmodel_exp_flags_numericerror = elms(226).toBoolean
        val gcmodel_dev_flux_flags = elms(227).toBoolean
        val gcmodel_dev_flags_badreference = elms(228).toBoolean
        val gcmodel_dev_flags_numericerror = elms(229).toBoolean
        val gcmodel_flux_flags = elms(230).toBoolean
        val gcmodel_flags_region_maxarea = elms(231).toBoolean
        val gcmodel_flags_region_maxbadpixelfraction = elms(232).toBoolean
        val gcmodel_flags_badreference = elms(233).toBoolean
        val gcmodel_flags_nopsf = elms(234).toBoolean
        val gcmodel_flags_nowcs = elms(235).toBoolean
        val gcmodel_flags_nocalib = elms(236).toBoolean
        val gcmodel_flags_badcentroid = elms(237).toBoolean
        val gcmodel_dev_flux_flags_apcorr = elms(238).toBoolean
        val gcmodel_exp_flux_flags_apcorr = elms(239).toBoolean
        val gcmodel_flux_flags_apcorr = elms(240).toBoolean
        val gcountinputs = elms(241).toInt
        val gvariance = elms(242).toFloat
        val gclassification_extendedness = elms(243).toFloat
        val gflags_pixel_edge = elms(244).toBoolean
        val gflags_pixel_interpolated_any = elms(245).toBoolean
        val gflags_pixel_interpolated_center = elms(246).toBoolean
        val gflags_pixel_saturated_any = elms(247).toBoolean
        val gflags_pixel_saturated_center = elms(248).toBoolean
        val gflags_pixel_cr_any = elms(249).toBoolean
        val gflags_pixel_cr_center = elms(250).toBoolean
        val gflags_pixel_bad = elms(251).toBoolean
        val gflags_pixel_suspect_any = elms(252).toBoolean
        val gflags_pixel_suspect_center = elms(253).toBoolean
        val gflags_pixel_offimage = elms(254).toBoolean
        val gflags_pixel_bright_object_center = elms(255).toBoolean
        val gflags_pixel_clipped_any = elms(256).toBoolean
        val gflags_pixel_bright_object_any = elms(257).toBoolean
        val rflux_naive = elms(258).toDouble
        val rmag_naive = elms(259).toFloat
        val rflux_naive_err = elms(260).toDouble
        val rmag_naive_err = elms(261).toFloat
        val rflux_naive_flags = elms(262).toBoolean
        val rflux_sinc = elms(263).toDouble
        val rmag_sinc = elms(264).toFloat
        val rflux_sinc_err = elms(265).toDouble
        val rmag_sinc_err = elms(266).toFloat
        val rflux_sinc_flags = elms(267).toBoolean
        val rflux_psf = elms(268).toDouble
        val rmag_psf = elms(269).toFloat
        val rflux_psf_err = elms(270).toDouble
        val rmag_psf_err = elms(271).toFloat
        val rflux_psf_apcorr = elms(272).toFloat
        val rflux_psf_apcorr_err = elms(273).toFloat
        val rflux_psf_flags = elms(274).toBoolean
        val rflux_psf_flags_apcorr = elms(275).toBoolean
        val rflux_kron = elms(276).toDouble
        val rmag_kron = elms(277).toFloat
        val rflux_kron_err = elms(278).toDouble
        val rmag_kron_err = elms(279).toFloat
        val rflux_kron_radius = elms(280).toFloat
        val rflux_kron_radiusforradius = elms(281).toFloat
        val rflux_kron_psfradius = elms(282).toFloat
        val rflux_kron_apcorr = elms(283).toFloat
        val rflux_kron_apcorr_err = elms(284).toFloat
        val rflux_kron_flags = elms(285).toBoolean
        val rflux_kron_flags_edge = elms(286).toBoolean
        val rflux_kron_flags_radius = elms(287).toBoolean
        val rflux_kron_flags_smallradius = elms(288).toBoolean
        val rflux_kron_flags_usedminimumradius = elms(289).toBoolean
        val rflux_kron_flags_usedpsfradius = elms(290).toBoolean
        val rflux_kron_flags_badshape = elms(291).toBoolean
        val rflux_kron_flags_apcorr = elms(292).toBoolean
        val rflux_aperture10 = elms(293).toDouble
        val rmag_aperture10 = elms(294).toFloat
        val rflux_aperture15 = elms(295).toDouble
        val rmag_aperture15 = elms(296).toFloat
        val rflux_aperture20 = elms(297).toDouble
        val rmag_aperture20 = elms(298).toFloat
        val rflux_aperture30 = elms(299).toDouble
        val rmag_aperture30 = elms(300).toFloat
        val rflux_aperture40 = elms(301).toDouble
        val rmag_aperture40 = elms(302).toFloat
        val rflux_aperture57 = elms(303).toDouble
        val rmag_aperture57 = elms(304).toFloat
        val rflux_aperture84 = elms(305).toDouble
        val rmag_aperture84 = elms(306).toFloat
        val rflux_aperture118 = elms(307).toDouble
        val rmag_aperture118 = elms(308).toFloat
        val rflux_aperture168 = elms(309).toDouble
        val rmag_aperture168 = elms(310).toFloat
        val rflux_aperture235 = elms(311).toDouble
        val rmag_aperture235 = elms(312).toFloat
        val rflux_aperture10_err = elms(313).toDouble
        val rmag_aperture10_err = elms(314).toFloat
        val rflux_aperture15_err = elms(315).toDouble
        val rmag_aperture15_err = elms(316).toFloat
        val rflux_aperture20_err = elms(317).toDouble
        val rmag_aperture20_err = elms(318).toFloat
        val rflux_aperture30_err = elms(319).toDouble
        val rmag_aperture30_err = elms(320).toFloat
        val rflux_aperture40_err = elms(321).toDouble
        val rmag_aperture40_err = elms(322).toFloat
        val rflux_aperture57_err = elms(323).toDouble
        val rmag_aperture57_err = elms(324).toFloat
        val rflux_aperture84_err = elms(325).toDouble
        val rmag_aperture84_err = elms(326).toFloat
        val rflux_aperture118_err = elms(327).toDouble
        val rmag_aperture118_err = elms(328).toFloat
        val rflux_aperture168_err = elms(329).toDouble
        val rmag_aperture168_err = elms(330).toFloat
        val rflux_aperture235_err = elms(331).toDouble
        val rmag_aperture235_err = elms(332).toFloat
        val rflux_aperture10_ninterpolatedpixel = elms(333).toInt
        val rflux_aperture15_ninterpolatedpixel = elms(334).toInt
        val rflux_aperture20_ninterpolatedpixel = elms(335).toInt
        val rflux_aperture30_ninterpolatedpixel = elms(336).toInt
        val rflux_aperture40_ninterpolatedpixel = elms(337).toInt
        val rflux_aperture57_ninterpolatedpixel = elms(338).toInt
        val rflux_aperture84_ninterpolatedpixel = elms(339).toInt
        val rflux_aperture118_ninterpolatedpixel = elms(340).toInt
        val rflux_aperture168_ninterpolatedpixel = elms(341).toInt
        val rflux_aperture235_ninterpolatedpixel = elms(342).toInt
        val rflux_aperture_nprofile = elms(343).toInt
        val rflux_aperture_flags = elms(344).toBoolean
        val rcentroid_naive_ra = elms(345).toDouble
        val rcentroid_naive_dec = elms(346).toDouble
        val rcentroid_naive_flags = elms(347).toBoolean
        val rcentroid_sdss_ra = elms(348).toDouble
        val rcentroid_sdss_dec = elms(349).toDouble
        val rcentroid_sdss_err_11 = elms(350).toFloat
        val rcentroid_sdss_err_22 = elms(351).toFloat
        val rcentroid_sdss_flags = elms(352).toBoolean
        val rmultishapelet_psf_inner0 = elms(353).toFloat
        val rmultishapelet_psf_inner1 = elms(354).toFloat
        val rmultishapelet_psf_inner2 = elms(355).toFloat
        val rmultishapelet_psf_inner3 = elms(356).toFloat
        val rmultishapelet_psf_inner4 = elms(357).toFloat
        val rmultishapelet_psf_inner5 = elms(358).toFloat
        val rmultishapelet_psf_outer0 = elms(359).toFloat
        val rmultishapelet_psf_outer1 = elms(360).toFloat
        val rmultishapelet_psf_outer2 = elms(361).toFloat
        val rmultishapelet_psf_ellipse_11 = elms(362).toFloat
        val rmultishapelet_psf_ellipse_22 = elms(363).toFloat
        val rmultishapelet_psf_ellipse_12 = elms(364).toFloat
        val rmultishapelet_psf_chisq = elms(365).toFloat
        val rmultishapelet_psf_integral = elms(366).toFloat
        val rmultishapelet_psf_flags = elms(367).toBoolean
        val rmultishapelet_psf_flags_maxiter = elms(368).toBoolean
        val rmultishapelet_psf_flags_tinystep = elms(369).toBoolean
        val rmultishapelet_psf_flags_constraint_r = elms(370).toBoolean
        val rmultishapelet_psf_flags_constraint_q = elms(371).toBoolean
        val rshape_sdss_11 = elms(372).toFloat
        val rshape_sdss_22 = elms(373).toFloat
        val rshape_sdss_12 = elms(374).toFloat
        val rshape_sdss_err_11_11 = elms(375).toFloat
        val rshape_sdss_err_22_22 = elms(376).toFloat
        val rshape_sdss_err_12_12 = elms(377).toFloat
        val rshape_sdss_centroid_ra = elms(378).toDouble
        val rshape_sdss_centroid_dec = elms(379).toDouble
        val rshape_sdss_psf_11 = elms(380).toFloat
        val rshape_sdss_psf_22 = elms(381).toFloat
        val rshape_sdss_psf_12 = elms(382).toFloat
        val rshape_sdss_flags = elms(383).toBoolean
        val rshape_sdss_centroid_flags = elms(384).toBoolean
        val rshape_sdss_flags_unweightedbad = elms(385).toBoolean
        val rshape_sdss_flags_unweighted = elms(386).toBoolean
        val rshape_sdss_flags_shift = elms(387).toBoolean
        val rshape_sdss_flags_maxiter = elms(388).toBoolean
        val rshape_sdss_flags_psf = elms(389).toBoolean
        val rcmodel_initial_flux = elms(390).toDouble
        val rcmodel_initial_mag = elms(391).toFloat
        val rcmodel_initial_flux_err = elms(392).toDouble
        val rcmodel_initial_mag_err = elms(393).toFloat
        val rcmodel_initial_flux_inner = elms(394).toDouble
        val rcmodel_initial_mag_inner = elms(395).toFloat
        val rcmodel_exp_flux = elms(396).toDouble
        val rcmodel_exp_mag = elms(397).toFloat
        val rcmodel_exp_flux_err = elms(398).toDouble
        val rcmodel_exp_mag_err = elms(399).toFloat
        val rcmodel_exp_flux_inner = elms(400).toDouble
        val rcmodel_exp_mag_inner = elms(401).toFloat
        val rcmodel_dev_flux = elms(402).toDouble
        val rcmodel_dev_mag = elms(403).toFloat
        val rcmodel_dev_flux_err = elms(404).toDouble
        val rcmodel_dev_mag_err = elms(405).toFloat
        val rcmodel_dev_flux_inner = elms(406).toDouble
        val rcmodel_dev_mag_inner = elms(407).toFloat
        val rcmodel_center_ra = elms(408).toDouble
        val rcmodel_center_dec = elms(409).toDouble
        val rcmodel_flux = elms(410).toDouble
        val rcmodel_mag = elms(411).toFloat
        val rcmodel_flux_err = elms(412).toDouble
        val rcmodel_mag_err = elms(413).toFloat
        val rcmodel_flux_inner = elms(414).toDouble
        val rcmodel_mag_inner = elms(415).toFloat
        val rcmodel_fracdev = elms(416).toFloat
        val rcmodel_objective = elms(417).toFloat
        val rcmodel_dev_flux_apcorr = elms(418).toFloat
        val rcmodel_dev_flux_apcorr_err = elms(419).toFloat
        val rcmodel_exp_flux_apcorr = elms(420).toFloat
        val rcmodel_exp_flux_apcorr_err = elms(421).toFloat
        val rcmodel_flux_apcorr = elms(422).toFloat
        val rcmodel_flux_apcorr_err = elms(423).toFloat
        val rcmodel_initial_flux_flags = elms(424).toBoolean
        val rcmodel_initial_flags_badreference = elms(425).toBoolean
        val rcmodel_initial_flags_numericerror = elms(426).toBoolean
        val rcmodel_exp_flux_flags = elms(427).toBoolean
        val rcmodel_exp_flags_badreference = elms(428).toBoolean
        val rcmodel_exp_flags_numericerror = elms(429).toBoolean
        val rcmodel_dev_flux_flags = elms(430).toBoolean
        val rcmodel_dev_flags_badreference = elms(431).toBoolean
        val rcmodel_dev_flags_numericerror = elms(432).toBoolean
        val rcmodel_flux_flags = elms(433).toBoolean
        val rcmodel_flags_region_maxarea = elms(434).toBoolean
        val rcmodel_flags_region_maxbadpixelfraction = elms(435).toBoolean
        val rcmodel_flags_badreference = elms(436).toBoolean
        val rcmodel_flags_nopsf = elms(437).toBoolean
        val rcmodel_flags_nowcs = elms(438).toBoolean
        val rcmodel_flags_nocalib = elms(439).toBoolean
        val rcmodel_flags_badcentroid = elms(440).toBoolean
        val rcmodel_dev_flux_flags_apcorr = elms(441).toBoolean
        val rcmodel_exp_flux_flags_apcorr = elms(442).toBoolean
        val rcmodel_flux_flags_apcorr = elms(443).toBoolean
        val rcountinputs = elms(444).toInt
        val rvariance = elms(445).toFloat
        val rclassification_extendedness = elms(446).toFloat
        val rflags_pixel_edge = elms(447).toBoolean
        val rflags_pixel_interpolated_any = elms(448).toBoolean
        val rflags_pixel_interpolated_center = elms(449).toBoolean
        val rflags_pixel_saturated_any = elms(450).toBoolean
        val rflags_pixel_saturated_center = elms(451).toBoolean
        val rflags_pixel_cr_any = elms(452).toBoolean
        val rflags_pixel_cr_center = elms(453).toBoolean
        val rflags_pixel_bad = elms(454).toBoolean
        val rflags_pixel_suspect_any = elms(455).toBoolean
        val rflags_pixel_suspect_center = elms(456).toBoolean
        val rflags_pixel_offimage = elms(457).toBoolean
        val rflags_pixel_bright_object_center = elms(458).toBoolean
        val rflags_pixel_clipped_any = elms(459).toBoolean
        val rflags_pixel_bright_object_any = elms(460).toBoolean
        val iflux_naive = elms(461).toDouble
        val imag_naive = elms(462).toFloat
        val iflux_naive_err = elms(463).toDouble
        val imag_naive_err = elms(464).toFloat
        val iflux_naive_flags = elms(465).toBoolean
        val iflux_sinc = elms(466).toDouble
        val imag_sinc = elms(467).toFloat
        val iflux_sinc_err = elms(468).toDouble
        val imag_sinc_err = elms(469).toFloat
        val iflux_sinc_flags = elms(470).toBoolean
        val iflux_psf = elms(471).toDouble
        val imag_psf = elms(472).toFloat
        val iflux_psf_err = elms(473).toDouble
        val imag_psf_err = elms(474).toFloat
        val iflux_psf_apcorr = elms(475).toFloat
        val iflux_psf_apcorr_err = elms(476).toFloat
        val iflux_psf_flags = elms(477).toBoolean
        val iflux_psf_flags_apcorr = elms(478).toBoolean
        val iflux_kron = elms(479).toDouble
        val imag_kron = elms(480).toFloat
        val iflux_kron_err = elms(481).toDouble
        val imag_kron_err = elms(482).toFloat
        val iflux_kron_radius = elms(483).toFloat
        val iflux_kron_radiusforradius = elms(484).toFloat
        val iflux_kron_psfradius = elms(485).toFloat
        val iflux_kron_apcorr = elms(486).toFloat
        val iflux_kron_apcorr_err = elms(487).toFloat
        val iflux_kron_flags = elms(488).toBoolean
        val iflux_kron_flags_edge = elms(489).toBoolean
        val iflux_kron_flags_radius = elms(490).toBoolean
        val iflux_kron_flags_smallradius = elms(491).toBoolean
        val iflux_kron_flags_usedminimumradius = elms(492).toBoolean
        val iflux_kron_flags_usedpsfradius = elms(493).toBoolean
        val iflux_kron_flags_badshape = elms(494).toBoolean
        val iflux_kron_flags_apcorr = elms(495).toBoolean
        val iflux_aperture10 = elms(496).toDouble
        val imag_aperture10 = elms(497).toFloat
        val iflux_aperture15 = elms(498).toDouble
        val imag_aperture15 = elms(499).toFloat
        val iflux_aperture20 = elms(500).toDouble
        val imag_aperture20 = elms(501).toFloat
        val iflux_aperture30 = elms(502).toDouble
        val imag_aperture30 = elms(503).toFloat
        val iflux_aperture40 = elms(504).toDouble
        val imag_aperture40 = elms(505).toFloat
        val iflux_aperture57 = elms(506).toDouble
        val imag_aperture57 = elms(507).toFloat
        val iflux_aperture84 = elms(508).toDouble
        val imag_aperture84 = elms(509).toFloat
        val iflux_aperture118 = elms(510).toDouble
        val imag_aperture118 = elms(511).toFloat
        val iflux_aperture168 = elms(512).toDouble
        val imag_aperture168 = elms(513).toFloat
        val iflux_aperture235 = elms(514).toDouble
        val imag_aperture235 = elms(515).toFloat
        val iflux_aperture10_err = elms(516).toDouble
        val imag_aperture10_err = elms(517).toFloat
        val iflux_aperture15_err = elms(518).toDouble
        val imag_aperture15_err = elms(519).toFloat
        val iflux_aperture20_err = elms(520).toDouble
        val imag_aperture20_err = elms(521).toFloat
        val iflux_aperture30_err = elms(522).toDouble
        val imag_aperture30_err = elms(523).toFloat
        val iflux_aperture40_err = elms(524).toDouble
        val imag_aperture40_err = elms(525).toFloat
        val iflux_aperture57_err = elms(526).toDouble
        val imag_aperture57_err = elms(527).toFloat
        val iflux_aperture84_err = elms(528).toDouble
        val imag_aperture84_err = elms(529).toFloat
        val iflux_aperture118_err = elms(530).toDouble
        val imag_aperture118_err = elms(531).toFloat
        val iflux_aperture168_err = elms(532).toDouble
        val imag_aperture168_err = elms(533).toFloat
        val iflux_aperture235_err = elms(534).toDouble
        val imag_aperture235_err = elms(535).toFloat
        val iflux_aperture10_ninterpolatedpixel = elms(536).toInt
        val iflux_aperture15_ninterpolatedpixel = elms(537).toInt
        val iflux_aperture20_ninterpolatedpixel = elms(538).toInt
        val iflux_aperture30_ninterpolatedpixel = elms(539).toInt
        val iflux_aperture40_ninterpolatedpixel = elms(540).toInt
        val iflux_aperture57_ninterpolatedpixel = elms(541).toInt
        val iflux_aperture84_ninterpolatedpixel = elms(542).toInt
        val iflux_aperture118_ninterpolatedpixel = elms(543).toInt
        val iflux_aperture168_ninterpolatedpixel = elms(544).toInt
        val iflux_aperture235_ninterpolatedpixel = elms(545).toInt
        val iflux_aperture_nprofile = elms(546).toInt
        val iflux_aperture_flags = elms(547).toBoolean
        val icentroid_naive_ra = elms(548).toDouble
        val icentroid_naive_dec = elms(549).toDouble
        val icentroid_naive_flags = elms(550).toBoolean
        val icentroid_sdss_ra = elms(551).toDouble
        val icentroid_sdss_dec = elms(552).toDouble
        val icentroid_sdss_err_11 = elms(553).toFloat
        val icentroid_sdss_err_22 = elms(554).toFloat
        val icentroid_sdss_flags = elms(555).toBoolean
        val imultishapelet_psf_inner0 = elms(556).toFloat
        val imultishapelet_psf_inner1 = elms(557).toFloat
        val imultishapelet_psf_inner2 = elms(558).toFloat
        val imultishapelet_psf_inner3 = elms(559).toFloat
        val imultishapelet_psf_inner4 = elms(560).toFloat
        val imultishapelet_psf_inner5 = elms(561).toFloat
        val imultishapelet_psf_outer0 = elms(562).toFloat
        val imultishapelet_psf_outer1 = elms(563).toFloat
        val imultishapelet_psf_outer2 = elms(564).toFloat
        val imultishapelet_psf_ellipse_11 = elms(565).toFloat
        val imultishapelet_psf_ellipse_22 = elms(566).toFloat
        val imultishapelet_psf_ellipse_12 = elms(567).toFloat
        val imultishapelet_psf_chisq = elms(568).toFloat
        val imultishapelet_psf_integral = elms(569).toFloat
        val imultishapelet_psf_flags = elms(570).toBoolean
        val imultishapelet_psf_flags_maxiter = elms(571).toBoolean
        val imultishapelet_psf_flags_tinystep = elms(572).toBoolean
        val imultishapelet_psf_flags_constraint_r = elms(573).toBoolean
        val imultishapelet_psf_flags_constraint_q = elms(574).toBoolean
        val ishape_sdss_11 = elms(575).toFloat
        val ishape_sdss_22 = elms(576).toFloat
        val ishape_sdss_12 = elms(577).toFloat
        val ishape_sdss_err_11_11 = elms(578).toFloat
        val ishape_sdss_err_22_22 = elms(579).toFloat
        val ishape_sdss_err_12_12 = elms(580).toFloat
        val ishape_sdss_centroid_ra = elms(581).toDouble
        val ishape_sdss_centroid_dec = elms(582).toDouble
        val ishape_sdss_psf_11 = elms(583).toFloat
        val ishape_sdss_psf_22 = elms(584).toFloat
        val ishape_sdss_psf_12 = elms(585).toFloat
        val ishape_sdss_flags = elms(586).toBoolean
        val ishape_sdss_centroid_flags = elms(587).toBoolean
        val ishape_sdss_flags_unweightedbad = elms(588).toBoolean
        val ishape_sdss_flags_unweighted = elms(589).toBoolean
        val ishape_sdss_flags_shift = elms(590).toBoolean
        val ishape_sdss_flags_maxiter = elms(591).toBoolean
        val ishape_sdss_flags_psf = elms(592).toBoolean
        val icmodel_initial_flux = elms(593).toDouble
        val icmodel_initial_mag = elms(594).toFloat
        val icmodel_initial_flux_err = elms(595).toDouble
        val icmodel_initial_mag_err = elms(596).toFloat
        val icmodel_initial_flux_inner = elms(597).toDouble
        val icmodel_initial_mag_inner = elms(598).toFloat
        val icmodel_exp_flux = elms(599).toDouble
        val icmodel_exp_mag = elms(600).toFloat
        val icmodel_exp_flux_err = elms(601).toDouble
        val icmodel_exp_mag_err = elms(602).toFloat
        val icmodel_exp_flux_inner = elms(603).toDouble
        val icmodel_exp_mag_inner = elms(604).toFloat
        val icmodel_dev_flux = elms(605).toDouble
        val icmodel_dev_mag = elms(606).toFloat
        val icmodel_dev_flux_err = elms(607).toDouble
        val icmodel_dev_mag_err = elms(608).toFloat
        val icmodel_dev_flux_inner = elms(609).toDouble
        val icmodel_dev_mag_inner = elms(610).toFloat
        val icmodel_center_ra = elms(611).toDouble
        val icmodel_center_dec = elms(612).toDouble
        val icmodel_flux = elms(613).toDouble
        val icmodel_mag = elms(614).toFloat
        val icmodel_flux_err = elms(615).toDouble
        val icmodel_mag_err = elms(616).toFloat
        val icmodel_flux_inner = elms(617).toDouble
        val icmodel_mag_inner = elms(618).toFloat
        val icmodel_fracdev = elms(619).toFloat
        val icmodel_objective = elms(620).toFloat
        val icmodel_dev_flux_apcorr = elms(621).toFloat
        val icmodel_dev_flux_apcorr_err = elms(622).toFloat
        val icmodel_exp_flux_apcorr = elms(623).toFloat
        val icmodel_exp_flux_apcorr_err = elms(624).toFloat
        val icmodel_flux_apcorr = elms(625).toFloat
        val icmodel_flux_apcorr_err = elms(626).toFloat
        val icmodel_initial_flux_flags = elms(627).toBoolean
        val icmodel_initial_flags_badreference = elms(628).toBoolean
        val icmodel_initial_flags_numericerror = elms(629).toBoolean
        val icmodel_exp_flux_flags = elms(630).toBoolean
        val icmodel_exp_flags_badreference = elms(631).toBoolean
        val icmodel_exp_flags_numericerror = elms(632).toBoolean
        val icmodel_dev_flux_flags = elms(633).toBoolean
        val icmodel_dev_flags_badreference = elms(634).toBoolean
        val icmodel_dev_flags_numericerror = elms(635).toBoolean
        val icmodel_flux_flags = elms(636).toBoolean
        val icmodel_flags_region_maxarea = elms(637).toBoolean
        val icmodel_flags_region_maxbadpixelfraction = elms(638).toBoolean
        val icmodel_flags_badreference = elms(639).toBoolean
        val icmodel_flags_nopsf = elms(640).toBoolean
        val icmodel_flags_nowcs = elms(641).toBoolean
        val icmodel_flags_nocalib = elms(642).toBoolean
        val icmodel_flags_badcentroid = elms(643).toBoolean
        val icmodel_dev_flux_flags_apcorr = elms(644).toBoolean
        val icmodel_exp_flux_flags_apcorr = elms(645).toBoolean
        val icmodel_flux_flags_apcorr = elms(646).toBoolean
        val icountinputs = elms(647).toInt
        val ivariance = elms(648).toFloat
        val iclassification_extendedness = elms(649).toFloat
        val iflags_pixel_edge = elms(650).toBoolean
        val iflags_pixel_interpolated_any = elms(651).toBoolean
        val iflags_pixel_interpolated_center = elms(652).toBoolean
        val iflags_pixel_saturated_any = elms(653).toBoolean
        val iflags_pixel_saturated_center = elms(654).toBoolean
        val iflags_pixel_cr_any = elms(655).toBoolean
        val iflags_pixel_cr_center = elms(656).toBoolean
        val iflags_pixel_bad = elms(657).toBoolean
        val iflags_pixel_suspect_any = elms(658).toBoolean
        val iflags_pixel_suspect_center = elms(659).toBoolean
        val iflags_pixel_offimage = elms(660).toBoolean
        val iflags_pixel_bright_object_center = elms(661).toBoolean
        val iflags_pixel_clipped_any = elms(662).toBoolean
        val iflags_pixel_bright_object_any = elms(663).toBoolean
        val zflux_naive = elms(664).toDouble
        val zmag_naive = elms(665).toFloat
        val zflux_naive_err = elms(666).toDouble
        val zmag_naive_err = elms(667).toFloat
        val zflux_naive_flags = elms(668).toBoolean
        val zflux_sinc = elms(669).toDouble
        val zmag_sinc = elms(670).toFloat
        val zflux_sinc_err = elms(671).toDouble
        val zmag_sinc_err = elms(672).toFloat
        val zflux_sinc_flags = elms(673).toBoolean
        val zflux_psf = elms(674).toDouble
        val zmag_psf = elms(675).toFloat
        val zflux_psf_err = elms(676).toDouble
        val zmag_psf_err = elms(677).toFloat
        val zflux_psf_apcorr = elms(678).toFloat
        val zflux_psf_apcorr_err = elms(679).toFloat
        val zflux_psf_flags = elms(680).toBoolean
        val zflux_psf_flags_apcorr = elms(681).toBoolean
        val zflux_kron = elms(682).toDouble
        val zmag_kron = elms(683).toFloat
        val zflux_kron_err = elms(684).toDouble
        val zmag_kron_err = elms(685).toFloat
        val zflux_kron_radius = elms(686).toFloat
        val zflux_kron_radiusforradius = elms(687).toFloat
        val zflux_kron_psfradius = elms(688).toFloat
        val zflux_kron_apcorr = elms(689).toFloat
        val zflux_kron_apcorr_err = elms(690).toFloat
        val zflux_kron_flags = elms(691).toBoolean
        val zflux_kron_flags_edge = elms(692).toBoolean
        val zflux_kron_flags_radius = elms(693).toBoolean
        val zflux_kron_flags_smallradius = elms(694).toBoolean
        val zflux_kron_flags_usedminimumradius = elms(695).toBoolean
        val zflux_kron_flags_usedpsfradius = elms(696).toString.toBoolean
        val zflux_kron_flags_badshape = elms(697).toBoolean
        val zflux_kron_flags_apcorr = elms(698).toBoolean
        val zflux_aperture10 = elms(699).toDouble
        val zmag_aperture10 = elms(700).toFloat
        val zflux_aperture15 = elms(701).toDouble
        val zmag_aperture15 = elms(702).toFloat
        val zflux_aperture20 = elms(703).toDouble
        val zmag_aperture20 = elms(704).toFloat
        val zflux_aperture30 = elms(705).toDouble
        val zmag_aperture30 = elms(706).toFloat
        val zflux_aperture40 = elms(707).toDouble
        val zmag_aperture40 = elms(708).toFloat
        val zflux_aperture57 = elms(709).toDouble
        val zmag_aperture57 = elms(710).toFloat
        val zflux_aperture84 = elms(711).toDouble
        val zmag_aperture84 = elms(712).toFloat
        val zflux_aperture118 = elms(713).toDouble
        val zmag_aperture118 = elms(714).toFloat
        val zflux_aperture168 = elms(715).toDouble
        val zmag_aperture168 = elms(716).toFloat
        val zflux_aperture235 = elms(717).toDouble
        val zmag_aperture235 = elms(718).toFloat
        val zflux_aperture10_err = elms(719).toDouble
        val zmag_aperture10_err = elms(720).toFloat
        val zflux_aperture15_err = elms(721).toDouble
        val zmag_aperture15_err = elms(722).toFloat
        val zflux_aperture20_err = elms(723).toDouble
        val zmag_aperture20_err = elms(724).toFloat
        val zflux_aperture30_err = elms(725).toDouble
        val zmag_aperture30_err = elms(726).toFloat
        val zflux_aperture40_err = elms(727).toDouble
        val zmag_aperture40_err = elms(728).toFloat
        val zflux_aperture57_err = elms(729).toDouble
        val zmag_aperture57_err = elms(730).toFloat
        val zflux_aperture84_err = elms(731).toDouble
        val zmag_aperture84_err = elms(732).toFloat
        val zflux_aperture118_err = elms(733).toDouble
        val zmag_aperture118_err = elms(734).toFloat
        val zflux_aperture168_err = elms(735).toDouble
        val zmag_aperture168_err = elms(736).toFloat
        val zflux_aperture235_err = elms(737).toDouble
        val zmag_aperture235_err = elms(738).toFloat
        val zflux_aperture10_ninterpolatedpixel = elms(739).toInt
        val zflux_aperture15_ninterpolatedpixel = elms(740).toInt
        val zflux_aperture20_ninterpolatedpixel = elms(741).toInt
        val zflux_aperture30_ninterpolatedpixel = elms(742).toInt
        val zflux_aperture40_ninterpolatedpixel = elms(743).toInt
        val zflux_aperture57_ninterpolatedpixel = elms(744).toInt
        val zflux_aperture84_ninterpolatedpixel = elms(745).toInt
        val zflux_aperture118_ninterpolatedpixel = elms(746).toInt
        val zflux_aperture168_ninterpolatedpixel = elms(747).toInt
        val zflux_aperture235_ninterpolatedpixel = elms(748).toInt
        val zflux_aperture_nprofile = elms(749).toInt
        val zflux_aperture_flags = elms(750).toBoolean
        val zcentroid_naive_ra = elms(751).toDouble
        val zcentroid_naive_dec = elms(752).toDouble
        val zcentroid_naive_flags = elms(753).toBoolean
        val zcentroid_sdss_ra = elms(754).toDouble
        val zcentroid_sdss_dec = elms(755).toDouble
        val zcentroid_sdss_err_11 = elms(756).toFloat
        val zcentroid_sdss_err_22 = elms(757).toFloat
        val zcentroid_sdss_flags = elms(758).toBoolean
        val zmultishapelet_psf_inner0 = elms(759).toFloat
        val zmultishapelet_psf_inner1 = elms(760).toFloat
        val zmultishapelet_psf_inner2 = elms(761).toFloat
        val zmultishapelet_psf_inner3 = elms(762).toFloat
        val zmultishapelet_psf_inner4 = elms(763).toFloat
        val zmultishapelet_psf_inner5 = elms(764).toFloat
        val zmultishapelet_psf_outer0 = elms(765).toFloat
        val zmultishapelet_psf_outer1 = elms(766).toFloat
        val zmultishapelet_psf_outer2 = elms(767).toFloat
        val zmultishapelet_psf_ellipse_11 = elms(768).toFloat
        val zmultishapelet_psf_ellipse_22 = elms(769).toFloat
        val zmultishapelet_psf_ellipse_12 = elms(770).toFloat
        val zmultishapelet_psf_chisq = elms(771).toFloat
        val zmultishapelet_psf_integral = elms(772).toFloat
        val zmultishapelet_psf_flags = elms(773).toBoolean
        val zmultishapelet_psf_flags_maxiter = elms(774).toBoolean
        val zmultishapelet_psf_flags_tinystep = elms(775).toBoolean
        val zmultishapelet_psf_flags_constraint_r = elms(776).toBoolean
        val zmultishapelet_psf_flags_constraint_q = elms(777).toBoolean
        val zshape_sdss_11 = elms(778).toFloat
        val zshape_sdss_22 = elms(779).toFloat
        val zshape_sdss_12 = elms(780).toFloat
        val zshape_sdss_err_11_11 = elms(781).toFloat
        val zshape_sdss_err_22_22 = elms(782).toFloat
        val zshape_sdss_err_12_12 = elms(783).toFloat
        val zshape_sdss_centroid_ra = elms(784).toDouble
        val zshape_sdss_centroid_dec = elms(785).toDouble
        val zshape_sdss_psf_11 = elms(786).toFloat
        val zshape_sdss_psf_22 = elms(787).toFloat
        val zshape_sdss_psf_12 = elms(788).toFloat
        val zshape_sdss_flags = elms(789).toBoolean
        val zshape_sdss_centroid_flags = elms(790).toBoolean
        val zshape_sdss_flags_unweightedbad = elms(791).toBoolean
        val zshape_sdss_flags_unweighted = elms(792).toBoolean
        val zshape_sdss_flags_shift = elms(793).toBoolean
        val zshape_sdss_flags_maxiter = elms(794).toBoolean
        val zshape_sdss_flags_psf = elms(795).toBoolean
        val zcmodel_initial_flux = elms(796).toDouble
        val zcmodel_initial_mag = elms(797).toFloat
        val zcmodel_initial_flux_err = elms(798).toDouble
        val zcmodel_initial_mag_err = elms(799).toFloat
        val zcmodel_initial_flux_inner = elms(800).toDouble
        val zcmodel_initial_mag_inner = elms(801).toFloat
        val zcmodel_exp_flux = elms(802).toDouble
        val zcmodel_exp_mag = elms(803).toFloat
        val zcmodel_exp_flux_err = elms(804).toDouble
        val zcmodel_exp_mag_err = elms(805).toFloat
        val zcmodel_exp_flux_inner = elms(806).toDouble
        val zcmodel_exp_mag_inner = elms(807).toFloat
        val zcmodel_dev_flux = elms(808).toDouble
        val zcmodel_dev_mag = elms(809).toFloat
        val zcmodel_dev_flux_err = elms(810).toDouble
        val zcmodel_dev_mag_err = elms(811).toFloat
        val zcmodel_dev_flux_inner = elms(812).toDouble
        val zcmodel_dev_mag_inner = elms(813).toFloat
        val zcmodel_center_ra = elms(814).toDouble
        val zcmodel_center_dec = elms(815).toDouble
        val zcmodel_flux = elms(816).toDouble
        val zcmodel_mag = elms(817).toFloat
        val zcmodel_flux_err = elms(818).toDouble
        val zcmodel_mag_err = elms(819).toFloat
        val zcmodel_flux_inner = elms(820).toDouble
        val zcmodel_mag_inner = elms(821).toFloat
        val zcmodel_fracdev = elms(822).toFloat
        val zcmodel_objective = elms(823).toFloat
        val zcmodel_dev_flux_apcorr = elms(824).toFloat
        val zcmodel_dev_flux_apcorr_err = elms(825).toFloat
        val zcmodel_exp_flux_apcorr = elms(826).toFloat
        val zcmodel_exp_flux_apcorr_err = elms(827).toFloat
        val zcmodel_flux_apcorr = elms(828).toFloat
        val zcmodel_flux_apcorr_err = elms(829).toFloat
        val zcmodel_initial_flux_flags = elms(830).toBoolean
        val zcmodel_initial_flags_badreference = elms(831).toBoolean
        val zcmodel_initial_flags_numericerror = elms(832).toBoolean
        val zcmodel_exp_flux_flags = elms(833).toBoolean
        val zcmodel_exp_flags_badreference = elms(834).toBoolean
        val zcmodel_exp_flags_numericerror = elms(835).toBoolean
        val zcmodel_dev_flux_flags = elms(836).toBoolean
        val zcmodel_dev_flags_badreference = elms(837).toBoolean
        val zcmodel_dev_flags_numericerror = elms(838).toBoolean
        val zcmodel_flux_flags = elms(839).toBoolean
        val zcmodel_flags_region_maxarea = elms(840).toBoolean
        val zcmodel_flags_region_maxbadpixelfraction = elms(841).toBoolean
        val zcmodel_flags_badreference = elms(842).toBoolean
        val zcmodel_flags_nopsf = elms(843).toBoolean
        val zcmodel_flags_nowcs = elms(844).toBoolean
        val zcmodel_flags_nocalib = elms(845).toBoolean
        val zcmodel_flags_badcentroid = elms(846).toBoolean
        val zcmodel_dev_flux_flags_apcorr = elms(847).toBoolean
        val zcmodel_exp_flux_flags_apcorr = elms(848).toBoolean
        val zcmodel_flux_flags_apcorr = elms(849).toBoolean
        val zcountinputs = elms(850).toInt
        val zvariance = elms(851).toFloat
        val zclassification_extendedness = elms(852).toFloat
        val zflags_pixel_edge = elms(853).toBoolean
        val zflags_pixel_interpolated_any = elms(854).toBoolean
        val zflags_pixel_interpolated_center = elms(855).toBoolean
        val zflags_pixel_saturated_any = elms(856).toBoolean
        val zflags_pixel_saturated_center = elms(857).toBoolean
        val zflags_pixel_cr_any = elms(858).toBoolean
        val zflags_pixel_cr_center = elms(859).toBoolean
        val zflags_pixel_bad = elms(860).toBoolean
        val zflags_pixel_suspect_any = elms(861).toBoolean
        val zflags_pixel_suspect_center = elms(862).toBoolean
        val zflags_pixel_offimage = elms(863).toBoolean
        val zflags_pixel_bright_object_center = elms(864).toBoolean
        val zflags_pixel_clipped_any = elms(865).toBoolean
        val zflags_pixel_bright_object_any = elms(866).toBoolean
        val yflux_naive = elms(867).toDouble
        val ymag_naive = elms(868).toFloat
        val yflux_naive_err = elms(869).toDouble
        val ymag_naive_err = elms(870).toFloat
        val yflux_naive_flags = elms(871).toBoolean
        val yflux_sinc = elms(872).toDouble
        val ymag_sinc = elms(873).toFloat
        val yflux_sinc_err = elms(874).toDouble
        val ymag_sinc_err = elms(875).toFloat
        val yflux_sinc_flags = elms(876).toBoolean
        val yflux_psf = elms(877).toDouble
        val ymag_psf = elms(878).toFloat
        val yflux_psf_err = elms(879).toDouble
        val ymag_psf_err = elms(880).toFloat
        val yflux_psf_apcorr = elms(881).toFloat
        val yflux_psf_apcorr_err = elms(882).toFloat
        val yflux_psf_flags = elms(883).toBoolean
        val yflux_psf_flags_apcorr = elms(884).toBoolean
        val yflux_kron = elms(885).toDouble
        val ymag_kron = elms(886).toFloat
        val yflux_kron_err = elms(887).toDouble
        val ymag_kron_err = elms(888).toFloat
        val yflux_kron_radius = elms(889).toFloat
        val yflux_kron_radiusforradius = elms(890).toFloat
        val yflux_kron_psfradius = elms(891).toFloat
        val yflux_kron_apcorr = elms(892).toFloat
        val yflux_kron_apcorr_err = elms(893).toFloat
        val yflux_kron_flags = elms(894).toBoolean
        val yflux_kron_flags_edge = elms(895).toBoolean
        val yflux_kron_flags_radius = elms(896).toBoolean
        val yflux_kron_flags_smallradius = elms(897).toBoolean
        val yflux_kron_flags_usedminimumradius = elms(898).toBoolean
        val yflux_kron_flags_usedpsfradius = elms(899).toBoolean
        val yflux_kron_flags_badshape = elms(900).toBoolean
        val yflux_kron_flags_apcorr = elms(901).toBoolean
        val yflux_aperture10 = elms(902).toDouble
        val ymag_aperture10 = elms(903).toFloat
        val yflux_aperture15 = elms(904).toDouble
        val ymag_aperture15 = elms(905).toFloat
        val yflux_aperture20 = elms(906).toDouble
        val ymag_aperture20 = elms(907).toFloat
        val yflux_aperture30 = elms(908).toDouble
        val ymag_aperture30 = elms(909).toFloat
        val yflux_aperture40 = elms(910).toDouble
        val ymag_aperture40 = elms(911).toFloat
        val yflux_aperture57 = elms(912).toDouble
        val ymag_aperture57 = elms(913).toFloat
        val yflux_aperture84 = elms(914).toDouble
        val ymag_aperture84 = elms(915).toFloat
        val yflux_aperture118 = elms(916).toDouble
        val ymag_aperture118 = elms(917).toFloat
        val yflux_aperture168 = elms(918).toDouble
        val ymag_aperture168 = elms(919).toFloat
        val yflux_aperture235 = elms(920).toDouble
        val ymag_aperture235 = elms(921).toFloat
        val yflux_aperture10_err = elms(922).toDouble
        val ymag_aperture10_err = elms(923).toFloat
        val yflux_aperture15_err = elms(924).toDouble
        val ymag_aperture15_err = elms(925).toFloat
        val yflux_aperture20_err = elms(926).toDouble
        val ymag_aperture20_err = elms(927).toFloat
        val yflux_aperture30_err = elms(928).toDouble
        val ymag_aperture30_err = elms(929).toFloat
        val yflux_aperture40_err = elms(930).toDouble
        val ymag_aperture40_err = elms(931).toFloat
        val yflux_aperture57_err = elms(932).toDouble
        val ymag_aperture57_err = elms(933).toFloat
        val yflux_aperture84_err = elms(934).toDouble
        val ymag_aperture84_err = elms(935).toFloat
        val yflux_aperture118_err = elms(936).toDouble
        val ymag_aperture118_err = elms(937).toFloat
        val yflux_aperture168_err = elms(938).toDouble
        val ymag_aperture168_err = elms(939).toFloat
        val yflux_aperture235_err = elms(940).toDouble
        val ymag_aperture235_err = elms(941).toFloat
        val yflux_aperture10_ninterpolatedpixel = elms(942).toInt
        val yflux_aperture15_ninterpolatedpixel = elms(943).toInt
        val yflux_aperture20_ninterpolatedpixel = elms(944).toInt
        val yflux_aperture30_ninterpolatedpixel = elms(945).toInt
        val yflux_aperture40_ninterpolatedpixel = elms(946).toInt
        val yflux_aperture57_ninterpolatedpixel = elms(947).toInt
        val yflux_aperture84_ninterpolatedpixel = elms(948).toInt
        val yflux_aperture118_ninterpolatedpixel = elms(949).toInt
        val yflux_aperture168_ninterpolatedpixel = elms(950).toInt
        val yflux_aperture235_ninterpolatedpixel = elms(951).toInt
        val yflux_aperture_nprofile = elms(952).toInt
        val yflux_aperture_flags = elms(953).toBoolean
        val ycentroid_naive_ra = elms(954).toDouble
        val ycentroid_naive_dec = elms(955).toDouble
        val ycentroid_naive_flags = elms(956).toBoolean
        val ycentroid_sdss_ra = elms(957).toDouble
        val ycentroid_sdss_dec = elms(958).toDouble
        val ycentroid_sdss_err_11 = elms(959).toFloat
        val ycentroid_sdss_err_22 = elms(960).toFloat
        val ycentroid_sdss_flags = elms(961).toBoolean
        val ymultishapelet_psf_inner0 = elms(962).toFloat
        val ymultishapelet_psf_inner1 = elms(963).toFloat
        val ymultishapelet_psf_inner2 = elms(964).toFloat
        val ymultishapelet_psf_inner3 = elms(965).toFloat
        val ymultishapelet_psf_inner4 = elms(966).toFloat
        val ymultishapelet_psf_inner5 = elms(967).toFloat
        val ymultishapelet_psf_outer0 = elms(968).toFloat
        val ymultishapelet_psf_outer1 = elms(969).toFloat
        val ymultishapelet_psf_outer2 = elms(970).toFloat
        val ymultishapelet_psf_ellipse_11 = elms(971).toFloat
        val ymultishapelet_psf_ellipse_22 = elms(972).toFloat
        val ymultishapelet_psf_ellipse_12 = elms(973).toFloat
        val ymultishapelet_psf_chisq = elms(974).toFloat
        val ymultishapelet_psf_integral = elms(975).toFloat
        val ymultishapelet_psf_flags = elms(976).toBoolean
        val ymultishapelet_psf_flags_maxiter = elms(977).toBoolean
        val ymultishapelet_psf_flags_tinystep = elms(978).toBoolean
        val ymultishapelet_psf_flags_constraint_r = elms(979).toBoolean
        val ymultishapelet_psf_flags_constraint_q = elms(980).toBoolean
        val yshape_sdss_11 = elms(981).toFloat
        val yshape_sdss_22 = elms(982).toFloat
        val yshape_sdss_12 = elms(983).toFloat
        val yshape_sdss_err_11_11 = elms(984).toFloat
        val yshape_sdss_err_22_22 = elms(985).toFloat
        val yshape_sdss_err_12_12 = elms(986).toFloat
        val yshape_sdss_centroid_ra = elms(987).toDouble
        val yshape_sdss_centroid_dec = elms(988).toDouble
        val yshape_sdss_psf_11 = elms(989).toFloat
        val yshape_sdss_psf_22 = elms(990).toFloat
        val yshape_sdss_psf_12 = elms(991).toFloat
        val yshape_sdss_flags = elms(992).toBoolean
        val yshape_sdss_centroid_flags = elms(993).toBoolean
        val yshape_sdss_flags_unweightedbad = elms(994).toBoolean
        val yshape_sdss_flags_unweighted = elms(995).toBoolean
        val yshape_sdss_flags_shift = elms(996).toBoolean
        val yshape_sdss_flags_maxiter = elms(997).toBoolean
        val yshape_sdss_flags_psf = elms(998).toBoolean
        val ycmodel_initial_flux = elms(999).toDouble
        val ycmodel_initial_mag = elms(1000).toFloat
        val ycmodel_initial_flux_err = elms(1001).toDouble
        val ycmodel_initial_mag_err = elms(1002).toFloat
        val ycmodel_initial_flux_inner = elms(1003).toDouble
        val ycmodel_initial_mag_inner = elms(1004).toFloat
        val ycmodel_exp_flux = elms(1005).toDouble
        val ycmodel_exp_mag = elms(1006).toFloat
        val ycmodel_exp_flux_err = elms(1007).toDouble
        val ycmodel_exp_mag_err = elms(1008).toFloat
        val ycmodel_exp_flux_inner = elms(1009).toDouble
        val ycmodel_exp_mag_inner = elms(1010).toFloat
        val ycmodel_dev_flux = elms(1011).toDouble
        val ycmodel_dev_mag = elms(1012).toFloat
        val ycmodel_dev_flux_err = elms(1013).toDouble
        val ycmodel_dev_mag_err = elms(1014).toFloat
        val ycmodel_dev_flux_inner = elms(1015).toDouble
        val ycmodel_dev_mag_inner = elms(1016).toFloat
        val ycmodel_center_ra = elms(1017).toDouble
        val ycmodel_center_dec = elms(1018).toDouble
        val ycmodel_flux = elms(1019).toDouble
        val ycmodel_mag = elms(1020).toFloat
        val ycmodel_flux_err = elms(1021).toDouble
        val ycmodel_mag_err = elms(1022).toFloat
        val ycmodel_flux_inner = elms(1023).toDouble
        val ycmodel_mag_inner = elms(1024).toFloat
        val ycmodel_fracdev = elms(1025).toFloat
        val ycmodel_objective = elms(1026).toFloat
        val ycmodel_dev_flux_apcorr = elms(1027).toFloat
        val ycmodel_dev_flux_apcorr_err = elms(1028).toFloat
        val ycmodel_exp_flux_apcorr = elms(1029).toFloat
        val ycmodel_exp_flux_apcorr_err = elms(1030).toFloat
        val ycmodel_flux_apcorr = elms(1031).toFloat
        val ycmodel_flux_apcorr_err = elms(1032).toFloat
        val ycmodel_initial_flux_flags = elms(1033).toBoolean
        val ycmodel_initial_flags_badreference = elms(1034).toBoolean
        val ycmodel_initial_flags_numericerror = elms(1035).toBoolean
        val ycmodel_exp_flux_flags = elms(1036).toBoolean
        val ycmodel_exp_flags_badreference = elms(1037).toBoolean
        val ycmodel_exp_flags_numericerror = elms(1038).toBoolean
        val ycmodel_dev_flux_flags = elms(1039).toBoolean
        val ycmodel_dev_flags_badreference = elms(1040).toBoolean
        val ycmodel_dev_flags_numericerror = elms(1041).toBoolean
        val ycmodel_flux_flags = elms(1042).toBoolean
        val ycmodel_flags_region_maxarea = elms(1043).toBoolean
        val ycmodel_flags_region_maxbadpixelfraction = elms(1044).toBoolean
        val ycmodel_flags_badreference = elms(1045).toBoolean
        val ycmodel_flags_nopsf = elms(1046).toBoolean
        val ycmodel_flags_nowcs = elms(1047).toBoolean
        val ycmodel_flags_nocalib = elms(1048).toBoolean
        val ycmodel_flags_badcentroid = elms(1049).toBoolean
        val ycmodel_dev_flux_flags_apcorr = elms(1050).toBoolean
        val ycmodel_exp_flux_flags_apcorr = elms(1051).toBoolean
        val ycmodel_flux_flags_apcorr = elms(1052).toBoolean
        val ycountinputs = elms(1053).toInt
        val yvariance = elms(1054).toFloat
        val yclassification_extendedness = elms(1055).toFloat
        val yflags_pixel_edge = elms(1056).toBoolean
        val yflags_pixel_interpolated_any = elms(1057).toBoolean
        val yflags_pixel_interpolated_center = elms(1058).toBoolean
        val yflags_pixel_saturated_any = elms(1059).toBoolean
        val yflags_pixel_saturated_center = elms(1060).toBoolean
        val yflags_pixel_cr_any = elms(1061).toBoolean
        val yflags_pixel_cr_center = elms(1062).toBoolean
        val yflags_pixel_bad = elms(1063).toBoolean
        val yflags_pixel_suspect_any = elms(1064).toBoolean
        val yflags_pixel_suspect_center = elms(1065).toBoolean
        val yflags_pixel_offimage = elms(1066).toBoolean
        val yflags_pixel_bright_object_center = elms(1067).toBoolean
        val yflags_pixel_clipped_any = elms(1068).toBoolean
        val yflags_pixel_bright_object_any = elms(1069).toBoolean

        (
          object_id, ra, dec, coord, skymap_id, tract
          , patch, patch_s, parent_id, deblend_nchild
          , a_g, a_r, a_i, a_z, a_y
          , detect_is_primary
          , merge_footprint_i2, merge_footprint_i, merge_footprint_r, merge_footprint_z, merge_footprint_y, merge_footprint_g, merge_footprint_n921, merge_footprint_n816, merge_footprint_n1010, merge_footprint_n387, merge_footprint_n515, merge_footprint_sky
          , merge_peak_i2, merge_peak_i, merge_peak_r, merge_peak_z, merge_peak_y, merge_peak_g, merge_peak_n921, merge_peak_n816, merge_peak_n1010, merge_peak_n387, merge_peak_n515, merge_peak_sky
          , detect_is_patch_inner, detect_is_tract_inner
          , merge_measurement_i2, merge_measurement_i, merge_measurement_r, merge_measurement_z, merge_measurement_y, merge_measurement_g, merge_measurement_n921, merge_measurement_n816, merge_measurement_n1010, merge_measurement_n387, merge_measurement_n515
          , gflux_naive, gmag_naive, gflux_naive_err, gmag_naive_err, gflux_naive_flags, gflux_sinc, gmag_sinc, gflux_sinc_err, gmag_sinc_err, gflux_sinc_flags, gflux_psf, gmag_psf, gflux_psf_err, gmag_psf_err, gflux_psf_apcorr, gflux_psf_apcorr_err, gflux_psf_flags, gflux_psf_flags_apcorr, gflux_kron, gmag_kron, gflux_kron_err, gmag_kron_err
          , gflux_kron_radius, gflux_kron_radiusforradius, gflux_kron_psfradius, gflux_kron_apcorr, gflux_kron_apcorr_err, gflux_kron_flags, gflux_kron_flags_edge, gflux_kron_flags_radius, gflux_kron_flags_smallradius, gflux_kron_flags_usedminimumradius, gflux_kron_flags_usedpsfradius, gflux_kron_flags_badshape, gflux_kron_flags_apcorr, gflux_aperture10
          , gmag_aperture10, gflux_aperture15, gmag_aperture15, gflux_aperture20, gmag_aperture20, gflux_aperture30, gmag_aperture30, gflux_aperture40, gmag_aperture40, gflux_aperture57, gmag_aperture57, gflux_aperture84, gmag_aperture84, gflux_aperture118, gmag_aperture118, gflux_aperture168, gmag_aperture168, gflux_aperture235, gmag_aperture235, gflux_aperture10_err, gmag_aperture10_err, gflux_aperture15_err, gmag_aperture15_err, gflux_aperture20_err, gmag_aperture20_err, gflux_aperture30_err, gmag_aperture30_err, gflux_aperture40_err, gmag_aperture40_err, gflux_aperture57_err, gmag_aperture57_err, gflux_aperture84_err, gmag_aperture84_err, gflux_aperture118_err, gmag_aperture118_err, gflux_aperture168_err, gmag_aperture168_err, gflux_aperture235_err, gmag_aperture235_err
          , gflux_aperture10_ninterpolatedpixel, gflux_aperture15_ninterpolatedpixel, gflux_aperture20_ninterpolatedpixel, gflux_aperture30_ninterpolatedpixel, gflux_aperture40_ninterpolatedpixel, gflux_aperture57_ninterpolatedpixel, gflux_aperture84_ninterpolatedpixel, gflux_aperture118_ninterpolatedpixel, gflux_aperture168_ninterpolatedpixel, gflux_aperture235_ninterpolatedpixel, gflux_aperture_nprofile, gflux_aperture_flags
          , gcentroid_naive_ra, gcentroid_naive_dec, gcentroid_naive_flags, gcentroid_sdss_ra, gcentroid_sdss_dec, gcentroid_sdss_err_11, gcentroid_sdss_err_22, gcentroid_sdss_flags
          , gmultishapelet_psf_inner0, gmultishapelet_psf_inner1, gmultishapelet_psf_inner2, gmultishapelet_psf_inner3, gmultishapelet_psf_inner4, gmultishapelet_psf_inner5, gmultishapelet_psf_outer0, gmultishapelet_psf_outer1, gmultishapelet_psf_outer2, gmultishapelet_psf_ellipse_11, gmultishapelet_psf_ellipse_22, gmultishapelet_psf_ellipse_12, gmultishapelet_psf_chisq, gmultishapelet_psf_integral, gmultishapelet_psf_flags, gmultishapelet_psf_flags_maxiter, gmultishapelet_psf_flags_tinystep, gmultishapelet_psf_flags_constraint_r, gmultishapelet_psf_flags_constraint_q
          , gshape_sdss_11, gshape_sdss_22, gshape_sdss_12, gshape_sdss_err_11_11, gshape_sdss_err_22_22, gshape_sdss_err_12_12, gshape_sdss_centroid_ra, gshape_sdss_centroid_dec, gshape_sdss_psf_11, gshape_sdss_psf_22, gshape_sdss_psf_12, gshape_sdss_flags, gshape_sdss_centroid_flags, gshape_sdss_flags_unweightedbad, gshape_sdss_flags_unweighted, gshape_sdss_flags_shift, gshape_sdss_flags_maxiter, gshape_sdss_flags_psf
          , gcmodel_initial_flux, gcmodel_initial_mag, gcmodel_initial_flux_err, gcmodel_initial_mag_err, gcmodel_initial_flux_inner, gcmodel_initial_mag_inner, gcmodel_exp_flux, gcmodel_exp_mag, gcmodel_exp_flux_err, gcmodel_exp_mag_err, gcmodel_exp_flux_inner, gcmodel_exp_mag_inner, gcmodel_dev_flux, gcmodel_dev_mag, gcmodel_dev_flux_err, gcmodel_dev_mag_err, gcmodel_dev_flux_inner, gcmodel_dev_mag_inner, gcmodel_center_ra, gcmodel_center_dec, gcmodel_flux, gcmodel_mag, gcmodel_flux_err, gcmodel_mag_err, gcmodel_flux_inner, gcmodel_mag_inner, gcmodel_fracdev, gcmodel_objective, gcmodel_dev_flux_apcorr, gcmodel_dev_flux_apcorr_err, gcmodel_exp_flux_apcorr, gcmodel_exp_flux_apcorr_err, gcmodel_flux_apcorr, gcmodel_flux_apcorr_err, gcmodel_initial_flux_flags, gcmodel_initial_flags_badreference, gcmodel_initial_flags_numericerror, gcmodel_exp_flux_flags, gcmodel_exp_flags_badreference, gcmodel_exp_flags_numericerror, gcmodel_dev_flux_flags, gcmodel_dev_flags_badreference, gcmodel_dev_flags_numericerror, gcmodel_flux_flags, gcmodel_flags_region_maxarea, gcmodel_flags_region_maxbadpixelfraction, gcmodel_flags_badreference, gcmodel_flags_nopsf, gcmodel_flags_nowcs, gcmodel_flags_nocalib, gcmodel_flags_badcentroid, gcmodel_dev_flux_flags_apcorr, gcmodel_exp_flux_flags_apcorr, gcmodel_flux_flags_apcorr, gcountinputs, gvariance, gclassification_extendedness
          , gflags_pixel_edge, gflags_pixel_interpolated_any, gflags_pixel_interpolated_center, gflags_pixel_saturated_any, gflags_pixel_saturated_center, gflags_pixel_cr_any, gflags_pixel_cr_center, gflags_pixel_bad, gflags_pixel_suspect_any, gflags_pixel_suspect_center, gflags_pixel_offimage, gflags_pixel_bright_object_center, gflags_pixel_clipped_any, gflags_pixel_bright_object_any
          , rflux_naive, rmag_naive, rflux_naive_err, rmag_naive_err, rflux_naive_flags, rflux_sinc, rmag_sinc, rflux_sinc_err, rmag_sinc_err, rflux_sinc_flags, rflux_psf, rmag_psf, rflux_psf_err, rmag_psf_err, rflux_psf_apcorr, rflux_psf_apcorr_err, rflux_psf_flags, rflux_psf_flags_apcorr, rflux_kron, rmag_kron, rflux_kron_err, rmag_kron_err, rflux_kron_radius, rflux_kron_radiusforradius, rflux_kron_psfradius, rflux_kron_apcorr, rflux_kron_apcorr_err, rflux_kron_flags, rflux_kron_flags_edge, rflux_kron_flags_radius, rflux_kron_flags_smallradius, rflux_kron_flags_usedminimumradius, rflux_kron_flags_usedpsfradius, rflux_kron_flags_badshape, rflux_kron_flags_apcorr, rflux_aperture10, rmag_aperture10, rflux_aperture15, rmag_aperture15, rflux_aperture20, rmag_aperture20, rflux_aperture30, rmag_aperture30, rflux_aperture40, rmag_aperture40, rflux_aperture57, rmag_aperture57, rflux_aperture84, rmag_aperture84, rflux_aperture118, rmag_aperture118, rflux_aperture168, rmag_aperture168, rflux_aperture235, rmag_aperture235
          , rflux_aperture10_err, rmag_aperture10_err, rflux_aperture15_err, rmag_aperture15_err, rflux_aperture20_err, rmag_aperture20_err, rflux_aperture30_err, rmag_aperture30_err, rflux_aperture40_err, rmag_aperture40_err, rflux_aperture57_err, rmag_aperture57_err, rflux_aperture84_err, rmag_aperture84_err, rflux_aperture118_err, rmag_aperture118_err, rflux_aperture168_err, rmag_aperture168_err, rflux_aperture235_err, rmag_aperture235_err
          , rflux_aperture10_ninterpolatedpixel, rflux_aperture15_ninterpolatedpixel, rflux_aperture20_ninterpolatedpixel, rflux_aperture30_ninterpolatedpixel, rflux_aperture40_ninterpolatedpixel, rflux_aperture57_ninterpolatedpixel, rflux_aperture84_ninterpolatedpixel, rflux_aperture118_ninterpolatedpixel, rflux_aperture168_ninterpolatedpixel, rflux_aperture235_ninterpolatedpixel, rflux_aperture_nprofile, rflux_aperture_flags
          , rcentroid_naive_ra, rcentroid_naive_dec, rcentroid_naive_flags, rcentroid_sdss_ra, rcentroid_sdss_dec, rcentroid_sdss_err_11, rcentroid_sdss_err_22, rcentroid_sdss_flags
          , rmultishapelet_psf_inner0, rmultishapelet_psf_inner1, rmultishapelet_psf_inner2, rmultishapelet_psf_inner3, rmultishapelet_psf_inner4, rmultishapelet_psf_inner5, rmultishapelet_psf_outer0, rmultishapelet_psf_outer1, rmultishapelet_psf_outer2, rmultishapelet_psf_ellipse_11, rmultishapelet_psf_ellipse_22, rmultishapelet_psf_ellipse_12, rmultishapelet_psf_chisq, rmultishapelet_psf_integral, rmultishapelet_psf_flags, rmultishapelet_psf_flags_maxiter, rmultishapelet_psf_flags_tinystep, rmultishapelet_psf_flags_constraint_r, rmultishapelet_psf_flags_constraint_q
          , rshape_sdss_11, rshape_sdss_22, rshape_sdss_12, rshape_sdss_err_11_11, rshape_sdss_err_22_22, rshape_sdss_err_12_12, rshape_sdss_centroid_ra, rshape_sdss_centroid_dec, rshape_sdss_psf_11, rshape_sdss_psf_22, rshape_sdss_psf_12, rshape_sdss_flags, rshape_sdss_centroid_flags, rshape_sdss_flags_unweightedbad, rshape_sdss_flags_unweighted, rshape_sdss_flags_shift, rshape_sdss_flags_maxiter, rshape_sdss_flags_psf
          , rcmodel_initial_flux, rcmodel_initial_mag, rcmodel_initial_flux_err, rcmodel_initial_mag_err, rcmodel_initial_flux_inner, rcmodel_initial_mag_inner, rcmodel_exp_flux, rcmodel_exp_mag, rcmodel_exp_flux_err, rcmodel_exp_mag_err, rcmodel_exp_flux_inner, rcmodel_exp_mag_inner, rcmodel_dev_flux, rcmodel_dev_mag, rcmodel_dev_flux_err, rcmodel_dev_mag_err, rcmodel_dev_flux_inner, rcmodel_dev_mag_inner, rcmodel_center_ra, rcmodel_center_dec, rcmodel_flux, rcmodel_mag, rcmodel_flux_err, rcmodel_mag_err, rcmodel_flux_inner, rcmodel_mag_inner, rcmodel_fracdev, rcmodel_objective, rcmodel_dev_flux_apcorr, rcmodel_dev_flux_apcorr_err, rcmodel_exp_flux_apcorr, rcmodel_exp_flux_apcorr_err, rcmodel_flux_apcorr, rcmodel_flux_apcorr_err, rcmodel_initial_flux_flags, rcmodel_initial_flags_badreference, rcmodel_initial_flags_numericerror
          , rcmodel_exp_flux_flags, rcmodel_exp_flags_badreference, rcmodel_exp_flags_numericerror, rcmodel_dev_flux_flags, rcmodel_dev_flags_badreference, rcmodel_dev_flags_numericerror, rcmodel_flux_flags
          , rcmodel_flags_region_maxarea, rcmodel_flags_region_maxbadpixelfraction, rcmodel_flags_badreference, rcmodel_flags_nopsf, rcmodel_flags_nowcs, rcmodel_flags_nocalib, rcmodel_flags_badcentroid, rcmodel_dev_flux_flags_apcorr, rcmodel_exp_flux_flags_apcorr, rcmodel_flux_flags_apcorr, rcountinputs, rvariance, rclassification_extendedness
          , rflags_pixel_edge, rflags_pixel_interpolated_any, rflags_pixel_interpolated_center, rflags_pixel_saturated_any, rflags_pixel_saturated_center, rflags_pixel_cr_any, rflags_pixel_cr_center, rflags_pixel_bad, rflags_pixel_suspect_any, rflags_pixel_suspect_center, rflags_pixel_offimage, rflags_pixel_bright_object_center, rflags_pixel_clipped_any, rflags_pixel_bright_object_any, iflux_naive
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
          , iflux_kron_radius, iflux_kron_radiusforradius, iflux_kron_psfradius, iflux_kron_apcorr, iflux_kron_apcorr_err, iflux_kron_flags, iflux_kron_flags_edge, iflux_kron_flags_radius, iflux_kron_flags_smallradius, iflux_kron_flags_usedminimumradius, iflux_kron_flags_usedpsfradius, iflux_kron_flags_badshape, iflux_kron_flags_apcorr
          , iflux_aperture10
          , imag_aperture10
          , iflux_aperture15
          , imag_aperture15
          , iflux_aperture20
          , imag_aperture20
          , iflux_aperture30
          , imag_aperture30
          , iflux_aperture40
          , imag_aperture40
          , iflux_aperture57
          , imag_aperture57
          , iflux_aperture84
          , imag_aperture84
          , iflux_aperture118
          , imag_aperture118
          , iflux_aperture168
          , imag_aperture168
          , iflux_aperture235
          , imag_aperture235
          , iflux_aperture10_err
          , imag_aperture10_err
          , iflux_aperture15_err
          , imag_aperture15_err
          , iflux_aperture20_err
          , imag_aperture20_err
          , iflux_aperture30_err
          , imag_aperture30_err
          , iflux_aperture40_err
          , imag_aperture40_err
          , iflux_aperture57_err
          , imag_aperture57_err
          , iflux_aperture84_err
          , imag_aperture84_err
          , iflux_aperture118_err
          , imag_aperture118_err
          , iflux_aperture168_err
          , imag_aperture168_err
          , iflux_aperture235_err
          , imag_aperture235_err
          , iflux_aperture10_ninterpolatedpixel, iflux_aperture15_ninterpolatedpixel, iflux_aperture20_ninterpolatedpixel, iflux_aperture30_ninterpolatedpixel, iflux_aperture40_ninterpolatedpixel, iflux_aperture57_ninterpolatedpixel, iflux_aperture84_ninterpolatedpixel, iflux_aperture118_ninterpolatedpixel, iflux_aperture168_ninterpolatedpixel, iflux_aperture235_ninterpolatedpixel, iflux_aperture_nprofile, iflux_aperture_flags
          , icentroid_naive_ra, icentroid_naive_dec, icentroid_naive_flags, icentroid_sdss_ra, icentroid_sdss_dec, icentroid_sdss_err_11, icentroid_sdss_err_22, icentroid_sdss_flags
          , imultishapelet_psf_inner0, imultishapelet_psf_inner1, imultishapelet_psf_inner2, imultishapelet_psf_inner3, imultishapelet_psf_inner4, imultishapelet_psf_inner5, imultishapelet_psf_outer0, imultishapelet_psf_outer1, imultishapelet_psf_outer2, imultishapelet_psf_ellipse_11, imultishapelet_psf_ellipse_22, imultishapelet_psf_ellipse_12, imultishapelet_psf_chisq, imultishapelet_psf_integral, imultishapelet_psf_flags, imultishapelet_psf_flags_maxiter, imultishapelet_psf_flags_tinystep, imultishapelet_psf_flags_constraint_r, imultishapelet_psf_flags_constraint_q
          , ishape_sdss_11, ishape_sdss_22, ishape_sdss_12, ishape_sdss_err_11_11, ishape_sdss_err_22_22, ishape_sdss_err_12_12, ishape_sdss_centroid_ra, ishape_sdss_centroid_dec, ishape_sdss_psf_11, ishape_sdss_psf_22, ishape_sdss_psf_12, ishape_sdss_flags, ishape_sdss_centroid_flags, ishape_sdss_flags_unweightedbad, ishape_sdss_flags_unweighted, ishape_sdss_flags_shift, ishape_sdss_flags_maxiter, ishape_sdss_flags_psf
          , icmodel_initial_flux, icmodel_initial_mag, icmodel_initial_flux_err, icmodel_initial_mag_err, icmodel_initial_flux_inner, icmodel_initial_mag_inner, icmodel_exp_flux, icmodel_exp_mag, icmodel_exp_flux_err, icmodel_exp_mag_err, icmodel_exp_flux_inner, icmodel_exp_mag_inner, icmodel_dev_flux, icmodel_dev_mag, icmodel_dev_flux_err, icmodel_dev_mag_err, icmodel_dev_flux_inner, icmodel_dev_mag_inner, icmodel_center_ra, icmodel_center_dec, icmodel_flux, icmodel_mag, icmodel_flux_err, icmodel_mag_err, icmodel_flux_inner, icmodel_mag_inner, icmodel_fracdev, icmodel_objective, icmodel_dev_flux_apcorr, icmodel_dev_flux_apcorr_err, icmodel_exp_flux_apcorr, icmodel_exp_flux_apcorr_err, icmodel_flux_apcorr, icmodel_flux_apcorr_err, icmodel_initial_flux_flags, icmodel_initial_flags_badreference, icmodel_initial_flags_numericerror, icmodel_exp_flux_flags, icmodel_exp_flags_badreference, icmodel_exp_flags_numericerror, icmodel_dev_flux_flags, icmodel_dev_flags_badreference, icmodel_dev_flags_numericerror, icmodel_flux_flags, icmodel_flags_region_maxarea, icmodel_flags_region_maxbadpixelfraction, icmodel_flags_badreference, icmodel_flags_nopsf, icmodel_flags_nowcs, icmodel_flags_nocalib, icmodel_flags_badcentroid, icmodel_dev_flux_flags_apcorr, icmodel_exp_flux_flags_apcorr, icmodel_flux_flags_apcorr, icountinputs
          , ivariance
          , iclassification_extendedness
          , iflags_pixel_edge, iflags_pixel_interpolated_any, iflags_pixel_interpolated_center, iflags_pixel_saturated_any, iflags_pixel_saturated_center, iflags_pixel_cr_any, iflags_pixel_cr_center, iflags_pixel_bad, iflags_pixel_suspect_any, iflags_pixel_suspect_center, iflags_pixel_offimage, iflags_pixel_bright_object_center, iflags_pixel_clipped_any, iflags_pixel_bright_object_any
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
          , zflux_kron_radius, zflux_kron_radiusforradius, zflux_kron_psfradius, zflux_kron_apcorr, zflux_kron_apcorr_err, zflux_kron_flags, zflux_kron_flags_edge, zflux_kron_flags_radius, zflux_kron_flags_smallradius, zflux_kron_flags_usedminimumradius, zflux_kron_flags_usedpsfradius, zflux_kron_flags_badshape, zflux_kron_flags_apcorr, zflux_aperture10
          , zmag_aperture10
          , zflux_aperture15
          , zmag_aperture15
          , zflux_aperture20
          , zmag_aperture20
          , zflux_aperture30
          , zmag_aperture30
          , zflux_aperture40
          , zmag_aperture40
          , zflux_aperture57
          , zmag_aperture57
          , zflux_aperture84
          , zmag_aperture84
          , zflux_aperture118
          , zmag_aperture118
          , zflux_aperture168
          , zmag_aperture168
          , zflux_aperture235
          , zmag_aperture235
          , zflux_aperture10_err
          , zmag_aperture10_err
          , zflux_aperture15_err
          , zmag_aperture15_err
          , zflux_aperture20_err
          , zmag_aperture20_err
          , zflux_aperture30_err
          , zmag_aperture30_err
          , zflux_aperture40_err
          , zmag_aperture40_err
          , zflux_aperture57_err
          , zmag_aperture57_err
          , zflux_aperture84_err
          , zmag_aperture84_err
          , zflux_aperture118_err
          , zmag_aperture118_err
          , zflux_aperture168_err
          , zmag_aperture168_err
          , zflux_aperture235_err
          , zmag_aperture235_err
          , zflux_aperture10_ninterpolatedpixel, zflux_aperture15_ninterpolatedpixel, zflux_aperture20_ninterpolatedpixel, zflux_aperture30_ninterpolatedpixel, zflux_aperture40_ninterpolatedpixel, zflux_aperture57_ninterpolatedpixel, zflux_aperture84_ninterpolatedpixel, zflux_aperture118_ninterpolatedpixel, zflux_aperture168_ninterpolatedpixel, zflux_aperture235_ninterpolatedpixel, zflux_aperture_nprofile, zflux_aperture_flags
          , zcentroid_naive_ra, zcentroid_naive_dec, zcentroid_naive_flags, zcentroid_sdss_ra, zcentroid_sdss_dec, zcentroid_sdss_err_11, zcentroid_sdss_err_22, zcentroid_sdss_flags
          , zmultishapelet_psf_inner0, zmultishapelet_psf_inner1, zmultishapelet_psf_inner2, zmultishapelet_psf_inner3, zmultishapelet_psf_inner4, zmultishapelet_psf_inner5, zmultishapelet_psf_outer0, zmultishapelet_psf_outer1, zmultishapelet_psf_outer2, zmultishapelet_psf_ellipse_11, zmultishapelet_psf_ellipse_22, zmultishapelet_psf_ellipse_12, zmultishapelet_psf_chisq, zmultishapelet_psf_integral, zmultishapelet_psf_flags, zmultishapelet_psf_flags_maxiter, zmultishapelet_psf_flags_tinystep, zmultishapelet_psf_flags_constraint_r, zmultishapelet_psf_flags_constraint_q
          , zshape_sdss_11, zshape_sdss_22, zshape_sdss_12, zshape_sdss_err_11_11, zshape_sdss_err_22_22, zshape_sdss_err_12_12, zshape_sdss_centroid_ra, zshape_sdss_centroid_dec, zshape_sdss_psf_11, zshape_sdss_psf_22, zshape_sdss_psf_12, zshape_sdss_flags, zshape_sdss_centroid_flags, zshape_sdss_flags_unweightedbad, zshape_sdss_flags_unweighted, zshape_sdss_flags_shift, zshape_sdss_flags_maxiter, zshape_sdss_flags_psf
          , zcmodel_initial_flux, zcmodel_initial_mag, zcmodel_initial_flux_err, zcmodel_initial_mag_err, zcmodel_initial_flux_inner, zcmodel_initial_mag_inner, zcmodel_exp_flux, zcmodel_exp_mag, zcmodel_exp_flux_err, zcmodel_exp_mag_err, zcmodel_exp_flux_inner, zcmodel_exp_mag_inner, zcmodel_dev_flux, zcmodel_dev_mag, zcmodel_dev_flux_err, zcmodel_dev_mag_err, zcmodel_dev_flux_inner, zcmodel_dev_mag_inner, zcmodel_center_ra, zcmodel_center_dec, zcmodel_flux, zcmodel_mag, zcmodel_flux_err, zcmodel_mag_err, zcmodel_flux_inner, zcmodel_mag_inner, zcmodel_fracdev, zcmodel_objective, zcmodel_dev_flux_apcorr, zcmodel_dev_flux_apcorr_err, zcmodel_exp_flux_apcorr, zcmodel_exp_flux_apcorr_err, zcmodel_flux_apcorr, zcmodel_flux_apcorr_err, zcmodel_initial_flux_flags, zcmodel_initial_flags_badreference, zcmodel_initial_flags_numericerror, zcmodel_exp_flux_flags, zcmodel_exp_flags_badreference, zcmodel_exp_flags_numericerror, zcmodel_dev_flux_flags, zcmodel_dev_flags_badreference, zcmodel_dev_flags_numericerror, zcmodel_flux_flags, zcmodel_flags_region_maxarea, zcmodel_flags_region_maxbadpixelfraction, zcmodel_flags_badreference, zcmodel_flags_nopsf, zcmodel_flags_nowcs, zcmodel_flags_nocalib, zcmodel_flags_badcentroid, zcmodel_dev_flux_flags_apcorr, zcmodel_exp_flux_flags_apcorr, zcmodel_flux_flags_apcorr
          , zcountinputs
          , zvariance
          , zclassification_extendedness, zflags_pixel_edge, zflags_pixel_interpolated_any, zflags_pixel_interpolated_center, zflags_pixel_saturated_any, zflags_pixel_saturated_center, zflags_pixel_cr_any, zflags_pixel_cr_center, zflags_pixel_bad, zflags_pixel_suspect_any, zflags_pixel_suspect_center, zflags_pixel_offimage, zflags_pixel_bright_object_center, zflags_pixel_clipped_any, zflags_pixel_bright_object_any
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
          , yflux_psf_apcorr, yflux_psf_apcorr_err, yflux_psf_flags, yflux_psf_flags_apcorr, yflux_kron, ymag_kron, yflux_kron_err, ymag_kron_err
          , yflux_kron_radius, yflux_kron_radiusforradius, yflux_kron_psfradius, yflux_kron_apcorr, yflux_kron_apcorr_err, yflux_kron_flags, yflux_kron_flags_edge, yflux_kron_flags_radius, yflux_kron_flags_smallradius, yflux_kron_flags_usedminimumradius, yflux_kron_flags_usedpsfradius, yflux_kron_flags_badshape, yflux_kron_flags_apcorr
          , yflux_aperture10
          , ymag_aperture10
          , yflux_aperture15
          , ymag_aperture15
          , yflux_aperture20
          , ymag_aperture20
          , yflux_aperture30
          , ymag_aperture30
          , yflux_aperture40
          , ymag_aperture40
          , yflux_aperture57
          , ymag_aperture57
          , yflux_aperture84
          , ymag_aperture84
          , yflux_aperture118
          , ymag_aperture118
          , yflux_aperture168
          , ymag_aperture168
          , yflux_aperture235
          , ymag_aperture235
          , yflux_aperture10_err
          , ymag_aperture10_err
          , yflux_aperture15_err
          , ymag_aperture15_err
          , yflux_aperture20_err
          , ymag_aperture20_err
          , yflux_aperture30_err
          , ymag_aperture30_err
          , yflux_aperture40_err
          , ymag_aperture40_err
          , yflux_aperture57_err
          , ymag_aperture57_err
          , yflux_aperture84_err
          , ymag_aperture84_err
          , yflux_aperture118_err
          , ymag_aperture118_err
          , yflux_aperture168_err
          , ymag_aperture168_err
          , yflux_aperture235_err
          , ymag_aperture235_err
          , yflux_aperture10_ninterpolatedpixel, yflux_aperture15_ninterpolatedpixel, yflux_aperture20_ninterpolatedpixel, yflux_aperture30_ninterpolatedpixel, yflux_aperture40_ninterpolatedpixel, yflux_aperture57_ninterpolatedpixel, yflux_aperture84_ninterpolatedpixel, yflux_aperture118_ninterpolatedpixel, yflux_aperture168_ninterpolatedpixel, yflux_aperture235_ninterpolatedpixel, yflux_aperture_nprofile, yflux_aperture_flags
          , ycentroid_naive_ra, ycentroid_naive_dec, ycentroid_naive_flags, ycentroid_sdss_ra, ycentroid_sdss_dec, ycentroid_sdss_err_11, ycentroid_sdss_err_22, ycentroid_sdss_flags
          , ymultishapelet_psf_inner0, ymultishapelet_psf_inner1, ymultishapelet_psf_inner2, ymultishapelet_psf_inner3, ymultishapelet_psf_inner4, ymultishapelet_psf_inner5, ymultishapelet_psf_outer0, ymultishapelet_psf_outer1, ymultishapelet_psf_outer2, ymultishapelet_psf_ellipse_11, ymultishapelet_psf_ellipse_22, ymultishapelet_psf_ellipse_12, ymultishapelet_psf_chisq, ymultishapelet_psf_integral, ymultishapelet_psf_flags, ymultishapelet_psf_flags_maxiter, ymultishapelet_psf_flags_tinystep, ymultishapelet_psf_flags_constraint_r, ymultishapelet_psf_flags_constraint_q
          , yshape_sdss_11, yshape_sdss_22, yshape_sdss_12, yshape_sdss_err_11_11, yshape_sdss_err_22_22, yshape_sdss_err_12_12, yshape_sdss_centroid_ra, yshape_sdss_centroid_dec, yshape_sdss_psf_11, yshape_sdss_psf_22, yshape_sdss_psf_12, yshape_sdss_flags, yshape_sdss_centroid_flags, yshape_sdss_flags_unweightedbad, yshape_sdss_flags_unweighted, yshape_sdss_flags_shift, yshape_sdss_flags_maxiter, yshape_sdss_flags_psf
          , ycmodel_initial_flux, ycmodel_initial_mag, ycmodel_initial_flux_err, ycmodel_initial_mag_err, ycmodel_initial_flux_inner, ycmodel_initial_mag_inner, ycmodel_exp_flux, ycmodel_exp_mag, ycmodel_exp_flux_err, ycmodel_exp_mag_err, ycmodel_exp_flux_inner, ycmodel_exp_mag_inner, ycmodel_dev_flux, ycmodel_dev_mag, ycmodel_dev_flux_err, ycmodel_dev_mag_err, ycmodel_dev_flux_inner, ycmodel_dev_mag_inner, ycmodel_center_ra, ycmodel_center_dec, ycmodel_flux, ycmodel_mag, ycmodel_flux_err, ycmodel_mag_err, ycmodel_flux_inner, ycmodel_mag_inner, ycmodel_fracdev, ycmodel_objective, ycmodel_dev_flux_apcorr, ycmodel_dev_flux_apcorr_err, ycmodel_exp_flux_apcorr, ycmodel_exp_flux_apcorr_err, ycmodel_flux_apcorr, ycmodel_flux_apcorr_err, ycmodel_initial_flux_flags, ycmodel_initial_flags_badreference, ycmodel_initial_flags_numericerror, ycmodel_exp_flux_flags, ycmodel_exp_flags_badreference, ycmodel_exp_flags_numericerror, ycmodel_dev_flux_flags, ycmodel_dev_flags_badreference, ycmodel_dev_flags_numericerror, ycmodel_flux_flags, ycmodel_flags_region_maxarea, ycmodel_flags_region_maxbadpixelfraction, ycmodel_flags_badreference, ycmodel_flags_nopsf, ycmodel_flags_nowcs, ycmodel_flags_nocalib, ycmodel_flags_badcentroid, ycmodel_dev_flux_flags_apcorr, ycmodel_exp_flux_flags_apcorr, ycmodel_flux_flags_apcorr
          , ycountinputs
          , yvariance
          , yclassification_extendedness
          , yflags_pixel_edge, yflags_pixel_interpolated_any, yflags_pixel_interpolated_center, yflags_pixel_saturated_any, yflags_pixel_saturated_center, yflags_pixel_cr_any, yflags_pixel_cr_center, yflags_pixel_bad, yflags_pixel_suspect_any, yflags_pixel_suspect_center, yflags_pixel_offimage, yflags_pixel_bright_object_center, yflags_pixel_clipped_any, yflags_pixel_bright_object_any
        )
      }
  }
}
