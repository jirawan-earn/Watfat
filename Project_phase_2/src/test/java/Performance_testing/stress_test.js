import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
    stages: [
        { duration: '1m', target: 50 },  // ramp up to 50 users in 1 minute
        { duration: '3m', target: 50 },  // maintain 50 users for 3 minutes
        { duration: '1m', target: 0 },   // ramp down to 0 users
    ],
};

export default function () {
    let response = http.get('http://45.136.236.146:8081/');
    check(response, {
        'status is 200': (r) => r.status === 200,
    });
    sleep(1);
}

//Stress Testing: ทดสอบด้วยการเพิ่มจำนวนผู้ใช้สูงสุด 50 คน