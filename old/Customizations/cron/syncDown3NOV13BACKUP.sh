#write down run time to log file
echo `date` | cat >> ~/cron/syncDown3Log
#random
mv ~/Downloads/*.mp4 ~/Downloads/raspi/puppies
mv ~/Downloads/*.flv ~/Downloads/raspi/puppies


mv ~/Downloads/*.mp3 ~/Desktop/toAce/lappyMusic
rsync ~/Desktop/toAce/lappyMusic/*.mp3 ~/streamPi

#to phone folder, and copy to funny folder so that when rsync runs from phone with --source-files-delete option it won't have to copy same files again and again
mv ~/Downloads/*.jpg ~/Desktop/toAce/lol2
mv ~/Downloads/*.gif ~/Desktop/toAce/lol2
mv ~/Downloads/*.png ~/Desktop/toAce/lol2
rsync ~/Desktop/toAce/lol2/*.jpg ~/funny
rsync ~/Desktop/toAce/lol2/*.gif ~/funny 
rsync ~/Desktop/toAce/lol2/*.png ~/funny

rsync ~/Desktop/toAce/lol2/* ~/Desktop/Dropbox/0lol2

#organize downloaded files
mv ~/Downloads/*.apk ~/Desktop/toAce/droidApps
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
##downloaded+phone
mv ~/Downloads/*.pdf ~/Desktop/toAce/documents
mv ~/Downloads/*.PDF ~/Desktop/toAce/documents
mv ~/Downloads/*.docx ~/Desktop/toAce/documents
mv ~/Downloads/*.xls ~/Desktop/toAce/documents
mv ~/Downloads/*.txt ~/Desktop/toAce/documents
rsync -a ~/Desktop/toAce/documents ~/Downloads
#rsync -a ~/randomStuff ~/Desktop/toAce

#codes
rsync ~/masm611/Bin/*.asm ~/School/Assembly
rsync ~/masm611/Bin/*.bat ~/School/Batch_Scripts
rsync ~/html/*.html ~/School/html
rsync -a ~/School ~/Desktop/Dropbox/School
#rsync -a ~/School ~/Desktop/toAce
rsync -a ~/School ~/Desktop/Dropbox/spojShared
rsync -a ~/ritchie ~/Desktop/Dropbox/spojShared
#rsync -a ~/Downloads/documents ~/Desktop/toAce
#rsync -a ~/Desktop/Dropbox/spojShared/pracs ~/Desktop/toAce
#rsync -a ~/Desktop/Dropbox/0sem5 ~/Desktop/toAce

#customizations
rsync ~/.bash_aliases ~/School/Customizations/aliases
rsync ~/.vimrc ~/School/Customizations/vim
rsync -a ~/cron ~/School/Customizations

rsync ~/rsyncCamera/Camera/*.jpg ~/Desktop/Dropbox/Camera\ Uploads
