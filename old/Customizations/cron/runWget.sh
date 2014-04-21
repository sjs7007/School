echo `date` >> ~/cron/runWgetLog

cd ~/CourseraVids/Algorithms
python ~/cron/wgetFinal.py https://class.coursera.org/algo-004/lecture/index

cd ~/CourseraVids/Startup
python ~/cron/wgetFinal.py https://class.coursera.org/startup-001/lecture/index
