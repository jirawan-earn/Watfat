import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
    stages: [
        { duration: '1m', target: 500 },  // Ramp up to 500 users
        { duration: '2m', target: 500 },  // maintain 500 users
        { duration: '1m', target: 0 },    // Ramp down to 0 users
    ],
};

export default function () {
    let response = http.get('http://45.136.236.146:8081/');
    check(response, {
        'status is 200': (r) => r.status === 200,
    });
    sleep(1);
}


//Spike Testing: ทดสอบโดยการเพิ่มผู้ใช้อย่างรวดเร็วถึง 500 คน