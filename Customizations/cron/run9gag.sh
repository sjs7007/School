#write down run time to log file
echo `date` | cat >> ~/cron/9gagLog
rm -rf ~/rsync9gag
mkdir ~/rsync9gag
rsync ~/cron/9gagFinal.py ~/rsync9gag
cd ~/rsync9gag
python 9gagFinal.py