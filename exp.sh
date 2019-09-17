#!/bin/sh
CONF32="spark-defaults-32.conf"	#設定ファイル

#all
for j in $CONF32
do
for ite in 1 ... 5
do
    RESULT="`date "+%Y-%m-%d-%H%M%S".txt`"
    touch $RESULT

    date >> $RESULT
    echo "$j $k start \n" >> $RESULT
		#ここから
    spark2-submit \
      --master yarn \
      --deploy-mode client \
      --properties-file ./$j \
      --class ??? \ #TODO: 実行クラス名の定義
      --data-location hdfs://sv065:8020/user/matsumoto/joined/ >> $RESULT
		#ここまでがspark実行のためのコマンド
    date >> $RESULT
    echo "finish" >> $RESULT
    echo "\n" >> $RESULT
    sleep 2m
  done
done

