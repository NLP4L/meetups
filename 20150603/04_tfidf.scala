// インデックスディレクトリ
val indexDir = "/tmp/index-ldcc"
// インデックススキーマ
val schema = SchemaLoader.loadFile("examples/schema/ldcc.conf")
// インデックスリーダー
val reader = IReader(indexDir, schema)

// ドキュメントID 100 のTF文書ベクトルを作る
val vec1 = TFIDF.tfVector(reader, "body", 100)
// ベクトルの素性(単語)一覧
vec1._1
// TFベクトル
vec1._2

// ドキュメントID 100 のTFIDF文書ベクトルを作る
val vec2 = TFIDF.tfIdfVector(reader, "body", 100)
// ベクトルの素性(単語)一覧
vec2._1
// TFベクトル
vec2._2
