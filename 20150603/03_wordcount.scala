// インデックスディレクトリ
val indexDir = "/tmp/index-ldcc"
// インデックススキーマ
val schema = SchemaLoader.loadFile("examples/schema/ldcc.conf")
// インデックスリーダー
val reader = IReader(indexDir, schema)

// body フィールドの頻出単語 Top20 (トータルTFベース)
reader.topTermsByTotalTermFreq("body",20).foreach(f => println(f._1, f._2, f._3))

// body フィールドの頻出単語 Top20 (DFベース)
reader.topTermsByDocFreq("body",20).foreach(f => println(f._1, f._2, f._3))

// body フィールドに含まれる "iphone", "テレビ", "新聞" という単語の出現回数を数え上げる
WordCounts.count(reader, "body", Set("iphone","テレビ","新聞"),reader.universalset())

// body フィールドに "iphone", "テレビ", "新聞" という単語を含むドキュメント数を数え上げる
WordCounts.countDF(reader, "body", Set("iphone","テレビ","新聞"))
