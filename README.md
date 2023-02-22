# [BIMbox](http://bimbox-web.com/BIMbox/) 
   BIMboxはシェアハウス・共有施設などで使える小規模なコミュニティSNSです。<br>
   掲示板機能、ダイレクトメッセージ機能、ユーザー検索機能、ファイル共有機能などがあります。<br>
   また、自分のプロフィールに趣味を登録しておくと趣味に合致するユーザーをサジェストします。ユーザー間のリアルタイムなダイレクトメッセージなども可能です。\
   <br>
   [紹介動画はこちら（YouTube）](https://youtu.be/mAp2edULuEI) 
　
## 制作背景
  ***「人間の幸福度は、友人関係の多さで決まります。」*** <br>
  ハーバード大学が1938年より行った「成人発達研究」の調査（This 75-Year Harvard Study Found the 1 Secret to Leading a Fulfilling Life）では、ボストンで育った成人とハーバード大学の卒業生の合計700人に対し75年の間追跡調査を実施し「人間の幸福度とその要因」を明らかにしました。<br>
  この研究では、血液サンプルや脳スキャンなどもを用いて調査を実施し、結果、研究チームは次のように結論づけました。<br>
	***"The clearest message that we get from this 75-year study is this: Good relationships keep us happier and healthier. Period."***<br>
	（訳）｢75年間におよぶこの研究が明確に示しているポイントは、良い人間関係が私たちの幸福と健康を高めてくれるということです。これが結論です。｣<br>
	<br>
　具体的に言うと、この研究では頼れる人が傍にいるという環境には以下の3つの効果が期待されると結論づけています。<br>
  1. 神経系が緊張から解放される。
  2. 脳の健康が保たれる期間が長くなる。
  3. 心と体の苦痛が和らげられる。
  <br>
　またこの研究は、孤独を感じている人は肉体的な健康が早くに衰え、短命である傾向が強いことも明確に示しています。<br>

　ふと、私たちの生活に目を落としてみると、会社・シェアハウス・施設などといったような、共同作業・共同生活といった場で「近くに人は存在するんだけれども、中々友好関係を広められない」といったケースは多いのではないでしょうか。<br>
　もし、貴方が自信が幸福になる為に生きているのであれば、このアプリを通じてより多くの人と出会い、友好関係を広げる手助けになればと思います。その思いでこのサービスを開発しました。
<br><br>

# URL
【サイトURL】
http://bimbox-web.com/BIMbox/
<br>
【紹介動画】
https://youtu.be/mAp2edULuEI
<br>
【キャプチャ】
https://www.dropbox.com/scl/fo/5kbkzmozf1a2z6l1ot2lm/h?dl=0&rlkey=4eairhsg8kuhl8pcflect0fse
<br><br>

# Overview
1. **ログイン画面**
   + 会員登録ができます。
   + ログインができます。
2. **ホーム画面**
   + 各画面の説明があります。
   + 広告が乗ります。
3. **ユーザーリスト一覧画面**
   + ユーザーをクリックするとカードが反転して詳細を閲覧できます。
   + ユーザーに対してお気に入りの登録ができます。
4. **タイムライン画面**
   + 掲示板のようにトピックを作成できます。
   + トピックに対し投稿や返信を載せることができます。
5. **ダイレクトメッセージ画面**
   + ユーザーを指定し、チャットルームでダイレクトメッセージを送る事ができます。
   + 自分のメッセージの削除が行えます。（削除されたことは相手に通知されます。）
   + 趣味の合うユーザーをサジェストします。
<br><br>

# Description
下記の3つ機能に対しそれぞれユーザー権限が「**User,Manager,Admin**」で3種類あり利用できる機能を制限しています。
<br>

1. ***ユーザーリスト一覧画面***
   1. 全て空白の場合は全件検索を行います。
      - 入力値がある場合、その値であいまい検索を行います。
   2. ユーザーを押下すると、プロフィールが表示されます。
      - ログイン中のユーザー権限によって処理を制御しています。
        | 権限		| 変更		| ユーザー削除     | 
        |:---:		|:---:		|:---:          |
        | **User**	| 自身の情報のみ〇 	| ✕      	|
        | **Manager**	| 自身の情報のみ〇	| 自分の情報以外〇 	|
        | **Admin**	| 全て〇		| 自分の情報以外〇	| 
        
<br>
        
2. ***タイムライン画面***
   1. トピックを作成することができます。
   2. 作成されたトピックに対して、投稿をする事ができます。
   3. 投稿に対して、**Like・Bad** ボタンを押し評価を付けることができます。<br>
      - 評価は、1ユーザー、1つの投稿に対し、**Like・Bad** のいずれか1件まで）
   4. トピックや投稿を編集・削除することができます。
      - ログイン中のユーザー権限によって処理を制御しています。
        | 権限         | 編集                        | 削除                        | 
        |:-----------:|:-----------------:          |  :--------------:            |
        | **User**    | 自身の投稿・トピックのみ〇   | 自身の投稿・トピックのみ〇   |
        | **Manager** | 自身の投稿・トピックのみ〇   | 全て〇                       |
        | **Admin**   | 全て〇                      | 全て〇                       | 
<br><br>     
       
 # Requirement 
 * Java 11 
 * Sprig Boot - 2.5.4
 * springsecurity5
 * Gradle - 7.1.1
 * mybatis - 2.1.4'
<br><br>

# Usage
1. DDLファイルのCREATE文を実行し各テーブルを作成
2. DMLファイルのインサート文を実行し、初期データを作成
3. eclispeでgradleプロジェクトをビルドし実行
   + Eclipseにbuildshipプラグインをインストール<br>
     (Pleiades4.7.2以降は不要)
   + プロジェクト右クリック ⇒ 構成 ⇒ Gradleネーチャーの追加
   + build.gradleの作成
     + プロジェクト右クリック ⇒ Gradle ⇒ Gradleプロジェクトのリフレッシュ
     + 自動的にeclipseがプロジェクトを認識してパッケージビューに依存するプロジェクトとして追加される
4. Spring boot プロジェクトの実行
<br><br>

# Author
* Kouya Ajima
<br><br>

# License
[MIT license](https://en.wikipedia.org/wiki/MIT_License).


