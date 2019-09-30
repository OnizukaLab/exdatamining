# exdatamining

## コンパイル方法
* udaf/src/main/scala/*.scala を実行したい内容に書き換える
* build.sbt が存在するディレクトリ（udaf/build.sbt）にて `sbt package` を実行

## 実行方法
```
spark2-submit \
--master yarn \
--deploy-mode client \
--properties-file spark-defaults-32-hist.conf \
target/scala-2.11/udafapp_2.11-1.0.jar \
[引数]
```

## コマンドライン引数
1. データファイル：`data_file=???`
2. データフォーマット：`data_format=???`
3. 探索件数 k ：`k=???`
4. グループ化属性：`subset=???`
5. 分析に使用する属性：`target_column=???,???` or (`x=???` and `y=???`)

## ファイル構成
- Data Location : `hdfs:///user/matsumoto/joined/`
- src
    - main
        - scala : 
	- sql : pdr1 に関するサンプルの sql コード
- results
    - （各種データ名のフォルダ）
- build.sbt : scala コードのビルド時の設定ファイル

---

## 例
1. hci 初期データに対する異常検知
```
spark2-submit \
--master yarn \
--deploy-mode client \
--properties-file spark-defaults-32-hist.conf \
target/scala-2.11/udafapp_2.11-1.0.jar \
subset=object_id \
data_file=hdfs://user/matsumoto/joined \
data_format=parquet \
target_column=forced_rcmodel_mag,forced_rcmodel_mag_err
```

2. 各種フィルタの計測値を次元とした際の異常検知

---
## 使用しているパラメータ
> src/main/scala/uadfApp.scala
クエリのパラメータ（l.38 ~ 44）を直接変更してコンパイル