import { test, expect, request } from '@playwright/test';

const BASE_URL = 'http://localhost:8080/api/clients';
const uniqueEmail = `john.doe.${Date.now()}@test.com`;

test.describe('Client API', () => {

  test('GET /api/clients - повертає список клієнтів', async ({ request }) => {
    const response = await request.get(BASE_URL);
    expect(response.status()).toBe(200);
    const body = await response.json();
    expect(Array.isArray(body)).toBeTruthy();
  });

  test('POST /api/clients - створює клієнта', async ({ request }) => {
    const response = await request.post(BASE_URL, {
      data: {
        firstName: 'John',
        lastName: 'Doe',
        email: uniqueEmail,
        phone: '+380991234567'
      }
    });
    expect(response.status()).toBe(200);
    const body = await response.json();
    expect(body.firstName).toBe('John');
    expect(body.email).toBe(uniqueEmail);
  });

  test('GET /api/clients/{id} - повертає клієнта по id', async ({ request }) => {
    const response = await request.get(`${BASE_URL}/1`);
    expect([200, 404]).toContain(response.status());
  });

  test('DELETE /api/clients/{id} - видаляє клієнта', async ({ request }) => {
    // Спочатку створюємо клієнта
    const created = await request.post(BASE_URL, {
      data: {
        firstName: 'To',
        lastName: 'Delete',
        email: uniqueEmail
      }
    });
    const client = await created.json();

    // Потім видаляємо
    const deleted = await request.delete(`${BASE_URL}/${client.id}`);
    expect(deleted.status()).toBe(204);
  });

});