#write down run time to log file
echo `date` | cat >> ~/cron/syncDown2Log
#random
mv ~/Downloads/*.mp4 ~/streamPi/youtube
mv ~/Downloads/*.flv ~/streamPi/youtube


mv ~/Downloads/*.mp3 ~/Desktop/toAce/lappyMusic
rsync ~/Desktop/toAce/lappyMusic/*.mp3 ~/streamPi

#to phone folder, and copy to funny folder so that when rsync runs from phone with --source-files-delete option it won't have to copy same files again and again
mv ~/Downloads/*.jpg ~/Desktop/toAce/lol2
mv ~/Downloads/*.gif ~/Desktop/toAce/lol2
mv ~/Downloads/*.png ~/Desktop/toAce/lol2
rsync ~/Desktop/toAce/lol2/*.jpg ~/funny
rsync ~/Desktop/toAce/lol2/*.gif ~/funny 
rsync ~/Desktop/toAce/lol2/*.png ~/funny

rsync ~/sms4log.txt ~/Desktop/toAce
rsync ~/meanings.txt ~/Desktop/toAce

#organize downloaded files
mv ~/Downloads/*.apk ~/Desktop/toAce/droidApps
mv ~/Downloads/*.pdf ~/Downloads/documents
mv ~/Downloads/*.PDF ~/Downloads/documents
mv ~/Downloads/*.docx ~/Downloads/documents
mv ~/Downloads/*.xls ~/Downloads/documents
mv ~/Downloads/*.txt ~/Downloads/documents
mv ~/Downloads/*.zip ~/Downloads/zipFiles
mv ~/Downloads/*.tar.gz ~/Downloads/zipFiles
mv ~/Downloads/*.7z ~/Downloads/zipFiles
mv ~/Downloads/*.rar ~/Downloads/zipFiles
mv ~/Downloads/*.gz ~/Downloads/zipFiles
mv ~/Downloads/*.tar.bz2 ~/Downloads/zipFiles
mv ~/Downloads/*.tar ~/Downloads/zipFiles
mv ~/Downloads/*.torrent ~/Downloads/torrent
mv ~/Downloads/*.deb ~/Downloads/debian
mv ~/Downloads/*.tex ~/Downloads/tex
mv ~/Downloads/*.epub ~/Downloads/ebooks


#organize codes
mv ~/Downloads/*.java ~/Downloads/codes/java
mv ~/Downloads/*.class ~/Downloads/codes/java
mv ~/Downloads/*.py ~/Downloads/codes/python
mv ~/Downloads/*.sh ~/Downloads/codes/shell
mv ~/Downloads/*.c ~/Downloads/codes/c
mv ~/Downloads/*.CPP ~/Downloads/codes/c
mv ~/Downloads/*.cpp ~/Downloads/codes/c

#backup-all-my-impcodes
rsync ~/.bash_aliases ~/Desktop/Dropbox/cronBackup/Customizations/alias #backup alias file
rsync -a ~/cron ~/Desktop/Dropbox/cronBackup/Customizations
rsync ~/*.py ~/Desktop/Dropbox/cronBackup/codes
rsync ~/*.java ~/Desktop/Dropbox/cronBackup/codes
rsync ~/*.sh ~/Desktop/Dropbox/cronBackup/codes
#rsync ~/masm611/Bin/*.asm ~/Desktop/Dropbox/cronBackup/sem-5/asm
#rsync ~/masm611/Bin/*.bat ~/Desktop/Dropbox/cronBackup/sem-5/asm
rsync ~/masm611/Bin/*.asm ~/School/Assembly
rsync ~/masm611/Bin/*.bat ~/School/Batch_Scripts
rsync ~/html/*.html ~/School/html
rsync -a ~/School ~/Desktop/Dropbox/School
rsync -a ~/School ~/Desktop/toAce
rsync -a ~/School ~/Desktop/Dropbox/spojShared
#rsync ~/html/*.html ~/Desktop/Dropbox/cronBackup/sem-5/html
#rsync -a ~/Desktop/Dropbox/cronBackup/sem-5 ~/Desktop/toAce
rsync -a ~/Desktop/Drop

#backup github code,first to phone folder,then to db
#python github-backup.py sjs7007 ~/Desktop/toAce/githubBackup
#rsync ~/Desktop/toAce/githubBackup -a ~/Desktop/Dropbox/cronBackup/githubBackup
python github-backup.py sjs7007 ~/Desktop/Dropbox/cronBackup/githubBackup
