############################################################################
###    このスクリプトは、指定されたディレクトリ内のZIPファイルを解凍します。
###    
###    使用方法:
###    1. PowerShellを管理者として実行
###    2. スクリプトを実行
###    3. 解凍元のディレクトリ、サブディレクトリのパターン、解凍先のディレクトリを入力
###
###    例:
###     解凍元のディレクトリ: C:\Users\shotsato\Documents
###     サブディレクトリのパターン: 2025*
###     解凍先のディレクトリ: C:\Users\shotsato\Desktop
###########################################################################


# ユーザーから解凍元のディレクトリを入力させる
$baseDir = Read-Host "解凍元のディレクトリを入力してください (例: C:\Users\shotsato\Documents)"

# ユーザーからサブディレクトリのパターンを入力させる
$subDirPattern = Read-Host "サブディレクトリのパターンを入力してください (例: 2025*)"

# ユーザーから解凍先のディレクトリを入力させる
$destinationDir = Read-Host "解凍先のディレクトリを入力してください (例: C:\Users\shotsato\Desktop)"

# 解凍先のディレクトリが存在しない場合は作成
if (-Not (Test-Path -Path $destinationDir)) {
    New-Item -ItemType Directory -Path $destinationDir
}

# ppweb144_2025mmddフォルダを取得
$subDirs = Get-ChildItem -Path $baseDir -Directory -Filter $subDirPattern

# 各サブディレクトリ内のZIPファイルを解凍
foreach ($subDir in $subDirs) {
    $zipFiles = Get-ChildItem -Path $subDir.FullName -Filter "*.zip"
    
    foreach ($zipFile in $zipFiles) {
        $zipPath = $zipFile.FullName
        Write-Host "解凍中: $zipPath"
        
        # 解凍処理
        Expand-Archive -Path $zipPath -DestinationPath $destinationDir -Force
    }
}

Write-Host "すべてのZIPファイルが解凍されました。"
