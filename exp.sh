#!/bin/sh
CONF32="spark-defaults-32.conf"	#設定ファイル

RESULT="`date "+%Y-%m-%d-%H%M%S".txt`"
touch $RESULT

date >> $RESULT
echo "$j $k start \n" >> $RESULT
#ここから
spark2-submit target/scala-2.11/udafapp_2.11-1.0.jar \
  --master yarn \
  --deploy-mode client \
  --properties-file ./$CONF32 \c
  --data-location hdfs://sv065:8020/user/matsumoto/joined/ >> $RESULT
#ここまでがspark実行のためのコマンド
date >> $RESULT
echo "finish" >> $RESULT
echo "\n" >> $RESULT
