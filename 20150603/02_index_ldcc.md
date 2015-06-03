# コーパスをインデックスする

## ライブドアコーパスのダウンロード

```
$ cd ${nlp4l}
$ mkdir -p corpora/ldcc
$ cd ${nlp4l}/corpora/ldcc
$ wget http://www.rondhuit.com/download/ldcc-20140209.tar.gz
$ tar xvzf ldcc-20140209.tar.gz
```

${nlp4l} はNLP4Lのインストール先ディレクトリです。
Windowsユーザーの方は適宜読み替えてください。

または, Mac/Linuxユーザーの方は, 上記を一気に行う対話シェルのコマンドが使えます。

```
$ target/pack/bin/nlp4l

nlp4l> downloadLdcc
Successfully downloaded ldcc-20140209.tar.gz
Try to execute system command: tar xzf /Users/tomoko/repo/NLP4L/corpora/ldcc/ldcc-20140209.tar.gz -C /Users/tomoko/repo/NLP4L/corpora/ldcc
Success.
```

## ライブドアコーパスのインデックス

Windowsユーザーの方へ:
インデックス作成スクリプトの修正が2箇所必要になります。
```
// 1. インデックス作成先ディレクトリを適宜修正
val index = "/tmp/index-ldcc"

// 2. 30行目をコメントアウトし、32行目をアンコメント
// val ps: Array[String] = file.path.split(File.separator)
// for Windows
val ps: Array[String] = file.path.split("\\\\")

```

インデックス作成

```
$ cat examples/index_ldcc.scala
$ target/pack/bin/nlp4l

nlp4l> :load examples/index_ldcc.scala

nlp4l> open("/tmp/index-ldcc")
Index /tmp/index-ldcc was opened.
res7: org.nlp4l.core.RawReader = IndexReader(path='/tmp/index-ldcc',closed=false)

nlp4l> :q
```
