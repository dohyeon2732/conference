import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Result = () => {
  const navigate = useNavigate();
  const [state, setState] = useState(2); // 0: 준비중, 1: 의결, 2: 결과
  const [nameList, setNameList] = useState<string[]>([
    '김철수',
    '박영희',
    '이민호',
    '최지우',
    '김철수',
    '박영희',
    '이민호',
    '최지김우',
    '김철수',
    '박영희',
    '이민호',
    '최지우',
  ]);

  useEffect(() => {
    document.body.className = 'pc_black';
  }, []);
  return (
    <div
      className={`flex flex-col min-h-screen ${state === 0 ? 'justify-center' : 'justify-start'} `}
    >
      {state !== 0 && (
        <div className="flex flex-col w-screen px-20 pt-15 ">
          <div className="flex flex-row justify-between items-center mb-10">
            <div
              className={`flex flex-col gap-2 ${state === 1 ? '' : 'invisible'}`}
            >
              <div className="flex felx-row gap-4.5 items-center">
                <div className="w-[30px] h-[30px]  bg-[#57AA5A] rounded-full"></div>
                <p className="text-2xl font-semibold text-[#57AA5A]">찬성</p>
              </div>
              <div className="flex felx-row gap-4.5 items-center">
                <div className="w-[30px] h-[30px]  bg-[#F74040] rounded-full"></div>
                <p className="text-2xl font-semibold text-[#F74040]">반대</p>
              </div>
              <div className="flex felx-row gap-4.5 items-center">
                <div className="w-[30px] h-[30px]  bg-[#FBA650] rounded-full"></div>
                <p className="text-2xl font-semibold text-[#FBA650]">기권</p>
              </div>
              <div className="flex felx-row gap-4.5 items-center">
                <div className="w-[30px] h-[30px]  bg-[#FFFFFF] rounded-full"></div>
                <p className="text-2xl font-semibold text-[#FFFFFF]">미투표</p>
              </div>
            </div>
            <div className="flex flex-col gap-4 justify-center items-center">
              <p className="text-3xl font-semibold">
                2026학년도 상반기 정기 전체학생대표자회의
              </p>
              <p className=" text-4xl font-bold">
                {state === 2 ? '의결 결과' : '의결'}
              </p>
              <p className="text-2xl font-semibold">
                이과대학 2026학년도 하반기 결산안 및 저쩌고 승인의 건.
              </p>
            </div>
            <div>
              <button
                onClick={() => navigate('/manager/agendalist')}
                className="bg-[#A3A3A3] text-white text-xl font-semibold rounded-lg px-4 py-2"
              >
                나가기
              </button>
            </div>
          </div>
          {state === 1 && (
            <div className="grid grid-cols-14 gap-4">
              {nameList.map((name, index) => (
                <p key={index} className="text-xl font-semibold">
                  {name}
                </p>
              ))}
            </div>
          )}

          {state === 2 && (
            <div className="flex flex-col gap-10 justify-center items-center mt-20">
              <p className="text-white text-6xl font-bold">의결권 00명</p>
              <div className="flex flex-col gap-5">
                <p className="text-[#57AA5A] text-6xl font-bold">찬성 00명</p>
                <p className="text-[#F74040] text-6xl font-bold">반대 00명</p>
                <p className="text-[#FBA650] text-6xl font-bold">기권 00명</p>
              </div>
            </div>
          )}
        </div>
      )}
      {state === 0 && (
        <div className="flex flex-col justify-center items-center">
          <p className="text-3xl font-semibold">
            2026학년도 상반기 정기 전체학생대표자회의
          </p>
          <p className=" text-4xl font-bold">의결 준비 중</p>
        </div>
      )}
    </div>
  );
};

export default Result;
