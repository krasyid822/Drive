@echo off
setlocal enabledelayedexpansion

:: Mendapatkan format tanggal dan waktu untuk nama folder
set "DATETIME=%date:~-4,4%%date:~-7,2%%date:~-10,2%_%time:~0,2%%time:~3,2%"
set "DATETIME=%DATETIME: =0%"
set "BACKUP_DIR=%USERPROFILE%\Downloads\StartMenuBackup_%DATETIME%"

echo ===================================================
echo       Start Menu Backup Tool (Native Windows)
echo ===================================================
echo.
echo Membuat direktori backup di:
echo %BACKUP_DIR%
mkdir "%BACKUP_DIR%\User_Shortcuts" 2>nul
mkdir "%BACKUP_DIR%\System_Shortcuts" 2>nul

echo.
echo [1/4] Membackup User Shortcuts...
xcopy "%AppData%\Microsoft\Windows\Start Menu\Programs" "%BACKUP_DIR%\User_Shortcuts" /E /I /H /Y /C >nul
echo Selesai.

echo.
echo [2/4] Membackup System Shortcuts...
xcopy "%ProgramData%\Microsoft\Windows\Start Menu\Programs" "%BACKUP_DIR%\System_Shortcuts" /E /I /H /Y /C >nul
echo Selesai.

echo.
echo [3/4] Mengekspor Start Menu Layout (XML)...
powershell -NoProfile -ExecutionPolicy Bypass -Command "Export-StartLayout -Path '%BACKUP_DIR%\StartLayout.xml'"
echo Selesai.

echo.
echo [4/4] Membuat File Petunjuk Pemulihan (Petunjuk_Restore.md)...
(
echo ### Cara Melakukan Restore ^(Pemulihan^)
echo.
echo **1. Mengembalikan Shortcut:**
echo Cukup salin kembali file-file `.lnk` yang sudah di-*backup* ke dua direktori target ^(%AppData%\Microsoft\Windows\Start Menu\Programs dan %ProgramData%\Microsoft\Windows\Start Menu\Programs^).
echo.
echo **2. Mengembalikan Konfigurasi Layout ^(XML^):**
echo Untuk menerapkan kembali file XML, cara paling konsisten yang tidak tertimpa oleh *background services* adalah melalui *Group Policy Editor* ^(gpedit.msc^).
echo.
echo 1. Tekan Win + R, ketik gpedit.msc, lalu tekan Enter.
echo 2. Navigasi ke jalur berikut:
echo    User Configuration ^> Administrative Templates ^> Start Menu and Taskbar
echo 3. Cari kebijakan ^(policy^) bernama **Start Layout** di panel sebelah kanan, lalu klik dua kali.
echo 4. Pilih **Enabled**.
echo 5. Pada kolom *Start Layout File*, masukkan *path* absolut menuju file XML hasil *backup* Anda ^(contoh: %BACKUP_DIR%\StartLayout.xml^).
echo 6. Klik **Apply** dan **OK**.
echo 7. *Restart* proses Windows Explorer melalui Task Manager atau *restart* komputer Anda.
echo.
echo *Catatan teknis:* Saat *Start Layout* diaktifkan melalui Group Policy, Start Menu Anda akan terkunci sesuai dengan file XML tersebut ^(Anda tidak bisa menggeser ikon secara manual^). Jika Anda hanya ingin menerapkannya sekali lalu ingin memodifikasinya lagi, Anda bisa mengatur ulang status *policy* tadi kembali ke **Not Configured** setelah layout berhasil dimuat.
) > "%BACKUP_DIR%\Petunjuk_Restore.md"
echo Selesai.

echo.
echo ===================================================
echo Backup Berhasil! 
echo Semua data aman di folder %BACKUP_DIR% Anda.
echo ===================================================
pause