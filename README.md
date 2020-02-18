# exdatamining

## Requirements
* spark2
* yarn 
* sbt (sv67 に install 済)

## Usage 
build.sbt が存在するディレクトリ（udaf/build.sbt）にて実行
```
$ sbt (clean) package  
```
上のコマンドを実行すると
`target/scala-(version)/udafapp_(version).jar` ファイルが作成される．
 
```sh
$ spark2-submit \
    --master yarn \
    --deploy-mode client \
    --properties-file spark-defaults-32-hist.conf \
    target/scala-2.11/udafapp_2.11-1.0.jar \ 
    [コマンドライン引数]
```
上のコマンドを `target/` が存在するディレクトリにて実行．\
注）spark-defaults-32-hist.conf はサンプルで使用する spark の実行環境の設定ファイル

### コマンドライン引数
実行方法のコマンド内における `[引数]` で指定できる変数とその記述フォーマット
1. データの種類：`data_type=???` \
    使用するデータの種類を指定 （`pdr1`, `pdr2`, `timeseries`）　\
    （デフォルト：`pdr1`）

2. 入力データファイル：`data_file=???` \
    異常検知を行うデータが格納されているデータファイル or データファイルが存在するディレクトリ \
    （デフォルト：`hdfs:///user/matsumoto/joined`）
    
3. 入力データフォーマット：`data_format=???` \
    parquet, csv, tsv などの使用する入力データファイル内のデータフォーマットを指定 \
    （デフォルト：`parquet`）

4. 探索件数 k ：`k=???` \
    異常と特定して，出力するグループ化属性の数を決定する変数 \
    （デフォルト：`10`）

5. グループ化属性：`subset=???` \
    異常検知を行う上での，比較を行う際にどの属性値でグループ化を行うかを決定する変数 \
    （デフォルト：`object_id`）
    
6. 分析に使用する属性：`target_column=???,???` or (`x=???` and `y=???`) \
    グループ化属性毎にどの測定値を使用して，異常検知を実行するかを決定する変数 \
    （デフォルト：`meas_rcmodel_mag`, `meas_rcmodel_mag_err`）

7. 分析する前処理となる条件設定：`where_clause=???` \
    全データから分析に使用するデータを抽出する条件（sql の where 句に相当） \
    （default : `meas_rcmodel_mag<24`）

    範囲指定の場合 : `???` = `meas_rcmodel_mag < 24 and meas_rcmodel_mag > 5`

8. サンプル率：`sampling_rate=???` \
    入力データからサンプリングを行う際のシード数 (0.0~1.0) \
    （デフォルト：`1.0`）

9. 出力先ファイル：`output_file=???` \
    top-k 件の特定した異常天体を書き出すファイルディレクトリ \
    （デフォルト：`results/`）

### 出力形式
* シェル上
    ```
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    all_time : Double
    pruning_rates : List()
    pruning_num : List()
    rap_time : List()
    --------------
    GOF_results: List()
    LOF_results: List()
    pruning_subset: List()
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    ```

* ファイル (csv) \
    `（ グループ化属性，分析に使用した属性，Outlier Flg ）`が 1 レコードとして出力
    
---

## Example
1. hci 初期データに対する異常検知
    * 実行コマンド 
        ```sh
        $ spark2-submit \
            --master yarn \
            --deploy-mode client \
            --properties-file spark-defaults-32-hist.conf \
            target/scala-2.11/udafapp_2.11-1.0.jar \
            subset=object_id \
            data_file=hdfs:///user/matsumoto/joined \
            data_format=parquet \
            target_column=meas_rcmodel_mag,meas_rcmodel_mag_err
        ```
    * 出力
        ```
        ```

2. 各種フィルタの計測値を次元とした際の異常検知
    * 実行コマンド
        ```sh
        $ spark2-submit \
            --master yarn \
            --deploy-mode client \
            --properties-file spark-defaults-32-hist.conf \
            target/scala-2.11/udafapp_2.11-1.0.jar \
            subset=object_id \
            data_file=hdfs:///user/matsumoto/joined \
            data_format=parquet \
            target_column=meas_rcmodel_mag,meas_zcmodel_mag_err
        ```
    
---
## Files
- Data Location : `hdfs:///user/matsumoto/joined/`
- spark-defaults-32-hist.conf : sparak を実行する際の設定ファイル
- build.sbt : scala コードのビルド時の設定ファイル
- src/main/scala
    - 
- results
    - （各種データ名のフォルダ）

## Parameters
- src/main/scala/uadfApp.scala \
    クエリのパラメータ（l.38 ~ 44）を直接変更してコンパイル

- src/main/scala/uadfApp.scala \
    where 句のような条件付けを行う変数の指定 \
    l.? ~ ? に存在する pass