#write down run time to log file
echo `date` | cat >> ~/cron/syncDown3Log

#GRE
#rsync --partial --progress -h -a ~/Desktop/Dropbox/00GRE ~/Desktop/toAce/GRE

#lab codes
cp `find /home/shin/School/labs -name "*.txt"` /home/shin/School/labs/textCombinedAll ; rm /home/shin/School/labs/textCombinedAll/end.txt ; rm /home/shin/School/labs/textCombinedAll/oBegins.txt 
rsync -a --partial -h --progress /home/shin/School/labs/ /home/shin/Desktop/toAce/labs/
rsync -a --partial -h --progress /home/shin/School/labs/ /home/shin/Desktop/toAce/labs/
rsync -a --partial -h --progress /home/shin/School/labs/textCombinedAll/ /home/shin/Desktop/toAce/textCombinedAll/


#random
mv ~/Downloads/*.mp4 ~/Downloads/raspi/puppies
mv ~/Downloads/*.flv ~/Downloads/raspi/puppies


mv ~/Downloads/*.mp3 ~/Desktop/toAce/lappyMusic
rsync --partial --progress -h ~/Desktop/toAce/lappyMusic/*.mp3 ~/streamPi

#to phone folder, and copy to funny folder so that when rsync --partial --progress -h runs from phone with --source-files-delete option it won't have to copy same files again and again
mv ~/Downloads/*.jpg ~/Desktop/toAce/lol2
mv ~/Downloads/*.gif ~/Desktop/toAce/lol2
mv ~/Downloads/*.png ~/Desktop/toAce/lol2
rsync --partial --progress -h ~/Desktop/toAce/lol2/*.jpg ~/funny
rsync --partial --progress -h ~/Desktop/toAce/lol2/*.gif ~/funny 
rsync --partial --progress -h ~/Desktop/toAce/lol2/*.png ~/funny

rsync --partial --progress -h -a ~/funny ~/Desktop/Dropbox

rsync --partial --progress -h ~/Desktop/toAce/lol2/* ~/Desktop/Dropbox/0lol2

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
rsync --partial --progress -h -a ~/Desktop/toAce/documents ~/Downloads
#rsync --partial --progress -h -a ~/randomStuff ~/Desktop/toAce

#codes
#rsync --partial --progress -h ~/masm611/Bin/*.asm ~/School/Assembly
#rsync --partial --progress -h ~/masm611/Bin/*.bat ~/School/Batch_Scripts
#rsync --partial --progress -h ~/html/*.html ~/School/html
rsync --partial --progress -h -a ~/School ~/Desktop/Dropbox/School
#rsync --partial --progress -h -a ~/School ~/Desktop/toAce
rsync --partial --progress -h -a ~/School ~/Desktop/Dropbox/spojShared
#rsync --partial --progress -h -a ~/ritchie ~/Desktop/Dropbox/spojShared
#rsync --partial --progress -h -a ~/Downloads/documents ~/Desktop/toAce
#rsync --partial --progress -h -a ~/Desktop/Dropbox/spojShared/pracs ~/Desktop/toAce
#rsync --partial --progress -h -a ~/Desktop/Dropbox/0sem5 ~/Desktop/toAce

#customizations
rsync --partial --progress -h ~/.bash_aliases ~/School/Customizations/aliases
rsync --partial --progress -h ~/.vimrc ~/School/Customizations/vim
rsync --partial --progress -h -a ~/cron ~/School/Customizations

#essays
rsync --partial --progress -h -a ~/essayPractice ~/Desktop/toAce/essayPractice

rsync --partial --progress -h ~/rsyncCamera/Camera/*.jpg ~/Desktop/Dropbox/Camera\ Uploads


