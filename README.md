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
1. hoge
2. hoge

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

2. 各種フィルタの計測値を次元とした際の異常検知

---
## 使用しているパラメータ
### データファイル
> src/main/scala/ReadData.scala
* 入力データのファイル
    - l.32 `./src/resources/tmp/%s.csv` :  全データを分割したファイル（%s = 0,...,分割数）
    - l.39 `./src/resources/tmp/all.csv` : デフォルトで読み込む全データのファイル
* 各データファイルを読むための関数
    - l.65~91

> src/main/scala/uadfApp.scala
* 

> src/main/scala/Evaluate.scala
* 結果の評価の出力
    - l.22 ~ 30 : ファイルの設定関数
        1. 正解データの閲覧のためのディレクトリ指定を行うデータ名（ディレクトリ名）
        2. file_{} : 手法ごとの実験結果の格納用のファイル
        3. {}_ans : 分析アプリケーションごとの正解を格納しているファイル

### 分析に関するパラメータ
> src/main/scala/uadfApp.scala
* l.27 ~ 32 : 実験用のパラメータ
* l.37 ~ 40 : クエリのパラメータ
* l.118 ~ 121 : データの選択，手法の選択
* l.126, 128 : 繰り返しのパラメータ，同じ設定での計測回数
* l.233, 359 : フィルタに使用する部分データの属性名
