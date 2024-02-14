import React, { useState, useEffect, useRef } from 'react';

const LoginForm = () => {
    
  const [form, setForm] = useState({
    userId: '',
    userPw: '',
  });

  const [message, setMessage] = useState('');

  const countRef = useRef(1);

  const onSubmit = (e) => {
    //preventDefault : 기본기능
    e.preventDefault();

    countRef.current++;
    console.log(countRef.current);

    // 검증 에러 메시지
    try {
      for (const key in form) {
        const message =
          (key === 'userId' ? '아이디' : '비밀번호') + '를 입력하세요.';
        if (!form[key].trim()) {  // 값이 없을 때 던짐
          throw new Error(message);
        }
      }
    } catch (err) {
      setMessage(err.message);
    }
  };

  // 비구조할당
  const { userId, userPw } = form;

  const onChange = (e) => {
    setForm({ ...form, [e.currentTarget.name]: e.currentTarget.value });
  };

  //let userIdEl = React.createRef();
  let userIdEl = useRef();

  // 처음 한번만 로딩
  useEffect(() => {
    //userIdEl.focus();
    //console.log(userIdEl.current);
    userIdEl.current.focus();
  }, [userIdEl]);  //변화감지를 위해

  return (
    <form onSubmit={onSubmit}>
      <dl>
        <dt>아이디</dt>
        <dd>
          <input
            //ref={(ref) => (userIdEl = ref)}
            ref={userIdEl}
            type="text"
            name="userId"  // 이걸통해 입력값을 일관적으로 업뎃
            onChange={onChange}
            value={userId}
          />
        </dd>
      </dl>
      <dl>ㄴ
        <dt>비밀번호</dt>
        <dd>
          <input
            type="password"
            name="userPw"  // 이걸통해 입력값을 일관적으로 업뎃
            onChange={onChange}
            value={userPw}
          />
        </dd>
      </dl>
      {message && <div>{message}</div>}
      <button type="submit">로그인</button>
    </form>
  );
};

export default LoginForm;