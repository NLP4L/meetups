// インデックスディレクトリ
val indexDir = "/tmp/index-ldcc"
// インデックススキーマ
val schema = SchemaLoader.loadFile("examples/schema/ldcc.conf")
// インデックスリーダー
val reader = IReader(indexDir, schema)

// ドキュメントID 100 のTF文書ベクトルを作る
TFIDF.tfVector(reader, "body", 100)

// ドキュメントID 100 のTFIDF文書ベクトルを作る
TFIDF.tfIdfVector(reader, "body", 100)
