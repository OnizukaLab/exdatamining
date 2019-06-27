ssh -i 秘密鍵のパス 153.127.109.50

ssh 172.16.1.175

sudo su postgres

psql -d pdr1

select count(*) from pdr1_wide.forced; -> 84,017,247
select count(*) from pdr1_wide.meas; -> 84,042,022
select count(*) from pdr1_wide.photoz_demp; -> 52,658,163

\COPY (select * from skymap limit 5) TO 'skymap.csv' WITH CSV HEADER DELIMITER ',';
\COPY (select * from pdr1_wide.forced) TO 'forced.csv' WITH CSV HEADER DELIMITER ',';
\COPY (select * from pdr1_wide.meas) TO 'meas.csv' WITH CSV HEADER DELIMITER ',';


# 5/27 打ち合わせ with 高田さん，古澤さん
明るさが変動
どういう制約があるかどうか

観測データなので，エラーの評価の仕方を間違えなければ…
	キャリブレーション
	S/N
	いんとりんじく（？）

銀河系内外両方のデータが色々と映っている．
大きさが近さを表せている（だいたい）

Target : 位置はそのままで明るさが変動しているものを探索

画像 → リスト（DB） → 

ノイズ
    1. 空の明るさによるノイズが一番大きい
    2. 視野の周辺の天体が映らない可能性
    3. 画像の歪み
    4. 積分型の観測だから，CCDのシャッターを開けてから閉めるまでのイベントはわからない．
    5. 基本的に補正をしたデータをリストとして保管しているが，想定していないノイズがあると補正できていない．

S/Nが全体的に暗い領域に対してどうするかという問題
- レンズによっては光の取集が70%程度になる
- →先ずは100%だという過程で分析?

S/Nの違いを考慮した分析
- ノイズのモデル化
- （実測値） = （装置のノイズ） ± （S/Nのノイズ） ± （その他のノイズ）

DB ⇄ 分析

同じ場所・同じ等級でoutlier detection 
→ その場合天体の形状が効いてくる（近くの天体）
→ エネルギー比：同じ日ではない可能性が大きいので引いていいのか

数千属性存在するからこそ，やったことはない（属性の提示は経験則的にできる）

1. HSC の初期データの挙動の図からエラーレートからの乖離
2. 変動天体の標準偏差の平均的な値を決めてやり．そこからの乖離
