#write down run time to log file
echo `date` | cat >> ~/cron/syncDownLog
#random
mv ~/Downloads/*.mp4 ~/streamPi/youtube
mv ~/Downloads/*.flv ~/streamPi/youtube
mv ~/Downloads/*.mp3 ~/streamPi
rsync ~/streamPi/*.mp3  ~/Desktop/toAce/lappyMusic
mv ~/Downloads/*.jpg ~/funny
mv ~/Downloads/*.gif ~/funny
mv ~/Downloads/*.png ~/funny

#to be sent to phone
rsync ~/funny/*.jpg ~/Desktop/toAce/lol2
rsync ~/funny/*.gif ~/Desktop/toAce/lol2
rsync ~/funny/*.png ~/Desktop/toAce/lol2
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