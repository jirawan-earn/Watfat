import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
    stages: [
        { duration: '1m', target: 10 }, // 1 minute, 10 users
        { duration: '2m', target: 10 }, // sustain 10 users for 2 minutes
    ],
};

export default function () {
    let response = http.get('http://45.136.236.146:8081/');
    check(response, {
        'status is 200': (r) => r.status === 200,
    });
    sleep(1);
}

//Average Load Test: ทดสอบการโหลดแบบปกติโดยมีผู้ใช้ 10 คนใช้งานพร้อมกันในช่วงเวลาหนึ่ง